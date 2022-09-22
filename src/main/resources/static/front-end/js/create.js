"use strict"

const cardTitle = document.querySelector(".card-title");
const cardSubtitle = document.querySelector(".card-subtitle");
const cardText =document.querySelector(".card-text");

document.querySelector("#journal").addEventListener('submit', function(e) {
	e.preventDefault();
	
	const createBody = {
		journalName: this.journalName.value,
		gameName: this.gameName.value,
		entry: this.entry.value
	}
	
	axios.post("/journal/create", createBody)
		.then(res => {
			this.reset();
			this.journalName.focus();
			
			cardTitle.innerText = res.data.journalName;
			cardSubtitle.innerText = res.data.gameName;
			cardText.innerText = res.data.entry;
		})
		.catch(err => console.error(err));
});

document.querySelector("#journal").addEventListener('reset', function() {
	cardTitle.innerText = "";
	cardSubtitle.innerText = "";
	cardText.innerText = "";
	this.journalName.focus();
})