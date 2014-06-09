/**
 * PersonServiceBean_YaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.person;

public interface PersonServiceBean_YaromaAO extends java.rmi.Remote {
    public org.bm.service.person.PersonYaromaAO[] getAllPersons() throws java.rmi.RemoteException;
    public org.bm.service.person.PersonYaromaAO getPerson(int arg0) throws java.rmi.RemoteException;
    public int addPerson(org.bm.service.person.PersonYaromaAO arg0) throws java.rmi.RemoteException;
    public void deletePerson(int arg0) throws java.rmi.RemoteException;
    public void updatePerson(org.bm.service.person.PersonYaromaAO arg0) throws java.rmi.RemoteException;
    public org.bm.service.person.PersonYaromaAO getByLogin(java.lang.String arg0) throws java.rmi.RemoteException;
    public int getNewPersonId() throws java.rmi.RemoteException;
}
