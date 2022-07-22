package com.qa.videogamejournal.service;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.repo.JournalRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
	
	@Override
	public List<Journal> listJournals() {
		return repo.findAll();
	}
	
	@Override
	public Journal getJournal(int id) {
		return repo.findById(id).get();
	}
	
	@Override
	public boolean deleteJournal(int id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	@Override
	public Journal updateJournal(Journal journal) {
		return repo.save(journal);
	}
}
