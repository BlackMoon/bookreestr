/**
 * SubjectServiceBean_YaromaAOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.subject;

public class SubjectServiceBean_YaromaAOServiceLocator extends org.apache.axis.client.Service implements org.bm.service.subject.SubjectServiceBean_YaromaAOService {

    public SubjectServiceBean_YaromaAOServiceLocator() {
    }


    public SubjectServiceBean_YaromaAOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SubjectServiceBean_YaromaAOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Subject
    private java.lang.String Subject_address = "http://localhost:8080/SubjectServiceBean_YaromaAOService/SubjectServiceBean_YaromaAO";

    public java.lang.String getSubjectAddress() {
        return Subject_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SubjectWSDDServiceName = "Subject";

    public java.lang.String getSubjectWSDDServiceName() {
        return SubjectWSDDServiceName;
    }

    public void setSubjectWSDDServiceName(java.lang.String name) {
        SubjectWSDDServiceName = name;
    }

    public org.bm.service.subject.SubjectServiceBean_YaromaAO getSubject() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Subject_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSubject(endpoint);
    }

    public org.bm.service.subject.SubjectServiceBean_YaromaAO getSubject(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bm.service.subject.SubjectBindingStub _stub = new org.bm.service.subject.SubjectBindingStub(portAddress, this);
            _stub.setPortName(getSubjectWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSubjectEndpointAddress(java.lang.String address) {
        Subject_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bm.service.subject.SubjectServiceBean_YaromaAO.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bm.service.subject.SubjectBindingStub _stub = new org.bm.service.subject.SubjectBindingStub(new java.net.URL(Subject_address), this);
                _stub.setPortName(getSubjectWSDDServiceName());
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
        if ("Subject".equals(inputPortName)) {
            return getSubject();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://subject.org", "SubjectServiceBean_YaromaAOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://subject.org", "Subject"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Subject".equals(portName)) {
            setSubjectEndpointAddress(address);
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
