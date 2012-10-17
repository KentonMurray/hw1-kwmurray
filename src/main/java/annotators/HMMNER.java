package annotators;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class HMMNER extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub

    System.out.println("Reading chunker from file=" + modelFile);
    Chunker chunker = (Chunker) AbstractExternalizable.readObject(modelFile);

    for (int i = 1; i < args.length; ++i) {
        Chunking chunking = chunker.chunk(args[i]);
        System.out.println("Chunking=" + chunking);
    }
    
  }

}
