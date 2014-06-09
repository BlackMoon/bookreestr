/**
 * BookServiceBean_YaromaAOService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.book;

public interface BookServiceBean_YaromaAOService extends javax.xml.rpc.Service {
    public java.lang.String getBookAddress();

    public org.bm.service.book.BookServiceBean_YaromaAO getBook() throws javax.xml.rpc.ServiceException;

    public org.bm.service.book.BookServiceBean_YaromaAO getBook(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
