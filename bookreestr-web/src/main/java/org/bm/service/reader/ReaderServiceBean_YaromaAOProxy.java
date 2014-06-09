package org.bm.service.reader;

public class ReaderServiceBean_YaromaAOProxy implements org.bm.service.reader.ReaderServiceBean_YaromaAO {
  private String _endpoint = null;
  private org.bm.service.reader.ReaderServiceBean_YaromaAO readerServiceBean_YaromaAO = null;
  
  public ReaderServiceBean_YaromaAOProxy() {
    _initReaderServiceBean_YaromaAOProxy();
  }
  
  public ReaderServiceBean_YaromaAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initReaderServiceBean_YaromaAOProxy();
  }
  
  private void _initReaderServiceBean_YaromaAOProxy() {
    try {
      readerServiceBean_YaromaAO = (new org.bm.service.reader.ReaderServiceBean_YaromaAOServiceLocator()).getReader();
      if (readerServiceBean_YaromaAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)readerServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)readerServiceBean_YaromaAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (readerServiceBean_YaromaAO != null)
      ((javax.xml.rpc.Stub)readerServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.bm.service.reader.ReaderServiceBean_YaromaAO getReaderServiceBean_YaromaAO() {
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    return readerServiceBean_YaromaAO;
  }
  
  public org.bm.service.reader.ReaderYaromaAO getReader(int arg0) throws java.rmi.RemoteException{
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    return readerServiceBean_YaromaAO.getReader(arg0);
  }
  
  public int getNewReaderId() throws java.rmi.RemoteException{
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    return readerServiceBean_YaromaAO.getNewReaderId();
  }
  
  public org.bm.service.reader.ReaderYaromaAO[] getAllReaders() throws java.rmi.RemoteException{
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    return readerServiceBean_YaromaAO.getAllReaders();
  }
  
  public int addReader(org.bm.service.reader.ReaderYaromaAO arg0) throws java.rmi.RemoteException{
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    return readerServiceBean_YaromaAO.addReader(arg0);
  }
  
  public void updateReader(org.bm.service.reader.ReaderYaromaAO arg0) throws java.rmi.RemoteException{
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    readerServiceBean_YaromaAO.updateReader(arg0);
  }
  
  public void deleteReader(int arg0) throws java.rmi.RemoteException{
    if (readerServiceBean_YaromaAO == null)
      _initReaderServiceBean_YaromaAOProxy();
    readerServiceBean_YaromaAO.deleteReader(arg0);
  }
  
  
}