package annotators;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import types.IndividualGeneIdentifier;

public class BasicAnalysisEngine extends JCasAnnotator_ImplBase {
  
  public static final String PARAM_GENE = "GenesFile";
  private HashMap<String, Integer> commonGenes;
  
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    // Create a Hash of Common genes
    
    commonGenes = new HashMap<String, Integer>();
    
    File collectionFile = new File(((String) getContext().getConfigParameterValue(PARAM_GENE)).trim());
    
    try
    {
      BufferedReader in = new BufferedReader(new FileReader(collectionFile));//new FileReader("/host/Users/Kenton/11791/workspace/hw1-kwmurray/src/main/resources/data/GoldStandardGenes.in"));
      // string buffer for file reading   
      String str;

      // reading line by line from file    
      while ((str = in.readLine()) != null)
      {
        //str.replaceAll();
        //" \t\n\r.<.>/?\";:[{]}\\|=+()!", true);
        
        
        if (!(commonGenes.containsKey(str)))
        { 
          commonGenes.put(str, 1);
        }
      }
      
      in.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    
    
    
    /*try {
      mMap = (StringMapResource) getContext().getResourceObject("AcronymTable");
    } catch (ResourceAccessException e) {
      throw new ResourceInitializationException(e);
    }*/
  }
  
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    String text = aJCas.getDocumentText();
    
    //Go through document word by word
    int pos = 0;
    StringTokenizer tokenizer = new StringTokenizer(text, /*"\\s+", true); //*/" \t\n\r.<.>/?\";:[{]}\\|=+()!", true);
    //Get the string ID as the first one
    String sid = "";
    if(tokenizer.hasMoreTokens())
    {
      sid = tokenizer.nextToken();
    }
    
    String nGram1 = "";
    String nGram2 = "";
    String nGram3 = "";
    String nGram4 = "";
    String nGram5 = "";
    String nGram6 = "";
    
    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
      // look up token in map to see if it is an acronym
      //String expandedForm = mMap.get(token);
      String expandedForm = token;
      if (expandedForm != null) {
        
        //Move values in nGrams
        nGram1 = nGram2;
        nGram2 = nGram3;
        nGram3 = nGram4;
        nGram4 = nGram5;
        nGram5 = nGram6;
        nGram6 = expandedForm;
        
        String one = nGram1;
        String two = one + " " + nGram2;
        String three = two + " " + nGram3;
        String four = three + " " + nGram4;
        String five = four + " " + nGram5;
        String six = five + " " + nGram6;
        
        if (commonGenes.containsKey(one))
        {
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(one);
          geneAnnot.setGeneStart(pos);
          geneAnnot.setGeneEnd(pos + token.length());
        }
        else if (commonGenes.containsKey(two))
        {
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(two);
          geneAnnot.setGeneStart(pos);
          geneAnnot.setGeneEnd(pos + token.length());
        }
        else if (commonGenes.containsKey(three))
        {
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(three);
          geneAnnot.setGeneStart(pos);
          geneAnnot.setGeneEnd(pos + token.length());
        }
        else if (commonGenes.containsKey(four))
        {
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(four);
          geneAnnot.setGeneStart(pos);
          geneAnnot.setGeneEnd(pos + token.length());
        }
        else if (commonGenes.containsKey(five))
        {
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(five);
          geneAnnot.setGeneStart(pos);
          geneAnnot.setGeneEnd(pos + token.length());
        }
        else if (commonGenes.containsKey(six))
        {
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(six);
          geneAnnot.setGeneStart(pos);
          geneAnnot.setGeneEnd(pos + token.length());
        }
        
        //System.out.println(expandedForm);
      }
      // incrememnt pos and go to next token
      pos += token.length();
    }

  }

}
