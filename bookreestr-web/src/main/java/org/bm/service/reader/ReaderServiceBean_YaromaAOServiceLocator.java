/**
 * ReaderServiceBean_YaromaAOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.reader;

public class ReaderServiceBean_YaromaAOServiceLocator extends org.apache.axis.client.Service implements org.bm.service.reader.ReaderServiceBean_YaromaAOService {

    public ReaderServiceBean_YaromaAOServiceLocator() {
    }


    public ReaderServiceBean_YaromaAOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReaderServiceBean_YaromaAOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Reader
    private java.lang.String Reader_address = "http://localhost:8080/ReaderServiceBean_YaromaAOService/ReaderServiceBean_YaromaAO";

    public java.lang.String getReaderAddress() {
        return Reader_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReaderWSDDServiceName = "Reader";

    public java.lang.String getReaderWSDDServiceName() {
        return ReaderWSDDServiceName;
    }

    public void setReaderWSDDServiceName(java.lang.String name) {
        ReaderWSDDServiceName = name;
    }

    public org.bm.service.reader.ReaderServiceBean_YaromaAO getReader() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Reader_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReader(endpoint);
    }

    public org.bm.service.reader.ReaderServiceBean_YaromaAO getReader(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bm.service.reader.ReaderBindingStub _stub = new org.bm.service.reader.ReaderBindingStub(portAddress, this);
            _stub.setPortName(getReaderWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReaderEndpointAddress(java.lang.String address) {
        Reader_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bm.service.reader.ReaderServiceBean_YaromaAO.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bm.service.reader.ReaderBindingStub _stub = new org.bm.service.reader.ReaderBindingStub(new java.net.URL(Reader_address), this);
                _stub.setPortName(getReaderWSDDServiceName());
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
        if ("Reader".equals(inputPortName)) {
            return getReader();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://reader.org", "ReaderServiceBean_YaromaAOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://reader.org", "Reader"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Reader".equals(portName)) {
            setReaderEndpointAddress(address);
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
