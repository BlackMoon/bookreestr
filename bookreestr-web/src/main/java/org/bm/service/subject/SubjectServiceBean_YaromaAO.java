/**
 * SubjectServiceBean_YaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.subject;

public interface SubjectServiceBean_YaromaAO extends java.rmi.Remote {
    public int addSubject(org.bm.service.subject.SubjectYaromaAO arg0) throws java.rmi.RemoteException;
    public void deleteSubject(int arg0) throws java.rmi.RemoteException;
    public void updateSubject(org.bm.service.subject.SubjectYaromaAO arg0) throws java.rmi.RemoteException;
    public org.bm.service.subject.SubjectYaromaAO getSubject(int arg0) throws java.rmi.RemoteException;
    public org.bm.service.subject.SubjectYaromaAO[] getAllSubjects() throws java.rmi.RemoteException;
    public int getNewSubjectId() throws java.rmi.RemoteException;
}
