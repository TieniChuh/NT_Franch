package com.mic.exp.batch.integration;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class MainExec {
    // private static final Logger LOGGER = LoggerFactory.getLogger(MainExec.class);

    public static void main(String[] args) {
        try {
            CommandLineJobRunner.main(args);
        } catch (Exception e) {
            // LOGGER.error("ERROR RUN ", e);
            System.exit(1);
        }

    }

}
