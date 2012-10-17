package annotators;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

public class HMMNER extends JCasAnnotator_ImplBase {

  public static final String PARAM_LING = "LingpipeModel";
  
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub

    File modelFile = new File(((String) getContext().getConfigParameterValue(PARAM_LING)).trim());
    
    System.out.println("Reading chunker from file=" + modelFile);
    Chunker chunker;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);

      String text = aJCas.getDocumentText();

      // Go through document word by word
      int pos = 0;
 //     StringTokenizer tokenizer = new StringTokenizer(text, /* "\\s+", true);  */              " \t\n\r.<.>/?\";:[{]}\\|=+()!", true);
      // Get the string ID as the first one
      String sid = "";
//      if (tokenizer.hasMoreTokens()) {
  //      sid = tokenizer.nextToken();
    //  }

      //while (tokenizer.hasMoreTokens()) {
        //String token = tokenizer.nextToken();
        // look up token in map to see if it is an acronym
        // String expandedForm = mMap.get(token);
        String expandedForm = text;  
      //String expandedForm = token;
        if (expandedForm != null) {

          // for (int i = 1; i < args.length; ++i) {
          Chunking chunking = chunker.chunk(expandedForm);
          System.out.println("Chunking=" + chunking);
        }
      //}
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
