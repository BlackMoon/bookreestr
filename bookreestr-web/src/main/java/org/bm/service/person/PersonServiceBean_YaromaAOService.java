/**
 * PersonServiceBean_YaromaAOService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.person;

public interface PersonServiceBean_YaromaAOService extends javax.xml.rpc.Service {
    public java.lang.String getPersonAddress();

    public org.bm.service.person.PersonServiceBean_YaromaAO getPerson() throws javax.xml.rpc.ServiceException;

    public org.bm.service.person.PersonServiceBean_YaromaAO getPerson(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
