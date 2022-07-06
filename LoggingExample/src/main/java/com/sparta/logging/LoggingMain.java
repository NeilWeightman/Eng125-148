package com.sparta.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingMain {
    public static Logger logger = LogManager.getLogger("My Logger"); // loads the props
    public static void main(String[] args) {
        // trace, debug, info, warn, error, fatal
        logger.info("This is an info message");
        logger.warn("Hello Warning");
        logger.error("This is an error");
        try{
            int i = 3;
            int j = 0;
            int k = i/j;
        } catch(Exception e){
            logger.error("Oops you screwed up!", e);
        }
        DoSomething d = new DoSomething();
        d.doWhatever();
    }
}
