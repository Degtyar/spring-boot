//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.15 at 10:09:12 PM NOVT 
//


package ru.degtyar.springboot.soap.person;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mark.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="mark"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EXCELLENTLY"/&gt;
 *     &lt;enumeration value="PERFECTLY"/&gt;
 *     &lt;enumeration value="PASSABLE"/&gt;
 *     &lt;enumeration value="NOT_PASSABLE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "mark")
@XmlEnum
public enum Mark {

    EXCELLENTLY,
    PERFECTLY,
    PASSABLE,
    NOT_PASSABLE;

    public String value() {
        return name();
    }

    public static Mark fromValue(String v) {
        return valueOf(v);
    }

}
