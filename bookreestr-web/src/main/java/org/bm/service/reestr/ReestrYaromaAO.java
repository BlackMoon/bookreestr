/**
 * ReestrYaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.reestr;

public class ReestrYaromaAO  implements java.io.Serializable {
    private org.bm.service.book.BookYaromaAO book;

    private int bookid;

    private java.util.Date endDate;

    private int id;

    private org.bm.service.reader.ReaderYaromaAO reader;

    private int readerid;

    private java.util.Date startDate;

    public ReestrYaromaAO() {
    }

    public ReestrYaromaAO(
    		org.bm.service.book.BookYaromaAO book,
           int bookid,
           java.util.Date endDate,
           int id,
           org.bm.service.reader.ReaderYaromaAO reader,
           int readerid,
           java.util.Date startDate) {
           this.book = book;
           this.bookid = bookid;
           this.endDate = endDate;
           this.id = id;
           this.reader = reader;
           this.readerid = readerid;
           this.startDate = startDate;
    }


    /**
     * Gets the book value for this ReestrYaromaAO.
     * 
     * @return book
     */
    public org.bm.service.book.BookYaromaAO getBook() {
        return book;
    }


    /**
     * Sets the book value for this ReestrYaromaAO.
     * 
     * @param book
     */
    public void setBook(org.bm.service.book.BookYaromaAO book) {
        this.book = book;
    }


    /**
     * Gets the bookid value for this ReestrYaromaAO.
     * 
     * @return bookid
     */
    public int getBookid() {
        return bookid;
    }


    /**
     * Sets the bookid value for this ReestrYaromaAO.
     * 
     * @param bookid
     */
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }


    /**
     * Gets the endDate value for this ReestrYaromaAO.
     * 
     * @return endDate
     */
    public java.util.Date getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this ReestrYaromaAO.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the id value for this ReestrYaromaAO.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this ReestrYaromaAO.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the reader value for this ReestrYaromaAO.
     * 
     * @return reader
     */
    public org.bm.service.reader.ReaderYaromaAO getReader() {
        return reader;
    }


    /**
     * Sets the reader value for this ReestrYaromaAO.
     * 
     * @param reader
     */
    public void setReader(org.bm.service.reader.ReaderYaromaAO reader) {
        this.reader = reader;
    }


    /**
     * Gets the readerid value for this ReestrYaromaAO.
     * 
     * @return readerid
     */
    public int getReaderid() {
        return readerid;
    }


    /**
     * Sets the readerid value for this ReestrYaromaAO.
     * 
     * @param readerid
     */
    public void setReaderid(int readerid) {
        this.readerid = readerid;
    }


    /**
     * Gets the startDate value for this ReestrYaromaAO.
     * 
     * @return startDate
     */
    public java.util.Date getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this ReestrYaromaAO.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReestrYaromaAO)) return false;
        ReestrYaromaAO other = (ReestrYaromaAO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.book==null && other.getBook()==null) || 
             (this.book!=null &&
              this.book.equals(other.getBook()))) &&
            this.bookid == other.getBookid() &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            this.id == other.getId() &&
            ((this.reader==null && other.getReader()==null) || 
             (this.reader!=null &&
              this.reader.equals(other.getReader()))) &&
            this.readerid == other.getReaderid() &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBook() != null) {
            _hashCode += getBook().hashCode();
        }
        _hashCode += getBookid();
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        _hashCode += getId();
        if (getReader() != null) {
            _hashCode += getReader().hashCode();
        }
        _hashCode += getReaderid();
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReestrYaromaAO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reestr.org", "reestrYaromaAO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("book");
        elemField.setXmlName(new javax.xml.namespace.QName("", "book"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://book.org", "bookYaromaAO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bookid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reader");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://reestr.org", "readerYaromaAO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readerid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "readerid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
