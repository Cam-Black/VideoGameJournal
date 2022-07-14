"use strict";

const journals = document.querySelector("#journalOutput");

axios.get("http://localhost:8080/journal/list-journals")
	.then(res => {
		console.log("RES:", res)
		for (let journal of res.data) {
			const journalCard = document.createElement("div");
			journalCard.className = "card";
			
			const journalBod = document.createElement("div");
			journalBod.className = "card-body";
			journalCard.appendChild(journalBod);
			
			const journalTitle = document.createElement("h5");
			journalTitle.className = "card-title";
			journalTitle.innerText = journal.journalName;
			journalBod.appendChild(journalTitle);
			
			const journalSubTitle = document.createElement("h6");
			journalSubTitle.className = "card-subtitle";
			journalSubTitle.innerText = journal.gameName;
			journalBod.appendChild(journalSubTitle);
			
			const journalText = document.createElement("p");
			journalText.className = "card-text";
			let entry = journal.entry;
			const arr = entry.split(". ");
			journalText.innerText = arr[0] + ".";
			journalBod.appendChild(journalText);
			
			const journalView = document.createElement("button");
			journalView.classList.add("btn", "btn-primary");
			journalView.innerText = "View";
			journalView.addEventListener('click', () => {
				window.location.href = "../html/journal.html";
			})
			journalBod.appendChild(journalView);
			
			const journalDelete = document.createElement("button");
			journalDelete.classList.add("btn", "btn-danger");
			journalDelete.innerText = "Delete";
			journalDelete.addEventListener('click', () => deleteJournal(journal.id));
			journals.appendChild(journalCard);
		}
	})
	.catch(err => console.error(err));

const deleteJournal = id => {}
