package com.qa.videogamejournal.controller;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.repo.JournalRepo;
import com.qa.videogamejournal.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {
	
	private JournalRepo repo;
	private JournalService service;
	
	public JournalController(JournalService service, JournalRepo repo) {
		this.service = service;
		this.repo = repo;
	}
	
	@PostMapping("/journal/create")
	public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
		Journal created = service.createJournal(journal);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/journal/list-journals")
	public List<Journal> listJournals() {
		return this.service.listJournals();
	}
	
	@GetMapping("/journal/get-journal/{id}")
	public Journal getAJournal(@PathVariable("id") int id) {
		return service.getJournal(id);
	}
	
	@PatchMapping("/journal/update/{id}")
	public Journal updateJournal(@PathVariable("id") int id, @RequestBody Journal journal) {
		Journal updated = repo.findById(id).get();
		updated.setJournalName(journal.getJournalName());
		updated.setGameName(journal.getGameName());
		updated.setEntry(journal.getEntry());
		service.updateJournal(updated);
		return updated;
	}
	
	
	@DeleteMapping("/journal/delete/{id}")
	public ResponseEntity<?> deleteJournal(@PathVariable("id") int id) {
		service.deleteJournal(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
