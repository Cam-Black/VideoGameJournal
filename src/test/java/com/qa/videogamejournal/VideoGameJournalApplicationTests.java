package com.qa.videogamejournal;

import com.qa.videogamejournal.controller.JournalController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class VideoGameJournalApplicationTests {

    @Autowired
    private JournalController controller;
    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}

