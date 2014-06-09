package org.bm.service.subject;

public class SubjectServiceBean_YaromaAOProxy implements org.bm.service.subject.SubjectServiceBean_YaromaAO {
  private String _endpoint = null;
  private org.bm.service.subject.SubjectServiceBean_YaromaAO subjectServiceBean_YaromaAO = null;
  
  public SubjectServiceBean_YaromaAOProxy() {
    _initSubjectServiceBean_YaromaAOProxy();
  }
  
  public SubjectServiceBean_YaromaAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initSubjectServiceBean_YaromaAOProxy();
  }
  
  private void _initSubjectServiceBean_YaromaAOProxy() {
    try {
      subjectServiceBean_YaromaAO = (new org.bm.service.subject.SubjectServiceBean_YaromaAOServiceLocator()).getSubject();
      if (subjectServiceBean_YaromaAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)subjectServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)subjectServiceBean_YaromaAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (subjectServiceBean_YaromaAO != null)
      ((javax.xml.rpc.Stub)subjectServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.bm.service.subject.SubjectServiceBean_YaromaAO getSubjectServiceBean_YaromaAO() {
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    return subjectServiceBean_YaromaAO;
  }
  
  public int addSubject(org.bm.service.subject.SubjectYaromaAO arg0) throws java.rmi.RemoteException{
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    return subjectServiceBean_YaromaAO.addSubject(arg0);
  }
  
  public void deleteSubject(int arg0) throws java.rmi.RemoteException{
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    subjectServiceBean_YaromaAO.deleteSubject(arg0);
  }
  
  public void updateSubject(org.bm.service.subject.SubjectYaromaAO arg0) throws java.rmi.RemoteException{
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    subjectServiceBean_YaromaAO.updateSubject(arg0);
  }
  
  public org.bm.service.subject.SubjectYaromaAO getSubject(int arg0) throws java.rmi.RemoteException{
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    return subjectServiceBean_YaromaAO.getSubject(arg0);
  }
  
  public org.bm.service.subject.SubjectYaromaAO[] getAllSubjects() throws java.rmi.RemoteException{
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    return subjectServiceBean_YaromaAO.getAllSubjects();
  }
  
  public int getNewSubjectId() throws java.rmi.RemoteException{
    if (subjectServiceBean_YaromaAO == null)
      _initSubjectServiceBean_YaromaAOProxy();
    return subjectServiceBean_YaromaAO.getNewSubjectId();
  }
  
  
}