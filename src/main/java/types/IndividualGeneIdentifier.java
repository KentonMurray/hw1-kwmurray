

/* First created by JCasGen Wed Oct 17 12:02:43 EDT 2012 */
package types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Unique Identifier for each gene found
 * Updated by JCasGen Wed Oct 17 19:27:40 EDT 2012
 * XML source: /host/Users/Kenton/11791/workspace/hw1-kwmurray/src/main/resources/types/individualGeneType.xml
 * @generated */
public class IndividualGeneIdentifier extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(IndividualGeneIdentifier.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected IndividualGeneIdentifier() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public IndividualGeneIdentifier(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public IndividualGeneIdentifier(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public IndividualGeneIdentifier(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: SentenceID

  /** getter for SentenceID - gets 
   * @generated */
  public String getSentenceID() {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "types.IndividualGeneIdentifier");
    return jcasType.ll_cas.ll_getStringValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_SentenceID);}
    
  /** setter for SentenceID - sets  
   * @generated */
  public void setSentenceID(String v) {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "types.IndividualGeneIdentifier");
    jcasType.ll_cas.ll_setStringValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_SentenceID, v);}    
   
    
  //*--------------*
  //* Feature: GeneString

  /** getter for GeneString - gets 
   * @generated */
  public String getGeneString() {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_GeneString == null)
      jcasType.jcas.throwFeatMissing("GeneString", "types.IndividualGeneIdentifier");
    return jcasType.ll_cas.ll_getStringValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_GeneString);}
    
  /** setter for GeneString - sets  
   * @generated */
  public void setGeneString(String v) {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_GeneString == null)
      jcasType.jcas.throwFeatMissing("GeneString", "types.IndividualGeneIdentifier");
    jcasType.ll_cas.ll_setStringValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_GeneString, v);}    
   
    
  //*--------------*
  //* Feature: GeneStart

  /** getter for GeneStart - gets 
   * @generated */
  public int getGeneStart() {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_GeneStart == null)
      jcasType.jcas.throwFeatMissing("GeneStart", "types.IndividualGeneIdentifier");
    return jcasType.ll_cas.ll_getIntValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_GeneStart);}
    
  /** setter for GeneStart - sets  
   * @generated */
  public void setGeneStart(int v) {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_GeneStart == null)
      jcasType.jcas.throwFeatMissing("GeneStart", "types.IndividualGeneIdentifier");
    jcasType.ll_cas.ll_setIntValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_GeneStart, v);}    
   
    
  //*--------------*
  //* Feature: GeneEnd

  /** getter for GeneEnd - gets 
   * @generated */
  public int getGeneEnd() {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_GeneEnd == null)
      jcasType.jcas.throwFeatMissing("GeneEnd", "types.IndividualGeneIdentifier");
    return jcasType.ll_cas.ll_getIntValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_GeneEnd);}
    
  /** setter for GeneEnd - sets  
   * @generated */
  public void setGeneEnd(int v) {
    if (IndividualGeneIdentifier_Type.featOkTst && ((IndividualGeneIdentifier_Type)jcasType).casFeat_GeneEnd == null)
      jcasType.jcas.throwFeatMissing("GeneEnd", "types.IndividualGeneIdentifier");
    jcasType.ll_cas.ll_setIntValue(addr, ((IndividualGeneIdentifier_Type)jcasType).casFeatCode_GeneEnd, v);}    
  }

    