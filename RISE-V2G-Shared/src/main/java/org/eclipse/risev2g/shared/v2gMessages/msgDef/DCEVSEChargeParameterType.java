/*******************************************************************************
 *  Copyright (c) 2015 Marc Mültin (Chargepartner GmbH).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Dr.-Ing. Marc Mültin (Chargepartner GmbH) - initial API and implementation and initial documentation
 *******************************************************************************/
//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2014.10.07 um 04:55:05 PM CEST 
//


package org.eclipse.risev2g.shared.v2gMessages.msgDef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DC_EVSEChargeParameterType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DC_EVSEChargeParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:iso:15118:2:2013:MsgDataTypes}EVSEChargeParameterType">
 *       &lt;sequence>
 *         &lt;element name="DC_EVSEStatus" type="{urn:iso:15118:2:2013:MsgDataTypes}DC_EVSEStatusType"/>
 *         &lt;element name="EVSEMaximumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMaximumPowerLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMaximumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMinimumCurrentLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEMinimumVoltageLimit" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSECurrentRegulationTolerance" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *         &lt;element name="EVSEPeakCurrentRipple" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType"/>
 *         &lt;element name="EVSEEnergyToBeDelivered" type="{urn:iso:15118:2:2013:MsgDataTypes}PhysicalValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DC_EVSEChargeParameterType", propOrder = {
    "dcevseStatus",
    "evseMaximumCurrentLimit",
    "evseMaximumPowerLimit",
    "evseMaximumVoltageLimit",
    "evseMinimumCurrentLimit",
    "evseMinimumVoltageLimit",
    "evseCurrentRegulationTolerance",
    "evsePeakCurrentRipple",
    "evseEnergyToBeDelivered"
})
public class DCEVSEChargeParameterType
    extends EVSEChargeParameterType
{

    @XmlElement(name = "DC_EVSEStatus", required = true)
    protected DCEVSEStatusType dcevseStatus;
    @XmlElement(name = "EVSEMaximumCurrentLimit", required = true)
    protected PhysicalValueType evseMaximumCurrentLimit;
    @XmlElement(name = "EVSEMaximumPowerLimit", required = true)
    protected PhysicalValueType evseMaximumPowerLimit;
    @XmlElement(name = "EVSEMaximumVoltageLimit", required = true)
    protected PhysicalValueType evseMaximumVoltageLimit;
    @XmlElement(name = "EVSEMinimumCurrentLimit", required = true)
    protected PhysicalValueType evseMinimumCurrentLimit;
    @XmlElement(name = "EVSEMinimumVoltageLimit", required = true)
    protected PhysicalValueType evseMinimumVoltageLimit;
    @XmlElement(name = "EVSECurrentRegulationTolerance")
    protected PhysicalValueType evseCurrentRegulationTolerance;
    @XmlElement(name = "EVSEPeakCurrentRipple", required = true)
    protected PhysicalValueType evsePeakCurrentRipple;
    @XmlElement(name = "EVSEEnergyToBeDelivered")
    protected PhysicalValueType evseEnergyToBeDelivered;

    /**
     * Ruft den Wert der dcevseStatus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DCEVSEStatusType }
     *     
     */
    public DCEVSEStatusType getDCEVSEStatus() {
        return dcevseStatus;
    }

    /**
     * Legt den Wert der dcevseStatus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DCEVSEStatusType }
     *     
     */
    public void setDCEVSEStatus(DCEVSEStatusType value) {
        this.dcevseStatus = value;
    }

    /**
     * Ruft den Wert der evseMaximumCurrentLimit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumCurrentLimit() {
        return evseMaximumCurrentLimit;
    }

    /**
     * Legt den Wert der evseMaximumCurrentLimit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumCurrentLimit(PhysicalValueType value) {
        this.evseMaximumCurrentLimit = value;
    }

    /**
     * Ruft den Wert der evseMaximumPowerLimit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumPowerLimit() {
        return evseMaximumPowerLimit;
    }

    /**
     * Legt den Wert der evseMaximumPowerLimit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumPowerLimit(PhysicalValueType value) {
        this.evseMaximumPowerLimit = value;
    }

    /**
     * Ruft den Wert der evseMaximumVoltageLimit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMaximumVoltageLimit() {
        return evseMaximumVoltageLimit;
    }

    /**
     * Legt den Wert der evseMaximumVoltageLimit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMaximumVoltageLimit(PhysicalValueType value) {
        this.evseMaximumVoltageLimit = value;
    }

    /**
     * Ruft den Wert der evseMinimumCurrentLimit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMinimumCurrentLimit() {
        return evseMinimumCurrentLimit;
    }

    /**
     * Legt den Wert der evseMinimumCurrentLimit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMinimumCurrentLimit(PhysicalValueType value) {
        this.evseMinimumCurrentLimit = value;
    }

    /**
     * Ruft den Wert der evseMinimumVoltageLimit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEMinimumVoltageLimit() {
        return evseMinimumVoltageLimit;
    }

    /**
     * Legt den Wert der evseMinimumVoltageLimit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEMinimumVoltageLimit(PhysicalValueType value) {
        this.evseMinimumVoltageLimit = value;
    }

    /**
     * Ruft den Wert der evseCurrentRegulationTolerance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSECurrentRegulationTolerance() {
        return evseCurrentRegulationTolerance;
    }

    /**
     * Legt den Wert der evseCurrentRegulationTolerance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSECurrentRegulationTolerance(PhysicalValueType value) {
        this.evseCurrentRegulationTolerance = value;
    }

    /**
     * Ruft den Wert der evsePeakCurrentRipple-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEPeakCurrentRipple() {
        return evsePeakCurrentRipple;
    }

    /**
     * Legt den Wert der evsePeakCurrentRipple-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEPeakCurrentRipple(PhysicalValueType value) {
        this.evsePeakCurrentRipple = value;
    }

    /**
     * Ruft den Wert der evseEnergyToBeDelivered-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalValueType }
     *     
     */
    public PhysicalValueType getEVSEEnergyToBeDelivered() {
        return evseEnergyToBeDelivered;
    }

    /**
     * Legt den Wert der evseEnergyToBeDelivered-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalValueType }
     *     
     */
    public void setEVSEEnergyToBeDelivered(PhysicalValueType value) {
        this.evseEnergyToBeDelivered = value;
    }

}
