

/* First created by JCasGen Tue Oct 16 22:11:43 EDT 2012 */
package types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Unique Identifier for each sentence in the input file
 * Updated by JCasGen Wed Oct 17 11:31:22 EDT 2012
 * XML source: /host/Users/Kenton/11791/workspace/hw1-kwmurray/src/main/resources/ae/BasicAnalysisEngine.xml
 * @generated */
public class IndividualSentenceIdentifier extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(IndividualSentenceIdentifier.class);
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
  protected IndividualSentenceIdentifier() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public IndividualSentenceIdentifier(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public IndividualSentenceIdentifier(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public IndividualSentenceIdentifier(JCas jcas, int begin, int end) {
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
    if (IndividualSentenceIdentifier_Type.featOkTst && ((IndividualSentenceIdentifier_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "types.IndividualSentenceIdentifier");
    return jcasType.ll_cas.ll_getStringValue(addr, ((IndividualSentenceIdentifier_Type)jcasType).casFeatCode_SentenceID);}
    
  /** setter for SentenceID - sets  
   * @generated */
  public void setSentenceID(String v) {
    if (IndividualSentenceIdentifier_Type.featOkTst && ((IndividualSentenceIdentifier_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "types.IndividualSentenceIdentifier");
    jcasType.ll_cas.ll_setStringValue(addr, ((IndividualSentenceIdentifier_Type)jcasType).casFeatCode_SentenceID, v);}    
   
    
  //*--------------*
  //* Feature: SentenceString

  /** getter for SentenceString - gets 
   * @generated */
  public String getSentenceString() {
    if (IndividualSentenceIdentifier_Type.featOkTst && ((IndividualSentenceIdentifier_Type)jcasType).casFeat_SentenceString == null)
      jcasType.jcas.throwFeatMissing("SentenceString", "types.IndividualSentenceIdentifier");
    return jcasType.ll_cas.ll_getStringValue(addr, ((IndividualSentenceIdentifier_Type)jcasType).casFeatCode_SentenceString);}
    
  /** setter for SentenceString - sets  
   * @generated */
  public void setSentenceString(String v) {
    if (IndividualSentenceIdentifier_Type.featOkTst && ((IndividualSentenceIdentifier_Type)jcasType).casFeat_SentenceString == null)
      jcasType.jcas.throwFeatMissing("SentenceString", "types.IndividualSentenceIdentifier");
    jcasType.ll_cas.ll_setStringValue(addr, ((IndividualSentenceIdentifier_Type)jcasType).casFeatCode_SentenceString, v);}    
  }

    