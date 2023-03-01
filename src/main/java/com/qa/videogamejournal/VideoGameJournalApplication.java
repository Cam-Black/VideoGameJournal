package com.qa.videogamejournal;

import com.qa.videogamejournal.utils.IOUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoGameJournalApplication {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String pass = IOUtil.getPassword();
        System.setProperty("pass", pass);
        SpringApplication.run(VideoGameJournalApplication.class, args);
    }
}