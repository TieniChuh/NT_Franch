///*
// * Creation : Aug 4, 2015
// */
//package com.mic.exp.batch.service.impl;
//
//import com.mic.exp.batch.dao.BatchTraceDao;
//import com.mic.exp.batch.model.BatchTrace;
//import com.mic.exp.batch.service.BatchTraceService;
//
//public class BatchTraceServiceImpl implements BatchTraceService {
//
//    /** The batchTraceDao. */
//    private BatchTraceDao batchTraceDao;
//
//    /**
//     * Getter batchTraceDao
//     * 
//     * @return the batchTraceDao
//     */
//    public BatchTraceDao getBatchDao() {
//        return batchTraceDao;
//    }
//
//    /**
//     * Setter batchTraceDao
//     * 
//     * @param batchTraceDao the batchTRaceDao to set
//     */
//    public void setBatchTraceDao(BatchTraceDao batchTraceDao) {
//        this.batchTraceDao = batchTraceDao;
//    }
//
//    @Override
//    public void createOrUpdateSuiviBatchTrace(BatchTrace batchTrace) {
//        batchTraceDao.createOrUpdate(batchTrace);
//
//    }
//
//    @Override
//    public BatchTrace findLastBatchTrace(String batchName) {
//        return batchTraceDao.findLastBatchTrace(batchName);
//    }
//
// }
