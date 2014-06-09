package org.bm.service.reestr;

public class ReestrServiceBean_YaromaAOProxy implements org.bm.service.reestr.ReestrServiceBean_YaromaAO {
  private String _endpoint = null;
  private org.bm.service.reestr.ReestrServiceBean_YaromaAO reestrServiceBean_YaromaAO = null;
  
  public ReestrServiceBean_YaromaAOProxy() {
    _initReestrServiceBean_YaromaAOProxy();
  }
  
  public ReestrServiceBean_YaromaAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initReestrServiceBean_YaromaAOProxy();
  }
  
  private void _initReestrServiceBean_YaromaAOProxy() {
    try {
      reestrServiceBean_YaromaAO = (new org.bm.service.reestr.ReestrServiceBean_YaromaAOServiceLocator()).getReestr();
      if (reestrServiceBean_YaromaAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reestrServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reestrServiceBean_YaromaAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reestrServiceBean_YaromaAO != null)
      ((javax.xml.rpc.Stub)reestrServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.bm.service.reestr.ReestrServiceBean_YaromaAO getReestrServiceBean_YaromaAO() {
    if (reestrServiceBean_YaromaAO == null)
      _initReestrServiceBean_YaromaAOProxy();
    return reestrServiceBean_YaromaAO;
  }
  
  public void deleteReestr(int arg0) throws java.rmi.RemoteException{
    if (reestrServiceBean_YaromaAO == null)
      _initReestrServiceBean_YaromaAOProxy();
    reestrServiceBean_YaromaAO.deleteReestr(arg0);
  }
  
  public org.bm.service.reestr.ReestrYaromaAO getReestr(int arg0) throws java.rmi.RemoteException{
    if (reestrServiceBean_YaromaAO == null)
      _initReestrServiceBean_YaromaAOProxy();
    return reestrServiceBean_YaromaAO.getReestr(arg0);
  }
  
  public int addReestr(org.bm.service.reestr.ReestrYaromaAO arg0) throws java.rmi.RemoteException{
    if (reestrServiceBean_YaromaAO == null)
      _initReestrServiceBean_YaromaAOProxy();
    return reestrServiceBean_YaromaAO.addReestr(arg0);
  }
  
  public org.bm.service.reestr.ReestrYaromaAO[] getAllReestrs() throws java.rmi.RemoteException{
    if (reestrServiceBean_YaromaAO == null)
      _initReestrServiceBean_YaromaAOProxy();
    return reestrServiceBean_YaromaAO.getAllReestrs();
  }
  
  public void updateReestr(org.bm.service.reestr.ReestrYaromaAO arg0) throws java.rmi.RemoteException{
    if (reestrServiceBean_YaromaAO == null)
      _initReestrServiceBean_YaromaAOProxy();
    reestrServiceBean_YaromaAO.updateReestr(arg0);
  }
  
  
}