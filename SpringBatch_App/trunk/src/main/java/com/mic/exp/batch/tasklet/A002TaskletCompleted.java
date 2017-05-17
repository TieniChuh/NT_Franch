package com.mic.exp.batch.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * The Class V002TaskletCompleted.
 */
public class A002TaskletCompleted implements Tasklet {

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.batch.core.step.tasklet.Tasklet#execute(org.springframework.batch.core.StepContribution,
     *      org.springframework.batch.core.scope.context.ChunkContext)
     */
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        contribution.setExitStatus(ExitStatus.COMPLETED);
        return RepeatStatus.FINISHED;
    }

}
