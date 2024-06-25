package org.romeocust;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


  // https://www.studytonight.com/post/log4j2-programmatic-configuration-in-java-class
  // https://www.baeldung.com/log4j2-programmatic-config
  // https://logging.apache.org/log4j/log4j-2.7/manual/appenders.html#RollingFileAppender  // How to config RollingFile for 2.5 > version. Not fits for my 2.2 (

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello world! begin");
        //org.romeocust.infrastructure.Logger.InitMyDelOldFiles();
        new org.romeocust.infrastructure.LoggerWorker(); // to call static method and init logger

        Logger loggerRoot = LogManager.getRootLogger();

        logger.error("log4j: logger.error");
        logger.info("log4j: logger.info");
        logger.debug("log4j: logger.debug");

        loggerRoot.info("test from root logger log4j");



        System.out.println("Hello world! end");
    }
}