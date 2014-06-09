/**
 * ReaderServiceBean_YaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.reader;

public interface ReaderServiceBean_YaromaAO extends java.rmi.Remote {
    public org.bm.service.reader.ReaderYaromaAO getReader(int arg0) throws java.rmi.RemoteException;
    public int getNewReaderId() throws java.rmi.RemoteException;
    public org.bm.service.reader.ReaderYaromaAO[] getAllReaders() throws java.rmi.RemoteException;
    public int addReader(org.bm.service.reader.ReaderYaromaAO arg0) throws java.rmi.RemoteException;
    public void updateReader(org.bm.service.reader.ReaderYaromaAO arg0) throws java.rmi.RemoteException;
    public void deleteReader(int arg0) throws java.rmi.RemoteException;
}
