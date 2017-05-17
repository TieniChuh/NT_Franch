/*
 * Creation : Mar 17, 2015
 */
package com.mic.exp.batch.dao;

import com.mic.exp.batch.model.Batch;

/**
 * Dao interface for Batch
 * 
 * @author e342921
 */
public interface BatchDao {
    /**
     * findByName
     * 
     * @param name String
     * @return the Batch
     */
    Batch findByName(String name);
}
