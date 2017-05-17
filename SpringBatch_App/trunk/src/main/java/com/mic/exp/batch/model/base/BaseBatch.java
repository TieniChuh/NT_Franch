package com.mic.exp.batch.model.base;

import java.io.Serializable;

import com.mic.exp.batch.model.Batch;

/**
 * This is an object that contains data related to the BCAQTLB0 table. Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="BCAQTLB0"
 */
// CHECKSTYLE:OFF comment
public abstract class BaseBatch implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    public static final String REF = "batch";
    public static final String PROP_ID = "id";
    public static final String PROP_LB_NOM = "lbNom";

    // constructors
    /**
     * Generic constructor
     */
    public BaseBatch() {
        initialize();
    }

    /**
     * Constructor for primary key
     * 
     * @param id
     */
    public BaseBatch(java.lang.Integer id) {
        this.setId(id);
        initialize();
    }

    /**
     * Constructor for required fields
     * 
     * @param id the id
     * @param lbNom the nom
     */
    public BaseBatch(java.lang.Integer id, java.lang.String lbNom) {

        this.setId(id);
        this.setLbNom(lbNom);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String lbNom;

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id generator-class="sequence" column="LB_IDBATCH"
     */
    public java.lang.Integer getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id the new ID
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: LB_NOM
     */
    public java.lang.String getLbNom() {
        return lbNom;
    }

    /**
     * Set the value related to the column: LB_NOM
     * 
     * @param lbNom the LB_NOM value
     */
    public void setLbNom(java.lang.String lbNom) {
        this.lbNom = lbNom;
    }

    @Override
    /**
     * 
     * {@inheritDoc}
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof Batch))
            return false;
        Batch batch = (Batch) obj;
        if (null == this.getId() || null == batch.getId())
            return false;
        return (this.getId().equals(batch.getId()));
    }

    @Override
    /**
     * 
     * {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId())
                return super.hashCode();
            String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
            this.hashCode = hashStr.hashCode();
        }
        return this.hashCode;
    }

    @Override
    /**
     * 
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return super.toString();
    }

}