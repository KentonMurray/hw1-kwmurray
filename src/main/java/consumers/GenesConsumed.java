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

public class GenesConsumed extends CasConsumer_ImplBase {

  /**
   * Name of configuration parameter that must be set to the path of a directory containing output files.
   */
  public static final String PARAM_OUTPUT = "OutputFile";

  
  @Override
  public void processCas(CAS aCAS/*arg0*/) throws ResourceProcessException {
    
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    //File outputDir = new File("data");
    //File outFile = new File(/*outputDir,*/ "hw1-kwmurray" + ".out");
    File collectionFile = new File(((String) getConfigParameterValue(PARAM_OUTPUT)).trim());
    //String modelFileName = "kwmurray";
    //File collectionFile = new File("/host/Users/Kenton/11791/workspace/hw1-kwmurray/src/main/resources/data/sample2.out");
    //System.out.println(jcas.toString());
    //System.out.println("Kenton");
    //System.out.println(jcas.getCas());
    
    //System.out.println(jcas.getDocumentText());
    
    BufferedWriter bufferedWriter = null;

    try {

      // Construct the BufferedWriter object
      bufferedWriter = new BufferedWriter(new FileWriter(collectionFile));

      // Start writing to the output stream
      bufferedWriter.write("Kenton");
      bufferedWriter.newLine();

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
    
    FSIterator fit = jcas.getAnnotationIndex(IndividualSentenceIdentifier.type).iterator();
    //System.out.println(fit.toString());
    
    if (fit.hasNext())
    {
      //System.out.println("Made it here");
      IndividualSentenceIdentifier indivToken = (IndividualSentenceIdentifier) fit.next();
      System.out.println(indivToken.getSentenceID());
    }
    
    FSIterator git = jcas.getAnnotationIndex(IndividualGeneIdentifier.type).iterator();
    if (git.hasNext())
    {
      IndividualGeneIdentifier indivGene = (IndividualGeneIdentifier) git.next();
      String gID = indivGene.getSentenceID();
    }
    
    /*try {
      writeXmi(jcas.getCas(), collectionFileoutFile, modelFileName);
    } catch (IOException e) {
      throw new ResourceProcessException(e);
    } catch (SAXException e) {
      throw new ResourceProcessException(e);
    }*/
    
  }

  /*private void writeXmi(CAS aCas, File name, String modelFileName) throws IOException, SAXException {
    FileOutputStream out = null;

    try {
      // write XMI
      out = new FileOutputStream(name);
      XmiCasSerializer ser = new XmiCasSerializer(aCas.getTypeSystem());
      XMLSerializer xmlSer = new XMLSerializer(out, false);
      ser.serialize(aCas, xmlSer.getContentHandler());
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }*/
  
}
