///*
// * Creation : 23 avr. 2015
// */
//package com.mic.exp.batch.integration.test;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.mic.exp.batch.integration.IntegrationTest;
//import com.mic.exp.batch.integration.LaunchBatch;
//
///**
// * The Class V001IntegrationTest.
// */
//@org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
//@org.springframework.test.context.ContextConfiguration(locations = { "classpath:commons-batch.xml" })
//public class V001IntegrationTest extends IntegrationTest {
//
//    /** the logger. */
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    /**
//     * Test. launch the bacth and verfity the whole treatment. In this case, the nominal case
//     */
//    @Test
//    public void test() {
//        try {
//            Assert.assertEquals(this.launch(), 0);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    /**
//     * the launch.
//     * 
//     * @return the int
//     * @throws Exception the exception
//     */
//    private int launch() throws Exception {
//        final String[] args = new String[2];
//        args[0] = "jobs/v001Job.xml";
//        args[1] = "v001Job";
//        return LaunchBatch.launch(args);
//    }
//
// }
