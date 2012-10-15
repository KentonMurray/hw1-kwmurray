package consumers;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;

public class GenesConsumed extends CasConsumer_ImplBase {

  @Override
  public void processCas(CAS aCAS/*arg0*/) throws ResourceProcessException {
    
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

  }

}
