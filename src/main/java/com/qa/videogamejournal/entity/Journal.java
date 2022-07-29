package com.qa.videogamejournal.entity;

import javax.persistence.*;

/**
 * Entity for creating Journal table in database.
 * Used to store information relating to a journal entry such as a journal name, a game name and an entry.
 */
@Entity
public class Journal {
	//Auto generated, auto incrementing ID.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer journalId;
	private String journalName;
	private String gameName;
	 //Informs database to convert from String to TEXT field instead of default of VARCHAR(255)
	@Column(columnDefinition = "TEXT")
	private String entry;
	
	/**
	 * Default constructor.
	 */
	public Journal(){
		super();
	}
	
	/**
	 * Constructor to create a journal entity with all values passed in.
	 * Used in testing to allow passing of an id to ensure entry is stored at a fixed point in the database.
	 * @param journalId Integer value used to store the entity in a location in the database.
	 * @param journalName String value to store a name for a journal entry.
	 * @param gameName String value to store the name of the game the journal entity belongs to.
	 * @param entry TEXT field to store large amount of text, main body for the entry of a journal.
	 */
	public Journal(Integer journalId, String journalName, String gameName,  String entry) {
		super();
		this.journalId = journalId;
		this.journalName = journalName;
		this.gameName = gameName;
		this.entry = entry;
	}
	
	/**
	 * Constructor which is used to create the journal entity in the scope of the app.
	 * journalId is omitted as it is automatically generated and automatically increments.
	 * @param journalName String value to store a name for a journal entry.
	 * @param gameName String value to store the name of the game the journal entity belongs to.
	 * @param entry TEXT field to store large amount of text, main body for the entry of a journal.
	 */
	public Journal(String journalName, String gameName, String entry) {
		super();
		this.journalName = journalName;
		this.gameName = gameName;
		this.entry = entry;
	}
	
	/**
	 * Gets the value of journalId of a Journal entity.
	 * @return journalId
	 */
	public Integer getJournalId() {
		return journalId;
	}
	
	/**
	 * Sets the value of a Journal entity's journalId which is used to store it in a database.
	 * @param journalId Integer value.
	 */
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	
	/**
	 * Gets the value of gameName of a Journal entity
	 * @return gameName
	 */
	public String getGameName() {
		return gameName;
	}
	
	/**
	 * Sets the value of a Journal entity's gameName.
	 * @param gameName String value.
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	/**
	 * Gets the value of a Journal entity's journalName.
	 * @return journalName String value.
	 */
	public String getJournalName() {
		return journalName;
	}
	
	/**
	 * Sets the value of a Journal entity's journalName.
	 * @param journalName String value.
	 */
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	
	/**
	 * Gets the value of a Journal entity's entry.
	 * @return entry String value converted to TEXT field in database.
	 */
	public String getEntry() {
		return entry;
	}
	
	/**
	 * Sets the value of a Journal entity's entry.
	 * @param entry String value converted to TEXT field in database.
	 */
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "Journal{" +
				"journalId=" + journalId +
				", journalName='" + journalName + '\'' +
				", gameName='" + gameName + '\'' +
				", entry='" + entry + '\'' +
				'}';
	}
}