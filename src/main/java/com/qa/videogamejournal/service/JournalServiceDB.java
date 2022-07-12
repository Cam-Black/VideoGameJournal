package com.qa.videogamejournal.service;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.repo.JournalRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class JournalServiceDB implements JournalService {
	
	private JournalRepo repo;
	
	public JournalServiceDB(JournalRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Journal createJournal(Journal journal) {
		return repo.save(journal);
	}
}
