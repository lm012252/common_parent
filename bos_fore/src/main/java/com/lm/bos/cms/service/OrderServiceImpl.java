
package com.lm.bos.cms.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OrderServiceImpl", targetNamespace = "http://impl.take_delivery.service.bos.lm.com/")
@XmlSeeAlso({
})
public interface OrderServiceImpl {


    /**
     * 
     * @param order
     */
    @WebMethod
    @RequestWrapper(localName = "save", targetNamespace = "http://impl.take_delivery.service.bos.lm.com/", className = "com.lm.bos.service.take_delivery.impl.Save")
    @ResponseWrapper(localName = "saveResponse", targetNamespace = "http://impl.take_delivery.service.bos.lm.com/", className = "com.lm.bos.service.take_delivery.impl.SaveResponse")
    public void save(
            @WebParam(name = "order", targetNamespace = "")
                    Order order);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "generateWorkBill", targetNamespace = "http://impl.take_delivery.service.bos.lm.com/", className = "com.lm.bos.service.take_delivery.impl.GenerateWorkBill")
    @ResponseWrapper(localName = "generateWorkBillResponse", targetNamespace = "http://impl.take_delivery.service.bos.lm.com/", className = "com.lm.bos.service.take_delivery.impl.GenerateWorkBillResponse")
    public void generateWorkBill(
            @WebParam(name = "arg0", targetNamespace = "")
                    Order arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    Courier arg1);

}
