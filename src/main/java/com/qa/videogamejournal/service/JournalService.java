package com.qa.videogamejournal.service;

import com.qa.videogamejournal.entity.Journal;

import java.util.List;

public interface JournalService {
	Journal createJournal(Journal journal);
	
	List<Journal> listJournals();
}
