/**
 * ReestrServiceBean_YaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.reestr;

public interface ReestrServiceBean_YaromaAO extends java.rmi.Remote {
    public void deleteReestr(int arg0) throws java.rmi.RemoteException;
    public org.bm.service.reestr.ReestrYaromaAO getReestr(int arg0) throws java.rmi.RemoteException;
    public int addReestr(org.bm.service.reestr.ReestrYaromaAO arg0) throws java.rmi.RemoteException;
    public org.bm.service.reestr.ReestrYaromaAO[] getAllReestrs() throws java.rmi.RemoteException;
    public void updateReestr(org.bm.service.reestr.ReestrYaromaAO arg0) throws java.rmi.RemoteException;
}
