package com.qa.videogamejournal.controller;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalController {
	
	private JournalService service;
	
	public JournalController(JournalService service) {
		this.service = service;
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
}
