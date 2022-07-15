"use strict";

function getMyJournal(id) {
	axios.get("http://localhost:8080/journal/get-journal/" + id)
		.then(res => {
			console.log(res);
			const journalSection = document.querySelector("#journalDisplay");
			
			const journalDiv = document.createElement("div");
			journalDiv.id = "journalTitle";
			journalSection.appendChild(journalDiv);
			
			const journalTitle = document.createElement("h3");
			journalTitle.innerText = "Journal Name: ";
			journalDiv.appendChild(journalTitle);
			
			const journalTitleText = document.createElement("h3");
			journalTitleText.innerText = res.data.journalName;
			journalDiv.appendChild(journalTitleText);
			
			const journalSubtitle = document.createElement("h4");
			journalSubtitle.innerText = `Game Name: ${res.data.gameName}`;
			journalSection.appendChild(journalSubtitle);
			
			const journalEntry = document.createElement("p");
			journalEntry.innerText = res.data.entry;
			journalSection.appendChild(journalEntry);
			
			const saveButton = document.createElement("button");
			saveButton.classList.add("btn", "btn-secondary", "disabled");
			saveButton.innerText = "Save"
			journalSection.appendChild(saveButton);
			
		})
		.catch(err => console.error(err));
}

getMyJournal(sessionStorage.getItem("journalId"));

document.querySelector("#goBack").addEventListener("click", () => history.back());