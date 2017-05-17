/*
 * Creation : May 3, 2017
 */
package com.mic.exp.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.mic.exp.batch.common.Constants;
import com.mic.exp.batch.processor.A002Processor;

public class A002ProcessorListener implements StepExecutionListener {

    private A002Processor process;

    public A002ProcessorListener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        String invoiceNumPrefix = (String) stepExecution.getJobExecution().getExecutionContext().get(Constants.STR_INVOICE_NUMBER_PREFIX);
        // process.setInvoiceNumberPrefix(invoiceNumPrefix);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        // stepExecution.getJobExecution().getExecutionContext().put(Constants.STR_UPDATE_FRECOUNTER, process.getFreCounterCurrent());
        return ExitStatus.COMPLETED;
    }

    public void setProcess(A002Processor process) {
        this.process = process;
    }

}
