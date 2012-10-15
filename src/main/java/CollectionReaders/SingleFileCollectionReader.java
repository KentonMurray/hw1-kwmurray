package CollectionReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.DocumentAnnotation;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
//import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

/**
 * A simple collection reader that reads a single document from a command line parameter. It can be
 * configured with the following parameters:
 * <ul>
 * <li><code>InputDirectory</code> - path to directory containing files</li>
 * <li><code>Encoding</code> (optional) - character encoding of the input files</li>
 * <li><code>Language</code> (optional) - language of the input documents</li>
 * </ul>
 * 
 * 
 */
public class SingleFileCollectionReader extends CollectionReader_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory containing input
   * files.
   */
  public static final String PARAM_INPUT = "InputFile";//"sample.in";//"hw1.in";

  /**
   * Name of configuration parameter that contains the character encoding used by the input files.
   * If not specified, the default system encoding will be used.
   */
  //public static final String PARAM_ENCODING = "Encoding";

  /**
   * Name of optional configuration parameter that contains the language of the documents in the
   * input directory. If specified this information will be added to the CAS.
   */
  public static final String PARAM_LANGUAGE = "Language";

  
  private ArrayList<String> docsArray;

  //private String mEncoding;

  private String mLanguage;
  
  //private Boolean mRecursive;

  private int mCurrentIndex;
  
  private int mNumberOfLines;

  /**
   * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
   */
  public void initialize() throws ResourceInitializationException {
    File collectionFile = new File(((String) getConfigParameterValue(PARAM_INPUT)).trim());
    mLanguage  = (String) getConfigParameterValue(PARAM_LANGUAGE);
    mCurrentIndex = 0;
    mNumberOfLines = 0;
    
    docsArray = new ArrayList<String>();

    // if input file does not exist, throw exception
    if (!collectionFile.exists()) {
      throw new ResourceInitializationException(ResourceConfigurationException.MANDATORY_VALUE_MISSING,
              new Object[] { PARAM_INPUT, this.getMetaData().getName()});
    }
    
    FileReader fReader;
    try {
      fReader = new FileReader(collectionFile);
      BufferedReader bReader = new BufferedReader(fReader);
      String doc;
      while((doc = bReader.readLine()) != null) { 
        docsArray.add(doc);
        mNumberOfLines++;
      }
      fReader.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
  }
  
  
  /**
   * @see org.apache.uima.collection.CollectionReader#hasNext()
   */
  public boolean hasNext() {
    return mCurrentIndex < mNumberOfLines;
  }

  /**
   * @see org.apache.uima.collection.CollectionReader#getNext(org.apache.uima.cas.CAS)
   */
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }

    String doc;
    
    // I believe this should remove everything in the order we added
    doc = docsArray.remove(0);
    jcas.setDocumentText(doc); //put Document in CAS
    
    
    // set language if it was explicitly specified as a configuration parameter
    if (mLanguage != null) {
      ((DocumentAnnotation) jcas.getDocumentAnnotationFs()).setLanguage(mLanguage);
    }

    // Also store location of source document in CAS. This information is critical
    // if CAS Consumers will need to know where the original document contents are located.
    // For example, the Semantic Search CAS Indexer writes this information into the
    // search index that it creates, which allows applications that use the search index to
    // locate the documents that satisfy their semantic queries.
    SourceDocumentInformation srcDocInfo = new SourceDocumentInformation(jcas);
    //srcDocInfo.setUri(file.getAbsoluteFile().toURL().toString());
    srcDocInfo.setOffsetInSource(mCurrentIndex);//0);
    srcDocInfo.setDocumentSize((int) doc.length());
    //srcDocInfo.setLastSegment(mCurrentIndex == mFiles.size());
    srcDocInfo.addToIndexes();
    
    // increment the index of file we are reading
    mCurrentIndex++;
    
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#close()
   */
  public void close() throws IOException {
  }

  /**
   * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#getProgress()
   */
  public Progress[] getProgress() {
    return new Progress[] { new ProgressImpl(mCurrentIndex, mNumberOfLines, Progress.ENTITIES) };
  }

  /**
   * Gets the total number of documents that will be returned by this collection reader. This is not
   * part of the general collection reader interface.
   * 
   * @return the number of documents in the collection
   */
  public int getNumberOfDocuments() {
    return mNumberOfLines                                                                                                                                                                                                                                                                                                                                                                                                                                           ;
  }

}
