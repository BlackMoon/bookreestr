/**
 * BookServiceBean_YaromaAOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.book;

public class BookServiceBean_YaromaAOServiceLocator extends org.apache.axis.client.Service implements org.bm.service.book.BookServiceBean_YaromaAOService {

    public BookServiceBean_YaromaAOServiceLocator() {
    }


    public BookServiceBean_YaromaAOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BookServiceBean_YaromaAOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Book
    private java.lang.String Book_address = "http://localhost:8080/BookServiceBean_YaromaAOService/BookServiceBean_YaromaAO";

    public java.lang.String getBookAddress() {
        return Book_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BookWSDDServiceName = "Book";

    public java.lang.String getBookWSDDServiceName() {
        return BookWSDDServiceName;
    }

    public void setBookWSDDServiceName(java.lang.String name) {
        BookWSDDServiceName = name;
    }

    public org.bm.service.book.BookServiceBean_YaromaAO getBook() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Book_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBook(endpoint);
    }

    public org.bm.service.book.BookServiceBean_YaromaAO getBook(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bm.service.book.BookBindingStub _stub = new org.bm.service.book.BookBindingStub(portAddress, this);
            _stub.setPortName(getBookWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBookEndpointAddress(java.lang.String address) {
        Book_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bm.service.book.BookServiceBean_YaromaAO.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bm.service.book.BookBindingStub _stub = new org.bm.service.book.BookBindingStub(new java.net.URL(Book_address), this);
                _stub.setPortName(getBookWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Book".equals(inputPortName)) {
            return getBook();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://book.org", "BookServiceBean_YaromaAOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://book.org", "Book"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Book".equals(portName)) {
            setBookEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
