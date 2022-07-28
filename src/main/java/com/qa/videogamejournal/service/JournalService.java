package com.qa.videogamejournal.service;

import com.qa.videogamejournal.entity.Journal;

import java.util.List;

public interface JournalService {
	Journal createJournal(Journal journal);
	
	List<Journal> listJournals();
	
	Journal getJournal(int id);
	
	boolean deleteJournal(int id);
	
	Journal updateJournal(Journal journal);
}
