///*
// * Creation : Dec 23, 2013
// */
//package com.mic.exp.batch.model.base;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.SequenceGenerator;
//
//import com.mic.exp.batch.model.BatchTrace;
//
///**
// * The Class BaseBatchTrace.
// */
//@MappedSuperclass
//public class BaseBatchTrace implements Serializable {
//
//    public static final String PROP_BATCH = "batchTrace";
//    public static final String PROP_BT_STATUT = "status";
//    public static final String PROP_BT_DT_TRAIT = "realBeginningDate";
//
//    /** The Constant serialVersionUID. */
//    private static final long serialVersionUID = 1355429201960345992L;
//
//    /** The Constant COL_ID_PST. */
//    public static final String COL_ID_PST = "TRA_ID_PST";
//
//    /** The Constant COL_BEGININGDATE. */
//    public static final String COL_BEGININGDATE = "TRA_BEGININGDATE";
//
//    /** The Constant COL_TIMEELAPSE. */
//    public static final String COL_TIMEELAPSE = "TRA_TIMEELAPSE";
//
//    /** The Constant COL_STATUS. */
//    public static final String COL_STATUS = "TRA_STATUS";
//
//    /** The Constant COL_NBPROCESSEDBLOCS. */
//    public static final String COL_NBPROCESSEDBLOCS = "TRA_NBPROCESSEDBLOCS";
//
//    /** The Constant COL_NBPROCESSEDLINES. */
//    public static final String COL_NBPROCESSEDLINES = "TRA_NBPROCESSEDLINES";
//
//    /** The Constant PROP_ID. */
//    public static final String PROP_ID = "id";
//
//    /** The Constant PROP_ID_PST. */
//    public static final String PROP_ID_PST = "idPst";
//
//    /** The Constant PROP_ID_LST. */
//    public static final String PROP_ID_LST = "idLst";
//
//    /** The hash code. */
//    private int hashCode = Integer.MIN_VALUE;
//
//    /** The id. */
//    private Long id;
//
//    /** The id pst. */
//    private String idPst;
//
//    /** The id lst. */
//    private Long idLst;
//
//    /** The begining date. */
//    private Date beginningDate;
//
//    /** The time elapse. */
//    private Long timeElapse;
//
//    /** The status. */
//    private String status;
//
//    /** The nb processed blocks. */
//    private Long nbProcessedBlocs;
//
//    /** The nb processed lines. */
//    private Long nbProcessedLines;
//
//    /** The general message. */
//    private String generalMessage;
//
//    /** The cpu elapse. */
//    private Long cpuElapse;
//
//    /** The file lines number. */
//    private Long fileLinesNumber;
//
//    /** The treated lines number. */
//    private Long treatedLinesNumber;
//
//    /** The records number. */
//    private Long recordsNumber;
//
//    /** The id batch. */
//    private Long idBatch;
//
//    /** The real begining date. */
//    private Date realBeginningDate;
//
//    /**
//     * Getter id.
//     * 
//     * @return the id
//     */
//    @Id
//    @Column(name = "TRA_ID")
//    @SequenceGenerator(name = "mioqntra", sequenceName = "MIOQNTRA", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mioqntra")
//    public Long getId() {
//        return id;
//    }
//
//    /**
//     * Setter id.
//     * 
//     * @param id the id to set
//     */
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    /**
//     * Getter idPst.
//     * 
//     * @return the idPst
//     */
//    @Column(name = "TRA_ID_PST")
//    public String getIdPst() {
//        return idPst;
//    }
//
//    /**
//     * Setter idPst.
//     * 
//     * @param idPst the idPst to set
//     */
//    public void setIdPst(String idPst) {
//        this.idPst = idPst;
//    }
//
//    /**
//     * Getter idLst.
//     * 
//     * @return the idLst
//     */
//    @Column(name = "TRA_ID_LST")
//    public Long getIdLst() {
//        return idLst;
//    }
//
//    /**
//     * Setter idLst.
//     * 
//     * @param idLst the idLst to set
//     */
//    public void setIdLst(Long idLst) {
//        this.idLst = idLst;
//    }
//
//    /**
//     * Getter beginningDate.
//     * 
//     * @return the beginningDate
//     */
//    @Column(name = "TRA_BEGININGDATE")
//    public Date getBeginningDate() {
//        return beginningDate;
//    }
//
//    /**
//     * Setter beginningDate.
//     * 
//     * @param beginningDate the beginningDate to set
//     */
//    public void setBeginningDate(Date beginningDate) {
//        this.beginningDate = beginningDate;
//    }
//
//    /**
//     * Getter timeElapse.
//     * 
//     * @return the timeElapse
//     */
//    @Column(name = "TRA_TIMEELAPSE")
//    public Long getTimeElapse() {
//        return timeElapse;
//    }
//
//    /**
//     * Setter timeElapse.
//     * 
//     * @param timeElapse the timeElapse to set
//     */
//    public void setTimeElapse(Long timeElapse) {
//        this.timeElapse = timeElapse;
//    }
//
//    /**
//     * Getter status.
//     * 
//     * @return the status
//     */
//    @Column(name = "TRA_STATUS")
//    public String getStatus() {
//        return status;
//    }
//
//    /**
//     * Setter status.
//     * 
//     * @param status the status to set
//     */
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    /**
//     * Getter nbProcessedBlocks.
//     * 
//     * @return the nbProcessedBlocks
//     */
//    @Column(name = "TRA_NBPROCESSEDBLOCS")
//    public Long getNbProcessedBlocs() {
//        return nbProcessedBlocs;
//    }
//
//    /**
//     * Setter nbProcessedBlocs.
//     * 
//     * @param nbProcessedBlocs the nbProcessedBlocs to set
//     */
//    public void setNbProcessedBlocs(Long nbProcessedBlocs) {
//        this.nbProcessedBlocs = nbProcessedBlocs;
//    }
//
//    /**
//     * Getter nbProcessedLines.
//     * 
//     * @return the nbProcessedLines
//     */
//    @Column(name = "TRA_NBPROCESSEDLINES")
//    public Long getNbProcessedLines() {
//        return nbProcessedLines;
//    }
//
//    /**
//     * Setter nbProcessedLines.
//     * 
//     * @param nbProcessedLines the nbProcessedLines to set
//     */
//    public void setNbProcessedLines(Long nbProcessedLines) {
//        this.nbProcessedLines = nbProcessedLines;
//    }
//
//    /**
//     * Getter generalMessage.
//     * 
//     * @return the generalMessage
//     */
//    @Column(name = "TRA_GENERALMESSAGE")
//    public String getGeneralMessage() {
//        return generalMessage;
//    }
//
//    /**
//     * Setter generalMessage.
//     * 
//     * @param generalMessage the generalMessage to set
//     */
//    public void setGeneralMessage(String generalMessage) {
//        this.generalMessage = generalMessage;
//    }
//
//    /**
//     * Getter cpuElapse.
//     * 
//     * @return the cpuElapse
//     */
//    @Column(name = "TRA_CPUELAPSE")
//    public Long getCpuElapse() {
//        return cpuElapse;
//    }
//
//    /**
//     * Setter cpuElapse.
//     * 
//     * @param cpuElapse the cpuElapse to set
//     */
//    public void setCpuElapse(Long cpuElapse) {
//        this.cpuElapse = cpuElapse;
//    }
//
//    /**
//     * Getter fileLinesNumber
//     * 
//     * @return the fileLinesNumber
//     */
//    @Column(name = "TRA_FILELINESNUMBER")
//    public Long getFileLinesNumber() {
//        return fileLinesNumber;
//    }
//
//    /**
//     * Setter fileLinesNumber
//     * 
//     * @param fileLinesNumber the fileLinesNumber to set
//     */
//    public void setFileLinesNumber(Long fileLinesNumber) {
//        this.fileLinesNumber = fileLinesNumber;
//    }
//
//    /**
//     * Getter treatedLinesNumber
//     * 
//     * @return the treatedLinesNumber
//     */
//    @Column(name = "TRA_TREATEDLINESNUMBER")
//    public Long getTreatedLinesNumber() {
//        return treatedLinesNumber;
//    }
//
//    /**
//     * Setter treatedLinesNumber
//     * 
//     * @param treatedLinesNumber the treatedLinesNumber to set
//     */
//    public void setTreatedLinesNumber(Long treatedLinesNumber) {
//        this.treatedLinesNumber = treatedLinesNumber;
//    }
//
//    /**
//     * Getter recordsNumber
//     * 
//     * @return the recordsNumber
//     */
//    @Column(name = "TRA_RECORDSNUMBER")
//    public Long getRecordsNumber() {
//        return recordsNumber;
//    }
//
//    /**
//     * Setter recordsNumber
//     * 
//     * @param recordsNumber the recordsNumber to set
//     */
//    public void setRecordsNumber(Long recordsNumber) {
//        this.recordsNumber = recordsNumber;
//    }
//
//    /**
//     * {@inheritDoc}
//     * 
//     * @see java.lang.Object#equals(java.lang.Object)
//     */
//    @Override
//    public boolean equals(Object obj) {
//        if (null == obj) {
//            return false;
//        }
//        if (!(obj instanceof BatchTrace)) {
//            return false;
//        }
//        BatchTrace batchTrace = (BatchTrace) obj;
//        if (null == this.getId() || null == batchTrace.getId()) {
//            return false;
//        }
//        return (this.getId().equals(batchTrace.getId()));
//    }
//
//    /**
//     * {@inheritDoc}
//     * 
//     * @see java.lang.Object#hashCode()
//     */
//    @Override
//    public int hashCode() {
//        if (Integer.MIN_VALUE == this.hashCode) {
//            if (null == this.getId()) {
//                return super.hashCode();
//            }
//            String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
//            this.hashCode = hashStr.hashCode();
//
//        }
//        return this.hashCode;
//    }
//
//    /**
//     * Getter idBatch
//     * 
//     * @return the idBatch
//     */
//    @Column(name = "TRA_ID_BATCH")
//    public Long getIdBatch() {
//        return idBatch;
//    }
//
//    /**
//     * Setter idBatch
//     * 
//     * @param idBatch the idBatch to set
//     */
//    public void setIdBatch(Long idBatch) {
//        this.idBatch = idBatch;
//    }
//
//    /**
//     * Getter realBeginningDate
//     * 
//     * @return the realBeginningDate
//     */
//    @Column(name = "TRA_REAL_BEGIN_DATE")
//    public Date getRealBeginningDate() {
//        return realBeginningDate;
//    }
//
//    /**
//     * Setter realBeginningDate
//     * 
//     * @param realBeginningDate the realBeginningDate to set
//     */
//    public void setRealBeginningDate(Date realBeginningDate) {
//        this.realBeginningDate = realBeginningDate;
//    }
//
// }
