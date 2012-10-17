
/* First created by JCasGen Wed Oct 17 12:02:43 EDT 2012 */
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

/** Unique Identifier for each gene found
 * Updated by JCasGen Wed Oct 17 19:27:40 EDT 2012
 * @generated */
public class IndividualGeneIdentifier_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (IndividualGeneIdentifier_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = IndividualGeneIdentifier_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new IndividualGeneIdentifier(addr, IndividualGeneIdentifier_Type.this);
  			   IndividualGeneIdentifier_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new IndividualGeneIdentifier(addr, IndividualGeneIdentifier_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = IndividualGeneIdentifier.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("types.IndividualGeneIdentifier");
 
  /** @generated */
  final Feature casFeat_SentenceID;
  /** @generated */
  final int     casFeatCode_SentenceID;
  /** @generated */ 
  public String getSentenceID(int addr) {
        if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "types.IndividualGeneIdentifier");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceID);
  }
  /** @generated */    
  public void setSentenceID(int addr, String v) {
        if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "types.IndividualGeneIdentifier");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_GeneString;
  /** @generated */
  final int     casFeatCode_GeneString;
  /** @generated */ 
  public String getGeneString(int addr) {
        if (featOkTst && casFeat_GeneString == null)
      jcas.throwFeatMissing("GeneString", "types.IndividualGeneIdentifier");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GeneString);
  }
  /** @generated */    
  public void setGeneString(int addr, String v) {
        if (featOkTst && casFeat_GeneString == null)
      jcas.throwFeatMissing("GeneString", "types.IndividualGeneIdentifier");
    ll_cas.ll_setStringValue(addr, casFeatCode_GeneString, v);}
    
  
 
  /** @generated */
  final Feature casFeat_GeneStart;
  /** @generated */
  final int     casFeatCode_GeneStart;
  /** @generated */ 
  public int getGeneStart(int addr) {
        if (featOkTst && casFeat_GeneStart == null)
      jcas.throwFeatMissing("GeneStart", "types.IndividualGeneIdentifier");
    return ll_cas.ll_getIntValue(addr, casFeatCode_GeneStart);
  }
  /** @generated */    
  public void setGeneStart(int addr, int v) {
        if (featOkTst && casFeat_GeneStart == null)
      jcas.throwFeatMissing("GeneStart", "types.IndividualGeneIdentifier");
    ll_cas.ll_setIntValue(addr, casFeatCode_GeneStart, v);}
    
  
 
  /** @generated */
  final Feature casFeat_GeneEnd;
  /** @generated */
  final int     casFeatCode_GeneEnd;
  /** @generated */ 
  public int getGeneEnd(int addr) {
        if (featOkTst && casFeat_GeneEnd == null)
      jcas.throwFeatMissing("GeneEnd", "types.IndividualGeneIdentifier");
    return ll_cas.ll_getIntValue(addr, casFeatCode_GeneEnd);
  }
  /** @generated */    
  public void setGeneEnd(int addr, int v) {
        if (featOkTst && casFeat_GeneEnd == null)
      jcas.throwFeatMissing("GeneEnd", "types.IndividualGeneIdentifier");
    ll_cas.ll_setIntValue(addr, casFeatCode_GeneEnd, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public IndividualGeneIdentifier_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_SentenceID = jcas.getRequiredFeatureDE(casType, "SentenceID", "uima.cas.String", featOkTst);
    casFeatCode_SentenceID  = (null == casFeat_SentenceID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SentenceID).getCode();

 
    casFeat_GeneString = jcas.getRequiredFeatureDE(casType, "GeneString", "uima.cas.String", featOkTst);
    casFeatCode_GeneString  = (null == casFeat_GeneString) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GeneString).getCode();

 
    casFeat_GeneStart = jcas.getRequiredFeatureDE(casType, "GeneStart", "uima.cas.Integer", featOkTst);
    casFeatCode_GeneStart  = (null == casFeat_GeneStart) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GeneStart).getCode();

 
    casFeat_GeneEnd = jcas.getRequiredFeatureDE(casType, "GeneEnd", "uima.cas.Integer", featOkTst);
    casFeatCode_GeneEnd  = (null == casFeat_GeneEnd) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GeneEnd).getCode();

  }
}



    