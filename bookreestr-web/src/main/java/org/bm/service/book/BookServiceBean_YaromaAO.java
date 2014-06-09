/**
 * BookServiceBean_YaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.book;

public interface BookServiceBean_YaromaAO extends java.rmi.Remote {
    public org.bm.service.book.BookYaromaAO getBook(int arg0) throws java.rmi.RemoteException;
    public org.bm.service.book.BookYaromaAO[] getAllBooks() throws java.rmi.RemoteException;
    public int addBook(org.bm.service.book.BookYaromaAO arg0) throws java.rmi.RemoteException;
    public int getNewBookId() throws java.rmi.RemoteException;
    public void deleteBook(int arg0) throws java.rmi.RemoteException;
    public void updateBook(org.bm.service.book.BookYaromaAO arg0) throws java.rmi.RemoteException;
}
