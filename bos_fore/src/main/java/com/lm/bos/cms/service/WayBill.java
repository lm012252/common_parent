
package com.lm.bos.cms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>wayBill complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="wayBill">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actlweit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="arriveCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeitemnum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="floadreqr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goodsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="order" type="{http://impl.take_delivery.service.bos.lm.com/}order" minOccurs="0"/>
 *         &lt;element name="payTypeNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recArea" type="{http://impl.take_delivery.service.bos.lm.com/}area" minOccurs="0"/>
 *         &lt;element name="recCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendArea" type="{http://impl.take_delivery.service.bos.lm.com/}area" minOccurs="0"/>
 *         &lt;element name="sendCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendProNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wayBillNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wayBillType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wayBill", propOrder = {
    "actlweit",
    "arriveCity",
    "delTag",
    "feeitemnum",
    "floadreqr",
    "goodsType",
    "id",
    "num",
    "order",
    "payTypeNum",
    "recAddress",
    "recArea",
    "recCompany",
    "recMobile",
    "recName",
    "remark",
    "sendAddress",
    "sendArea",
    "sendCompany",
    "sendMobile",
    "sendName",
    "sendProNum",
    "signStatus",
    "vol",
    "wayBillNum",
    "wayBillType",
    "weight"
})
public class WayBill {

    protected Double actlweit;
    protected String arriveCity;
    protected String delTag;
    protected Integer feeitemnum;
    protected String floadreqr;
    protected String goodsType;
    protected Integer id;
    protected Integer num;
    protected Order order;
    protected String payTypeNum;
    protected String recAddress;
    protected Area recArea;
    protected String recCompany;
    protected String recMobile;
    protected String recName;
    protected String remark;
    protected String sendAddress;
    protected Area sendArea;
    protected String sendCompany;
    protected String sendMobile;
    protected String sendName;
    protected String sendProNum;
    protected Integer signStatus;
    protected String vol;
    protected String wayBillNum;
    protected String wayBillType;
    protected Double weight;

    /**
     * ��ȡactlweit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getActlweit() {
        return actlweit;
    }

    /**
     * ����actlweit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setActlweit(Double value) {
        this.actlweit = value;
    }

    /**
     * ��ȡarriveCity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArriveCity() {
        return arriveCity;
    }

    /**
     * ����arriveCity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArriveCity(String value) {
        this.arriveCity = value;
    }

    /**
     * ��ȡdelTag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelTag() {
        return delTag;
    }

    /**
     * ����delTag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelTag(String value) {
        this.delTag = value;
    }

    /**
     * ��ȡfeeitemnum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeeitemnum() {
        return feeitemnum;
    }

    /**
     * ����feeitemnum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeeitemnum(Integer value) {
        this.feeitemnum = value;
    }

    /**
     * ��ȡfloadreqr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloadreqr() {
        return floadreqr;
    }

    /**
     * ����floadreqr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloadreqr(String value) {
        this.floadreqr = value;
    }

    /**
     * ��ȡgoodsType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * ����goodsType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsType(String value) {
        this.goodsType = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * ��ȡnum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNum() {
        return num;
    }

    /**
     * ����num���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNum(Integer value) {
        this.num = value;
    }

    /**
     * ��ȡorder���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * ����order���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
    }

    /**
     * ��ȡpayTypeNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayTypeNum() {
        return payTypeNum;
    }

    /**
     * ����payTypeNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayTypeNum(String value) {
        this.payTypeNum = value;
    }

    /**
     * ��ȡrecAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecAddress() {
        return recAddress;
    }

    /**
     * ����recAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecAddress(String value) {
        this.recAddress = value;
    }

    /**
     * ��ȡrecArea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getRecArea() {
        return recArea;
    }

    /**
     * ����recArea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setRecArea(Area value) {
        this.recArea = value;
    }

    /**
     * ��ȡrecCompany���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecCompany() {
        return recCompany;
    }

    /**
     * ����recCompany���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecCompany(String value) {
        this.recCompany = value;
    }

    /**
     * ��ȡrecMobile���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecMobile() {
        return recMobile;
    }

    /**
     * ����recMobile���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecMobile(String value) {
        this.recMobile = value;
    }

    /**
     * ��ȡrecName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecName() {
        return recName;
    }

    /**
     * ����recName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecName(String value) {
        this.recName = value;
    }

    /**
     * ��ȡremark���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * ����remark���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * ��ȡsendAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * ����sendAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendAddress(String value) {
        this.sendAddress = value;
    }

    /**
     * ��ȡsendArea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getSendArea() {
        return sendArea;
    }

    /**
     * ����sendArea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setSendArea(Area value) {
        this.sendArea = value;
    }

    /**
     * ��ȡsendCompany���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendCompany() {
        return sendCompany;
    }

    /**
     * ����sendCompany���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendCompany(String value) {
        this.sendCompany = value;
    }

    /**
     * ��ȡsendMobile���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendMobile() {
        return sendMobile;
    }

    /**
     * ����sendMobile���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendMobile(String value) {
        this.sendMobile = value;
    }

    /**
     * ��ȡsendName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * ����sendName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendName(String value) {
        this.sendName = value;
    }

    /**
     * ��ȡsendProNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendProNum() {
        return sendProNum;
    }

    /**
     * ����sendProNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendProNum(String value) {
        this.sendProNum = value;
    }

    /**
     * ��ȡsignStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSignStatus() {
        return signStatus;
    }

    /**
     * ����signStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSignStatus(Integer value) {
        this.signStatus = value;
    }

    /**
     * ��ȡvol���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVol() {
        return vol;
    }

    /**
     * ����vol���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVol(String value) {
        this.vol = value;
    }

    /**
     * ��ȡwayBillNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWayBillNum() {
        return wayBillNum;
    }

    /**
     * ����wayBillNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWayBillNum(String value) {
        this.wayBillNum = value;
    }

    /**
     * ��ȡwayBillType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWayBillType() {
        return wayBillType;
    }

    /**
     * ����wayBillType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWayBillType(String value) {
        this.wayBillType = value;
    }

    /**
     * ��ȡweight���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * ����weight���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

}
