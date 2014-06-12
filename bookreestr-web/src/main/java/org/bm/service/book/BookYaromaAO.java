/**
 * BookYaromaAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bm.service.book;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({ "subject" })
public class BookYaromaAO  implements java.io.Serializable {
    private java.lang.String author;

    private int id;

    private java.lang.String name;

    private java.lang.String publish;

    private org.bm.service.subject.SubjectYaromaAO subject;

    private int subjectid;

    private int year;
    
    private String subjectName;

    public BookYaromaAO() {
    }

    public BookYaromaAO(
           java.lang.String author,
           int id,
           java.lang.String name,
           java.lang.String publish,
           org.bm.service.subject.SubjectYaromaAO subject,
           int subjectid,
           int year) {
           this.author = author;
           this.id = id;
           this.name = name;
           this.publish = publish;
           this.subject = subject;
           this.subjectid = subjectid;
           this.year = year;
    }


    /**
     * Gets the author value for this BookYaromaAO.
     * 
     * @return author
     */
    public java.lang.String getAuthor() {
        return author;
    }


    /**
     * Sets the author value for this BookYaromaAO.
     * 
     * @param author
     */
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }


    /**
     * Gets the id value for this BookYaromaAO.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this BookYaromaAO.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this BookYaromaAO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this BookYaromaAO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the publish value for this BookYaromaAO.
     * 
     * @return publish
     */
    public java.lang.String getPublish() {
        return publish;
    }


    /**
     * Sets the publish value for this BookYaromaAO.
     * 
     * @param publish
     */
    public void setPublish(java.lang.String publish) {
        this.publish = publish;
    }


    /**
     * Gets the subject value for this BookYaromaAO.
     * 
     * @return subject
     */
    public org.bm.service.subject.SubjectYaromaAO getSubject() {
        return subject;
    }


    /**
     * Sets the subject value for this BookYaromaAO.
     * 
     * @param subject
     */
    public void setSubject(org.bm.service.subject.SubjectYaromaAO subject) {
        this.subject = subject;
        
        if (subject != null)
        	subjectName = subject.getName();
    }


    /**
     * Gets the subjectid value for this BookYaromaAO.
     * 
     * @return subjectid
     */
    public int getSubjectid() {
        return subjectid;
    }


    /**
     * Sets the subjectid value for this BookYaromaAO.
     * 
     * @param subjectid
     */
    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }


    /**
     * Gets the year value for this BookYaromaAO.
     * 
     * @return year
     */
    public int getYear() {
        return year;
    }


    /**
     * Sets the year value for this BookYaromaAO.
     * 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookYaromaAO)) return false;
        BookYaromaAO other = (BookYaromaAO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.author==null && other.getAuthor()==null) || 
             (this.author!=null &&
              this.author.equals(other.getAuthor()))) &&
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.publish==null && other.getPublish()==null) || 
             (this.publish!=null &&
              this.publish.equals(other.getPublish()))) &&
            ((this.subject==null && other.getSubject()==null) || 
             (this.subject!=null &&
              this.subject.equals(other.getSubject()))) &&
            this.subjectid == other.getSubjectid() &&
            this.year == other.getYear();
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
        if (getAuthor() != null) {
            _hashCode += getAuthor().hashCode();
        }
        _hashCode += getId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPublish() != null) {
            _hashCode += getPublish().hashCode();
        }
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        _hashCode += getSubjectid();
        _hashCode += getYear();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookYaromaAO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://book.org", "bookYaromaAO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("author");
        elemField.setXmlName(new javax.xml.namespace.QName("", "author"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publish");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://subject.org", "subjectYaromaAO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subjectid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("", "year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
    
    @Override
	public String toString(){
		return name + ". " + author;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
