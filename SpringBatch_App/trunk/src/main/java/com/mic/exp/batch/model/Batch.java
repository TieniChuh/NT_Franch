package com.mic.exp.batch.model;

import com.mic.exp.batch.model.base.BaseBatch;

/**
 * Main model class related to table BCAQTLB0.
 * 
 * @author e398580
 */
public class Batch extends BaseBatch {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /* [CONSTRUCTOR MARKER BEGIN] */
    /**
     * Default constructor
     */
    public Batch() {
        super();
    }

    /**
     * Constructor for primary key
     * 
     * @param id Integer
     */
    public Batch(java.lang.Integer id) {
        super(id);
    }

    /**
     * Constructor for required fields
     * 
     * @param id Integer
     * @param lbNom String
     */
    public Batch(java.lang.Integer id, java.lang.String lbNom) {

        super(id, lbNom);
    }

    /* [CONSTRUCTOR MARKER END] */

}