package com.sample.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class LoggerWrapper {
    private static MdcWrapper mdcWrapper = new MdcWrapper();
    private final Class clazz;

    public LoggerWrapper(Class clazz) {
        this.clazz = clazz;
    }

    public void debug(String message) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(message);
    }

    public void debug(String message, Throwable throwable) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(message, throwable);
    }

    public void info(String message) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(message);
    }

    public void info(String message, Throwable throwable) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(message, throwable);
    }

    public void warn(String message) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.warn(message);
    }

    public void warn(String message, Throwable throwable) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.warn(message, throwable);
    }

    public void error(String message) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message);
    }

    public void error(String message, Throwable throwable) {
        validateAppIdAndName();
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message, throwable);
    }

    private void validateAppIdAndName() {
        if (appIdIsNotConfigured() || appNameIsNotConfigured()) {
            setDefaultAppIdAndAppName();
        }
    }

    private boolean appIdIsNotConfigured() {
        return StringUtils.isEmpty(mdcWrapper.get("appId"));
    }

    private boolean appNameIsNotConfigured() {
        return StringUtils.isEmpty(mdcWrapper.get("appName"));
    }

    private void setDefaultAppIdAndAppName() {
        mdcWrapper.put("appId", "11111");
        mdcWrapper.put("appName", "SampleRESTApp");
    }
}