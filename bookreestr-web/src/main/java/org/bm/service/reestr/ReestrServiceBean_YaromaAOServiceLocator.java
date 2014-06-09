/**
 * ReestrServiceBean_YaromaAOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.reestr;

public class ReestrServiceBean_YaromaAOServiceLocator extends org.apache.axis.client.Service implements org.bm.service.reestr.ReestrServiceBean_YaromaAOService {

    public ReestrServiceBean_YaromaAOServiceLocator() {
    }


    public ReestrServiceBean_YaromaAOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReestrServiceBean_YaromaAOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Reestr
    private java.lang.String Reestr_address = "http://localhost:8080/ReestrServiceBean_YaromaAOService/ReestrServiceBean_YaromaAO";

    public java.lang.String getReestrAddress() {
        return Reestr_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReestrWSDDServiceName = "Reestr";

    public java.lang.String getReestrWSDDServiceName() {
        return ReestrWSDDServiceName;
    }

    public void setReestrWSDDServiceName(java.lang.String name) {
        ReestrWSDDServiceName = name;
    }

    public org.bm.service.reestr.ReestrServiceBean_YaromaAO getReestr() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Reestr_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReestr(endpoint);
    }

    public org.bm.service.reestr.ReestrServiceBean_YaromaAO getReestr(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bm.service.reestr.ReestrBindingStub _stub = new org.bm.service.reestr.ReestrBindingStub(portAddress, this);
            _stub.setPortName(getReestrWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReestrEndpointAddress(java.lang.String address) {
        Reestr_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bm.service.reestr.ReestrServiceBean_YaromaAO.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bm.service.reestr.ReestrBindingStub _stub = new org.bm.service.reestr.ReestrBindingStub(new java.net.URL(Reestr_address), this);
                _stub.setPortName(getReestrWSDDServiceName());
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
        if ("Reestr".equals(inputPortName)) {
            return getReestr();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://reestr.org", "ReestrServiceBean_YaromaAOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://reestr.org", "Reestr"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Reestr".equals(portName)) {
            setReestrEndpointAddress(address);
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
