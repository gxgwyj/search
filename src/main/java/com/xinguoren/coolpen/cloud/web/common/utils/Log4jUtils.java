package com.xinguoren.coolpen.cloud.web.common.utils;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/4/20.
 */
public class Log4jUtils {
    private static Logger logger = Logger.getLogger(Log4jUtils.class);

    public static void main(String[] args) {
        logger.error("This is error message");
        logger.warn("This is warn message");
        logger.info("This is info message");
        logger.debug("This is debug message");

    }
}
