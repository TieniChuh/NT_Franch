/*
 * Creation : Aug 4, 2015
 */
package com.mic.exp.batch.service;

import com.mic.exp.batch.model.Batch;

public interface BatchService {
    /**
     * checkNameExist
     * 
     * @param name String
     * @return the boolean
     */
    boolean checkNameExist(String name);

    /**
     * findByName
     * 
     * @param name String
     * @return the Batch
     */
    Batch findByName(String name);
}
