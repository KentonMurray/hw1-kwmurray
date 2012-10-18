package annotators;

import java.io.File;
import java.io.IOException;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import types.IndividualGeneIdentifier;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

/**
 * This class is an Analysis Engine that uses a simple HMM
 * from LingPipe to do NER. It reads in a trained model
 * and chunks the string for matches to Genes and Proteins.
 * It counts spaces in it's counts, so we have to remove them.
 *
 */
public class HMMNER extends JCasAnnotator_ImplBase {

  public static final String PARAM_LING = "LingpipeModel";
  
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
    File modelFile = new File(((String) getContext().getConfigParameterValue(PARAM_LING)).trim());
    
    System.out.println("Reading chunker from file=" + modelFile);
    Chunker chunker;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);

      String text = aJCas.getDocumentText();

      String[] docArray = text.split("\\s+");
      String headDoc = docArray[0];
      String tailDoc = "";
      int numSpaces = docArray.length;
      int spaceArray[] = new int[numSpaces];
      int positionSoFar = 0;
      if(numSpaces >= 2)
      {
        tailDoc = docArray[1];
        for(int i = 2; i < numSpaces; i++)
        {
          tailDoc = tailDoc + " " + docArray[i]; //Make one string
          spaceArray[i] = positionSoFar + (docArray[i].length()); //Location of Spaces
          positionSoFar = spaceArray[i];
        }
      }
      
      // Get the string ID as the first one
      String sid = headDoc;
      String expandedForm = tailDoc;  
      if (expandedForm != null) {

        Chunking chunking = chunker.chunk(expandedForm);

        for (Chunk chunked : chunking.chunkSet()) {
          int start = chunked.start();
          int end = chunked.end();
          String theGene = expandedForm.substring(start, end);


          int subtractFromStart = 0;
          int subtractFromEnd = 0;
                    
          //Remove Spaces from count
          for(int i = 0; i < spaceArray.length; i++)
          {
            if(start < spaceArray[i])
            {
              subtractFromStart = i - 2;
              break;
            }
          }
          for(int i = 0; i < spaceArray.length; i++)
          {
            if(end < spaceArray[i])
            {
              subtractFromEnd = i - 2;
              break;
            }
          }
          
          IndividualGeneIdentifier geneAnnot = new IndividualGeneIdentifier(aJCas, start, end);
          geneAnnot.addToIndexes();
          geneAnnot.setSentenceID(sid);
          geneAnnot.setGeneString(theGene);
          geneAnnot.setGeneStart(start - subtractFromStart);
          geneAnnot.setGeneEnd(end - subtractFromEnd);

          
          System.out.println(sid + "|" + (start - subtractFromStart) + " " + (end - subtractFromEnd) + "|" + theGene);

        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
