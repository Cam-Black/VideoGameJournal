package com.qa.videogamejournal.entity;

import javax.persistence.*;

@Entity
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer journalId;
	private String gameName;
	private String journalName;
	@Column(columnDefinition = "TEXT")
	private String entry;
	
	public Journal(){}
	
	public Journal(Integer journalId, String journalName, String gameName,  String entry) {
		this.journalId = journalId;
		this.journalName = journalName;
		this.gameName = gameName;
		this.entry = entry;
	}
	
	public Journal(String journalName, String gameName, String entry) {
		this.journalName = journalName;
		this.gameName = gameName;
		this.entry = entry;
	}
	
	public Integer getJournalId() {
		return journalId;
	}
	
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getJournalName() {
		return journalName;
	}
	
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "Journal{" +
				"journalId=" + journalId +
				", gameName='" + gameName + '\'' +
				", journalName='" + journalName + '\'' +
				", entry='" + entry + '\'' +
				'}';
	}
}
