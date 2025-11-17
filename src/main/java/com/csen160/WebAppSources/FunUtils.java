package com.csen160.WebAppSources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunUtils {
    private static final Logger logger = LoggerFactory.getLogger(FunUtils.class);

	public static String makeItLower(String data) {
        logger.info("FunUtils.makeItLower() called with data: " + data);
        return data.toLowerCase();
	}
}