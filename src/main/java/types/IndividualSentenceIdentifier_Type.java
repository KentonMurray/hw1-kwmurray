
/* First created by JCasGen Tue Oct 16 22:11:43 EDT 2012 */
package types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Unique Identifier for each sentence in the input file
 * Updated by JCasGen Wed Oct 17 11:31:22 EDT 2012
 * @generated */
public class IndividualSentenceIdentifier_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (IndividualSentenceIdentifier_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = IndividualSentenceIdentifier_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new IndividualSentenceIdentifier(addr, IndividualSentenceIdentifier_Type.this);
  			   IndividualSentenceIdentifier_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new IndividualSentenceIdentifier(addr, IndividualSentenceIdentifier_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = IndividualSentenceIdentifier.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("types.IndividualSentenceIdentifier");
 
  /** @generated */
  final Feature casFeat_SentenceID;
  /** @generated */
  final int     casFeatCode_SentenceID;
  /** @generated */ 
  public String getSentenceID(int addr) {
        if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "types.IndividualSentenceIdentifier");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceID);
  }
  /** @generated */    
  public void setSentenceID(int addr, String v) {
        if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "types.IndividualSentenceIdentifier");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_SentenceString;
  /** @generated */
  final int     casFeatCode_SentenceString;
  /** @generated */ 
  public String getSentenceString(int addr) {
        if (featOkTst && casFeat_SentenceString == null)
      jcas.throwFeatMissing("SentenceString", "types.IndividualSentenceIdentifier");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceString);
  }
  /** @generated */    
  public void setSentenceString(int addr, String v) {
        if (featOkTst && casFeat_SentenceString == null)
      jcas.throwFeatMissing("SentenceString", "types.IndividualSentenceIdentifier");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceString, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public IndividualSentenceIdentifier_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_SentenceID = jcas.getRequiredFeatureDE(casType, "SentenceID", "uima.cas.String", featOkTst);
    casFeatCode_SentenceID  = (null == casFeat_SentenceID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SentenceID).getCode();

 
    casFeat_SentenceString = jcas.getRequiredFeatureDE(casType, "SentenceString", "uima.cas.String", featOkTst);
    casFeatCode_SentenceString  = (null == casFeat_SentenceString) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SentenceString).getCode();

  }
}



    