package consumers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;

import types.IndividualGeneIdentifier;
import types.IndividualSentenceIdentifier;

/**
 * Simple CAS Consumer. Writes to a file (given by a parameter).
 * Iterates over all the CASes and prints out in given format.
 * Everything should be stored in a CAS and a type, so no need to do anything but write
 */
public class GenesConsumed extends CasConsumer_ImplBase {

  /**
   * Name of configuration parameter that must be set to the path of a directory containing output files.
   */
  public static final String PARAM_OUTPUT = "OutputFile";

  
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    File collectionFile = new File(((String) getConfigParameterValue(PARAM_OUTPUT)).trim());
    
    BufferedWriter bufferedWriter = null;

    try {

      // Construct the BufferedWriter object
      bufferedWriter = new BufferedWriter(new FileWriter(collectionFile, true));

      
      FSIterator git = jcas.getAnnotationIndex(IndividualGeneIdentifier.type).iterator();
      if (git.hasNext())
      {
        IndividualGeneIdentifier indivGene = (IndividualGeneIdentifier) git.next();
        String gID = indivGene.getSentenceID();
        int gStart = indivGene.getGeneStart();
        int gEnd = indivGene.getGeneEnd();
        String theGene = indivGene.getGeneString();
        bufferedWriter.write(gID + "|" + gStart + " " + gEnd + "|" + theGene);
        bufferedWriter.newLine();
        System.out.println("Kenton says this is a gene: " + theGene);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Close the BufferedWriter
      try {
        if (bufferedWriter != null) {
          bufferedWriter.flush();
          bufferedWriter.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}
