/*
 * Creation : 23 avr. 2015
 */
package com.mic.exp.batch.integration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

/**
 * The Class LaunchBatch.
 */
public class LaunchBatch {

    /** the logger. */
    // private static final Logger LOGGER = LoggerFactory.getLogger(LaunchBatch.class);

    /** the NB_PARAMS_START. */
    private static final int NB_PARAMS_START = 4;

    /** the TROIS. */
    private static final int TROIS = 3;

    /**
     * Constructor LaunchBatch.
     */
    private LaunchBatch() {

    }

    /**
     * the launch.
     * 
     * @param args liste des arguments pour lancer le bacth
     * @return 0 -> ok, 1 -> ko
     * @throws Exception Exception
     */
    public static int launch(final String[] args) throws Exception {

        final CommandLineJobRunner command = new CommandLineJobRunner();

        final List<String> newargs = new ArrayList<String>(Arrays.asList(args));

        if (System.in.available() > 0) {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = " ";
            while (org.springframework.util.StringUtils.hasLength(line)) {
                if (!line.startsWith("#") && org.springframework.util.StringUtils.hasText(line)) {
                    // LaunchBatch.LOGGER.debug("Stdin arg: " + line);
                    newargs.add(line);
                }
                line = reader.readLine();
            }
        }

        final Set<String> opts = new HashSet<String>();
        final List<String> params = new ArrayList<String>();

        int count = 0;
        String jobPath = null;
        String jobIdentifier = null;

        for (final String arg : newargs) {
            if (arg.startsWith("-")) {
                opts.add(arg);
            } else {
                switch (count) {
                case 0:
                    jobPath = arg;
                    break;
                case 1:
                    jobIdentifier = arg;
                    break;
                default:
                    params.add(arg);
                    break;
                }
                count++;
            }
        }

        if ((jobPath == null) || (jobIdentifier == null)) {
            final String message = "At least 2 arguments are required: JobPath and jobIdentifier.";
            // LaunchBatch.LOGGER.error(message);
            return 1;
        }

        final String[] parameters = params.toArray(new String[params.size()]);

        final Object[] startParams = new Object[LaunchBatch.NB_PARAMS_START];
        startParams[0] = jobPath;
        startParams[1] = jobIdentifier;
        startParams[2] = parameters;
        startParams[LaunchBatch.TROIS] = opts;

        final Method startMethod = command.getClass().getDeclaredMethod("start", String.class, String.class, String[].class, Set.class);
        startMethod.setAccessible(true);
        final int res = (Integer) startMethod.invoke(command, startParams);
        return res;
    }

    public static void main(String[] args) {
        try {
            System.exit(LaunchBatch.launch(args));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // LaunchBatch.LOGGER.error("STOP!");
        }
    }

}
