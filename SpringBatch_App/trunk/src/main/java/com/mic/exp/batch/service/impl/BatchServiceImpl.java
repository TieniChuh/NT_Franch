/*
 * Creation : Aug 4, 2015
 */
package com.mic.exp.batch.service.impl;

import com.mic.exp.batch.dao.BatchDao;
import com.mic.exp.batch.model.Batch;
import com.mic.exp.batch.service.BatchService;

public class BatchServiceImpl implements BatchService {

    /** The batchDao. */
    private BatchDao batchDao;

    /**
     * Getter batchDao
     * 
     * @return the batchDao
     */
    public BatchDao getBatchDao() {
        return batchDao;
    }

    /**
     * Setter batchDao
     * 
     * @param batchDao the batchDao to set
     */
    public void setBatchDao(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.batch.service.BatchService#checkNameExist(java.lang.String)
     */
    @Override
    public boolean checkNameExist(String name) {
        Batch batch = batchDao.findByName(name);
        boolean flag = false;
        if (batch != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.batch.service.BatchService#findByName(java.lang.String)
     */
    @Override
    public Batch findByName(String name) {

        return batchDao.findByName(name);
    }

}
