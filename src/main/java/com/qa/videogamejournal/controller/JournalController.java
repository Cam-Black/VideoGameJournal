package com.qa.videogamejournal.controller;

import com.qa.videogamejournal.entity.Journal;
import com.qa.videogamejournal.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
