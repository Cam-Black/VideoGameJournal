package com.qa.videogamejournal.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Console;
import java.util.Arrays;

public class IOUtil {
    private static final Console console = System.console();
    private static final Logger LOGGER = LogManager.getLogger();

    private IOUtil(){}

    public static String getPassword() {
        LOGGER.info("Enter db password: ");
        return Arrays.toString(console.readPassword());
    }
}
