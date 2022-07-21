package com.qa.videogamejournal.service;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.repo.JournalRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ServiceDBTest {
	
	@Autowired
	private JournalServiceDB service;
	
	@MockBean
	private JournalRepo repo;
	
	@Test
	void testCreateJournal() {
		final Journal TEST_JOURNAL = new Journal(null, "Learning the Game", "Crusader Kings II",
												 "Started the game as the ruler of Mumu in Old Ireland");
		final Journal TEST_SAVED_JOURNAL = new Journal(1, "Learning the Game", "Crusader Kings II",
													"Started the game as the ruler of Mumu in Old Ireland");
		Mockito.when(this.repo.save(TEST_JOURNAL)).thenReturn(TEST_SAVED_JOURNAL);
		
		Assertions.assertThat(this.service.createJournal(TEST_JOURNAL)).isEqualTo(TEST_SAVED_JOURNAL);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_JOURNAL);
	}
}
