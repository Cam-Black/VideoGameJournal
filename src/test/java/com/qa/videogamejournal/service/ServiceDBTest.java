package com.qa.videogamejournal.service;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.repo.JournalRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Sql(scripts = {"classpath:journal-schema.sql", "classpath:journal-data.sql"},
	 executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ServiceDBTest {
	
	@Autowired
	private JournalServiceDB service;
	
	@MockBean
	private JournalRepo repo;
	
	@Test
	void testCreateJournal() {
		final Journal TEST_JOURNAL = new Journal("Learning the Game", "Crusader Kings II",
												 "Started the game as the ruler of Mumu in Old Ireland");
		final Journal TEST_SAVED_JOURNAL = new Journal(1, "Learning the Game", "Crusader Kings II",
													   "Started the game as the ruler of Mumu in Old Ireland");
		Mockito.when(this.repo.save(TEST_JOURNAL)).thenReturn(TEST_SAVED_JOURNAL);
		
		Assertions.assertThat(this.service.createJournal(TEST_JOURNAL)).isEqualTo(TEST_SAVED_JOURNAL);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_JOURNAL);
	}
	
	@Test
	void testListJournals() {
		final List<Journal> TEST_JOURNAL_LIST = new ArrayList<>();
		final Journal TEST_JOURNAL = new Journal(1, "My Character", "FFXIV", "Created Character");
		TEST_JOURNAL_LIST.add(TEST_JOURNAL);
		Mockito.when(this.repo.findAll()).thenReturn(TEST_JOURNAL_LIST);
		
		Assertions.assertThat(this.service.listJournals()).isEqualTo(TEST_JOURNAL_LIST);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testGetJournal() {
		final Journal TEST_JOURNAL = new Journal(1, "Going Dark", "Modern Warfare", "Infiltrated building at night");
		
		Mockito.when(this.repo.findById(1)).thenReturn(Optional.of(TEST_JOURNAL));
		
		Assertions.assertThat(this.service.getJournal(1)).isEqualTo(TEST_JOURNAL);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1);
	}
	
	@Test
	void testDeleteJournal() {
		final Journal TEST_JOURNAL = new Journal(1, "My First Time", "Skyrim", "Finally got to the top of those " +
				"stairs... wait what is that thing?");

		Mockito.when(this.repo.existsById(1)).thenReturn(false);

		Assertions.assertThat(this.service.deleteJournal(1)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(1);
	}
	
	@Test
	void testUpdateJournal() {
		final Journal TEST_JOURNAL = new Journal(1, "Name", "Game", "Entry");
		final Journal UPDATED_JOURNAL = new Journal(1, "New Name", "New Game", "New Entry");
		
		Mockito.when(this.repo.save(TEST_JOURNAL)).thenReturn(UPDATED_JOURNAL);
		
		Assertions.assertThat(this.service.updateJournal(TEST_JOURNAL)).isEqualTo(UPDATED_JOURNAL);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_JOURNAL);
	}
}
