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
//import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;
//import org.apache.uima.tutorial.ex6.StringMapResource;
//import org.apache.uima.tutorial.UimaAcronym;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
//import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.DocumentAnnotation;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import org.apache.uima.collection.*;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.resource.*;
import org.apache.uima.*;
import org.apache.uima.resource.ConfigurationManager;
import org.apache.uima.resource.ConfigurableResource;
import org.apache.uima.resource.Resource;

import types.IndividualSentenceIdentifier;
import types.IndividualGeneIdentifier;

public class BasicAnalysisEngine extends JCasAnnotator_ImplBase {
  
  public static final String PARAM_GENE = "GenesFile";
  private HashMap<String, Integer> commonGenes;
  
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    // Create a Hash of Common genes
    
    commonGenes = new HashMap<String, Integer>();
    
    File collectionFile = new File(((String) getConfigParameterValue(PARAM_GENE)).trim());
    
    try
    {
      BufferedReader in = new BufferedReader(new FileReader("/Users/andrian/input.txt"));
      // string buffer for file reading   
      String str;

      // reading line by line from file    
      while ((str = in.readLine()) != null)
      {
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
    // TODO Auto-generated method stub
    String text = aJCas.getDocumentText();
    //System.out.println("Testing: " + text);
    
    //Go through document word by word
    int pos = 0;
    StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r.<.>/?\";:[{]}\\|=+()!", true);
    //Get the string ID as the first one
    String sid = "";
    if(tokenizer.hasMoreTokens())
    {
      sid = tokenizer.nextToken();
    }
    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
      // look up token in map to see if it is an acronym
      //String expandedForm = mMap.get(token);
      String expandedForm = token;
      if (expandedForm != null) {
        // create annotation
        IndividualSentenceIdentifier annot = new IndividualSentenceIdentifier(aJCas, pos, pos + token.length());
        IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, pos, pos + token.length());
        //UimaAcronym annot = new UimaAcronym(aJCas, pos, pos + token.length(), expandedForm);
        geneAnnot.addToIndexes();
        geneAnnot.setSentenceID(sid);
        annot.addToIndexes();
        annot.setSentenceID(sid);
        //System.out.println(expandedForm);
      }
      // incrememnt pos and go to next token
      pos += token.length();
    }

  }

}
