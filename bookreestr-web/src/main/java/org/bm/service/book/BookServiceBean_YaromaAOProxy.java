package org.bm.service.book;

public class BookServiceBean_YaromaAOProxy implements org.bm.service.book.BookServiceBean_YaromaAO {
  private String _endpoint = null;
  private org.bm.service.book.BookServiceBean_YaromaAO bookServiceBean_YaromaAO = null;
  
  public BookServiceBean_YaromaAOProxy() {
    _initBookServiceBean_YaromaAOProxy();
  }
  
  public BookServiceBean_YaromaAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initBookServiceBean_YaromaAOProxy();
  }
  
  private void _initBookServiceBean_YaromaAOProxy() {
    try {
      bookServiceBean_YaromaAO = (new org.bm.service.book.BookServiceBean_YaromaAOServiceLocator()).getBook();
      if (bookServiceBean_YaromaAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bookServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bookServiceBean_YaromaAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bookServiceBean_YaromaAO != null)
      ((javax.xml.rpc.Stub)bookServiceBean_YaromaAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.bm.service.book.BookServiceBean_YaromaAO getBookServiceBean_YaromaAO() {
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    return bookServiceBean_YaromaAO;
  }
  
  public org.bm.service.book.BookYaromaAO getBook(int arg0) throws java.rmi.RemoteException{
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    return bookServiceBean_YaromaAO.getBook(arg0);
  }
  
  public org.bm.service.book.BookYaromaAO[] getAllBooks() throws java.rmi.RemoteException{
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    return bookServiceBean_YaromaAO.getAllBooks();
  }
  
  public int addBook(org.bm.service.book.BookYaromaAO arg0) throws java.rmi.RemoteException{
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    return bookServiceBean_YaromaAO.addBook(arg0);
  }
  
  public int getNewBookId() throws java.rmi.RemoteException{
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    return bookServiceBean_YaromaAO.getNewBookId();
  }
  
  public void deleteBook(int arg0) throws java.rmi.RemoteException{
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    bookServiceBean_YaromaAO.deleteBook(arg0);
  }
  
  public void updateBook(org.bm.service.book.BookYaromaAO arg0) throws java.rmi.RemoteException{
    if (bookServiceBean_YaromaAO == null)
      _initBookServiceBean_YaromaAOProxy();
    bookServiceBean_YaromaAO.updateBook(arg0);
  }
  
  
}