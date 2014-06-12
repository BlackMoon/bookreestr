/**
 * PersonServiceBean_YaromaAOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.person;

public class PersonServiceBean_YaromaAOServiceLocator extends org.apache.axis.client.Service implements org.bm.service.person.PersonServiceBean_YaromaAOService {

    public PersonServiceBean_YaromaAOServiceLocator() {
    }


    public PersonServiceBean_YaromaAOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonServiceBean_YaromaAOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Person
    private java.lang.String Person_address = "http://localhost:8080/PersonServiceBean_YaromaAOService/PersonServiceBean_YaromaAO";

    public java.lang.String getPersonAddress() {
        return Person_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonWSDDServiceName = "Person";

    public java.lang.String getPersonWSDDServiceName() {
        return PersonWSDDServiceName;
    }

    public void setPersonWSDDServiceName(java.lang.String name) {
        PersonWSDDServiceName = name;
    }

    public org.bm.service.person.PersonServiceBean_YaromaAO getPerson() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Person_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPerson(endpoint);
    }

    public org.bm.service.person.PersonServiceBean_YaromaAO getPerson(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bm.service.person.PersonBindingStub _stub = new org.bm.service.person.PersonBindingStub(portAddress, this);
            _stub.setPortName(getPersonWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonEndpointAddress(java.lang.String address) {
        Person_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bm.service.person.PersonServiceBean_YaromaAO.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bm.service.person.PersonBindingStub _stub = new org.bm.service.person.PersonBindingStub(new java.net.URL(Person_address), this);
                _stub.setPortName(getPersonWSDDServiceName());
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
        if ("Person".equals(inputPortName)) {
            return getPerson();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://person.org", "PersonServiceBean_YaromaAOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://person.org", "Person"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Person".equals(portName)) {
            setPersonEndpointAddress(address);
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