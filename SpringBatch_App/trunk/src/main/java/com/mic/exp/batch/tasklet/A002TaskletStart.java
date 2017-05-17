package com.mic.exp.batch.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.mic.exp.batch.common.utils.SpringPropertiesUtil;

/**
 * The Class V002TaskletStart.
 */
public class A002TaskletStart implements Tasklet {

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.batch.core.step.tasklet.Tasklet#execute(org.springframework.batch.core.StepContribution,
     *      org.springframework.batch.core.scope.context.ChunkContext)
     */
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        // init default exit status
        contribution.setExitStatus(ExitStatus.COMPLETED);
        String name = SpringPropertiesUtil.getProperty("mio.batch.a001.batchName");

        // end
        return RepeatStatus.FINISHED;
    }

}
