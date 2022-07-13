package com.qa.videogamejournal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.videogamejournal.entity.Journal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:journal-schema.sql", "classpath:journal-data.sql"},
	 executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class JournalControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreateJournal() throws Exception {
		Journal testJournal = new Journal("Divinity", "Journal One", "Started game");
		String testJournalAsJSON = this.mapper.writeValueAsString(testJournal);
		Journal createdJournal = new Journal(2, "Divinity", "Journal One", "Started game");
		String createdJournalAsJSON = this.mapper.writeValueAsString(createdJournal);
		this.mvc.perform(post("/journal/create").content(testJournalAsJSON)
												.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(createdJournalAsJSON));
	}
	
	@Test
	void testListJournals() throws Exception {
		List<Journal> journals = new ArrayList<>();
		journals.add(new Journal(1, "CoD", "Modern Warfare", "Shot enemies"));
		String listAsJSON = this.mapper.writeValueAsString(journals);
		this.mvc.perform(get("/journal/list-journals"))
				.andExpect(content().json(listAsJSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void testGetJournal() throws Exception {
		Journal journal = new Journal(1, "CoD", "Modern Warfare", "Shot enemies");
		String journalAsJSON = this.mapper.writeValueAsString(journal);
		this.mvc.perform(get("/journal/get-journal/1"))
				.andExpect(content().json(journalAsJSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void testUpdateJournal() {
	
	}
	@Test
	void testDeleteJournal() throws Exception {
		this.mvc.perform(delete("/journal/delete/1"))
				.andExpect(status().isNoContent());
	}
}