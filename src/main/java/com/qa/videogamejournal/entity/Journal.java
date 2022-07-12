package com.qa.videogamejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer journalId;
	private String gameName;
	private String journalName;
	private String entry;
	
	public Journal(){}
	
	public Journal(Integer journalId, String gameName, String journalName, String entry) {
		this.journalId = journalId;
		this.gameName = gameName;
		this.journalName = journalName;
		this.entry = entry;
	}
	
	public Journal(String gameName, String journalName, String entry) {
		this.gameName = gameName;
		this.journalName = journalName;
		this.entry = entry;
	}
}
