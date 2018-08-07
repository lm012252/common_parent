
package com.lm.bos.cms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>subArea complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="subArea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://impl.take_delivery.service.bos.lm.com/}area" minOccurs="0"/>
 *         &lt;element name="assistKeyWords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fixedArea" type="{http://impl.take_delivery.service.bos.lm.com/}fixedArea" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keyWords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="single" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="startNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subArea", propOrder = {
    "area",
    "assistKeyWords",
    "endNum",
    "fixedArea",
    "id",
    "keyWords",
    "single",
    "startNum"
})
public class SubArea {

    protected Area area;
    protected String assistKeyWords;
    protected String endNum;
    protected FixedArea fixedArea;
    protected String id;
    protected String keyWords;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer single;
    protected String startNum;

    /**
     * ��ȡarea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getArea() {
        return area;
    }

    /**
     * ����area���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setArea(Area value) {
        this.area = value;
    }

    /**
     * ��ȡassistKeyWords���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistKeyWords() {
        return assistKeyWords;
    }

    /**
     * ����assistKeyWords���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistKeyWords(String value) {
        this.assistKeyWords = value;
    }

    /**
     * ��ȡendNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndNum() {
        return endNum;
    }

    /**
     * ����endNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndNum(String value) {
        this.endNum = value;
    }

    /**
     * ��ȡfixedArea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FixedArea }
     *     
     */
    public FixedArea getFixedArea() {
        return fixedArea;
    }

    /**
     * ����fixedArea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FixedArea }
     *     
     */
    public void setFixedArea(FixedArea value) {
        this.fixedArea = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ��ȡkeyWords���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * ����keyWords���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyWords(String value) {
        this.keyWords = value;
    }

    /**
     * ��ȡsingle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSingle() {
        return single;
    }

    /**
     * ����single���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSingle(Integer value) {
        this.single = value;
    }

    /**
     * ��ȡstartNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartNum() {
        return startNum;
    }

    /**
     * ����startNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartNum(String value) {
        this.startNum = value;
    }

}
