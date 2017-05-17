///*
// * Creation : Oct 12, 2015
// */
//package com.mic.exp.batch.dao.impl;
//
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
//
//import com.inetpsa.fwk.v3.dao.hibernate.GenericHibernateDao;
//import com.mic.exp.batch.common.Constants;
//import com.mic.exp.batch.dao.BatchTraceDao;
//import com.mic.exp.batch.model.BatchTrace;
//
//public class BatchTraceDaoImpl extends GenericHibernateDao<BatchTrace, Integer> implements BatchTraceDao {
//
//    @Override
//    public BatchTrace findLastBatchTrace(String batchName) {
//        Criteria criteria = this.getSession().createCriteria(this.getPersistentClass());
//        // criteria.createAlias(BatchTrace.PROP_BATCH, BatchTrace.PROP_BATCH);
//        criteria.add(Restrictions.eq(new StringBuilder().append(BatchTrace.PROP_ID_PST).toString(), batchName));
//        criteria.add(Restrictions.eq(BatchTrace.PROP_BT_STATUT, Constants.IN_PROGRESS));
//        criteria.addOrder(Order.desc(BatchTrace.PROP_BT_DT_TRAIT)).addOrder(Order.desc(BatchTrace.PROP_ID));
//        criteria.setMaxResults(1);
//        return (BatchTrace) criteria.uniqueResult();
//    }
// }
