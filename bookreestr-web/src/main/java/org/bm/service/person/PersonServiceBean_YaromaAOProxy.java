package org.bm.service.person;

public class PersonServiceBean_YaromaAOProxy implements org.bm.service.person.PersonServiceBean_YaromaAO {
  private String _endpoint = null;
  private org.bm.service.person.PersonServiceBean_YaromaAO personServiceBean_YaromaAO = null;
  
  public PersonServiceBean_YaromaAOProxy() {
    _initPersonServiceBean_YaromaAOProxy();
  }
  
  public PersonServiceBean_YaromaAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceBean_YaromaAOProxy();
  }
  
  private void _initPersonServiceBean_YaromaAOProxy() {
    try {
      personServiceBean_YaromaAO = (new org.bm.service.person.PersonServiceBean_YaromaAOServiceLocator()).getPerson();
      if (personServiceBean_YaromaAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personServiceBean_YaromaAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personServiceBean_YaromaAO != null)
      ((javax.xml.rpc.Stub)personServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.bm.service.person.PersonServiceBean_YaromaAO getPersonServiceBean_YaromaAO() {
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    return personServiceBean_YaromaAO;
  }
  
  public org.bm.service.person.PersonYaromaAO[] getAllPersons() throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    return personServiceBean_YaromaAO.getAllPersons();
  }
  
  public org.bm.service.person.PersonYaromaAO getPerson(int arg0) throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    return personServiceBean_YaromaAO.getPerson(arg0);
  }
  
  public int addPerson(org.bm.service.person.PersonYaromaAO arg0) throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    return personServiceBean_YaromaAO.addPerson(arg0);
  }
  
  public void deletePerson(int arg0) throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    personServiceBean_YaromaAO.deletePerson(arg0);
  }
  
  public void updatePerson(org.bm.service.person.PersonYaromaAO arg0) throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    personServiceBean_YaromaAO.updatePerson(arg0);
  }
  
  public org.bm.service.person.PersonYaromaAO getByLogin(java.lang.String arg0) throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    return personServiceBean_YaromaAO.getByLogin(arg0);
  }
  
  public int getNewPersonId() throws java.rmi.RemoteException{
    if (personServiceBean_YaromaAO == null)
      _initPersonServiceBean_YaromaAOProxy();
    return personServiceBean_YaromaAO.getNewPersonId();
  }
  
  
}