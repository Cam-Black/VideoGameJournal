package com.qa.videogamejournal.controller;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.repo.JournalRepo;
import com.qa.videogamejournal.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/journal")
public class JournalController {
	
	private final JournalRepo repo;
	private final JournalService service;
	
	public JournalController(JournalService service, JournalRepo repo) {
		super();
		this.service = service;
		this.repo = repo;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
		Journal created = service.createJournal(journal);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/list-journals")
	public List<Journal> listJournals() {
		return this.service.listJournals();
	}
	
	@GetMapping("/get-journal/{id}")
	public Journal getAJournal(@PathVariable("id") int id) {
		return service.getJournal(id);
	}
	
	@PatchMapping("/update/{id}")
	public Journal updateJournal(@PathVariable("id") int id, @RequestBody Journal journal) {
		Journal updated = repo.findById(id).orElse(null);
		assert updated != null;
		updated.setJournalName(journal.getJournalName());
		updated.setGameName(journal.getGameName());
		updated.setEntry(journal.getEntry());
		service.updateJournal(updated);
		return updated;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteJournal(@PathVariable("id") int id) {
		service.deleteJournal(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}