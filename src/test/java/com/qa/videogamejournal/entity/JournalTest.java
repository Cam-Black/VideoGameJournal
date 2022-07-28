package com.qa.videogamejournal.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JournalTest {
	@Test
	void testToString() {
		final Journal TEST_JOURNAL = new Journal(1, "My Journal", "My Game", "My Entry");
		final String TEST_JOURNAL_AS_STRING =
				"Journal{journalId=1, journalName='My Journal', gameName='My Game', entry='My Entry'}";
		assertEquals(TEST_JOURNAL_AS_STRING, TEST_JOURNAL.toString());
	}
}
