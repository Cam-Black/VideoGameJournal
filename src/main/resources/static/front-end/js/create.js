"use strict"

const output = document.querySelector("#journalOutput");

document.querySelector("#journal").addEventListener('submit', function(e) {
	e.preventDefault();
	
	const data = {
		journalName: this.journalName.value,
		gameName: this.gameName.value,
		entry: this.entry.value
	}
	
	axios.post("http://localhost:8080/journal/create", data)
		.then(res => {
			this.reset();
			this.journalName.focus();
			
			const journalCard = document.createElement("div");
			journalCard.className = "card";
			
			const journalBod = document.createElement("div");
			journalBod.className = "card-body";
			journalCard.appendChild(journalBod);
			
			const journalTitle = document.createElement("h5");
			journalTitle.className = "card-title";
			journalTitle.innerText = res.data.journalName;
			journalBod.appendChild(journalTitle);
			
			const journalSubTitle = document.createElement("h6");
			journalSubTitle.className = "card-subtitle";
			journalSubTitle.innerText = res.data.gameName;
			journalBod.appendChild(journalSubTitle);
			
			const journalText = document.createElement("p");
			journalText.className = "card-text";
			journalText.innerText = res.data.entry;
			journalBod.appendChild(journalText);
			
			output.appendChild(journalCard);
			
		})
		.catch(err => console.error(err));
});

document.querySelector("#journal").addEventListener('reset', function() {
	output.innerHTML = "";
	this.journalName.focus();
})