///*
// * Creation : Dec 23, 2013
// */
//package com.mic.exp.batch.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import com.mic.exp.batch.model.base.BaseBatchTrace;
//
///**
// * The Class BatchTrace.
// */
//@Entity
//@Table(name = "MIOQTTRA")
//public class BatchTrace extends BaseBatchTrace {
//
//    /** The Constant serialVersionUID. */
//    private static final long serialVersionUID = 8938098900977917953L;
//
//    /** The Constant COL_SUBSIDIARYCODES. */
//    public static final String COL_SUBSIDIARYCODES = "subsidiaryCodes";
//
//    /** The Constant COL_SYPLABELS. */
//    public static final String COL_SYPLABELS = "sypLabels";
//
//    /** The Constant COL_SYPIDS. */
//    public static final String COL_SYPIDS = "sypIds";
//
//    /** The Constant COL_PST_DIRECTION. */
//    public static final String COL_PST_DIRECTION = "pst_direction";
//
//    /** The Constant COL_STJ_FREQUENCY. */
//    public static final String COL_STJ_FREQUENCY = "stj_frequency";
//
//    /** The functional domains. */
//    private String functionalDomains;
//
//    /** The subsidiary codes. */
//    private String subsidiaryCodes;
//
//    /** The syp labels. */
//    private String sypLabels;
//
//    /** The syp ids. */
//    private String sypIds;
//
//    /** The pst direction. */
//    private String pstDirection;
//
//    /** The stj frequency. */
//    private String stjFrequency;
//
//    /**
//     * Getter functionalDomains.
//     * 
//     * @return the functionalDomains
//     */
//    @Transient
//    public String getFunctionalDomains() {
//        return functionalDomains;
//    }
//
//    /**
//     * Setter functionalDomains.
//     * 
//     * @param functionalDomains the functionalDomains to set
//     */
//    public void setFunctionalDomains(String functionalDomains) {
//        this.functionalDomains = functionalDomains;
//    }
//
//    /**
//     * Getter subsidiaryCodes.
//     * 
//     * @return the subsidiaryCodes
//     */
//    @Transient
//    public String getSubsidiaryCodes() {
//        return subsidiaryCodes;
//    }
//
//    /**
//     * Setter subsidiaryCodes.
//     * 
//     * @param subsidiaryCodes the subsidiaryCodes to set
//     */
//    public void setSubsidiaryCodes(String subsidiaryCodes) {
//        this.subsidiaryCodes = subsidiaryCodes;
//    }
//
//    /**
//     * Getter sypLabels.
//     * 
//     * @return the sypLabels
//     */
//    @Transient
//    public String getSypLabels() {
//        return sypLabels;
//    }
//
//    /**
//     * Setter sypLabels.
//     * 
//     * @param sypLabels the sypLabels to set
//     */
//    public void setSypLabels(String sypLabels) {
//        this.sypLabels = sypLabels;
//    }
//
//    /**
//     * Getter sypIds.
//     * 
//     * @return the sypIds
//     */
//    @Transient
//    public String getSypIds() {
//        return sypIds;
//    }
//
//    /**
//     * Setter sypIds.
//     * 
//     * @param sypIds the sypIds to set
//     */
//    public void setSypIds(String sypIds) {
//        this.sypIds = sypIds;
//    }
//
//    /**
//     * Getter pstDirection.
//     * 
//     * @return the pstDirection
//     */
//    @Transient
//    public String getPstDirection() {
//        return pstDirection;
//    }
//
//    /**
//     * Setter pstDirection.
//     * 
//     * @param pstDirection the pstDirection to set
//     */
//    public void setPstDirection(String pstDirection) {
//        this.pstDirection = pstDirection;
//    }
//
//    /**
//     * Getter stjFrequency.
//     * 
//     * @return the stjFrequency
//     */
//    @Transient
//    public String getStjFrequency() {
//        return stjFrequency;
//    }
//
//    /**
//     * Setter stjFrequency.
//     * 
//     * @param stjFrequency the stjFrequency to set
//     */
//    public void setStjFrequency(String stjFrequency) {
//        this.stjFrequency = stjFrequency;
//    }
//
// }
