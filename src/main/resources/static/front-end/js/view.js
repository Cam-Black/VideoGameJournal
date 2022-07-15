"use strict";

const journals = document.querySelector("#journalOutput");

async function deleteJournal(id) {
	await axios.delete("http://localhost:8080/journal/delete/" + id);
}

function renderJournals() {
	axios.get("http://localhost:8080/journal/list-journals")
		.then(res => {
			console.log("RES:", res);
			for (let journal of res.data) {
				const journalCol = document.createElement("div");
				journalCol.className = "col";
				
				const journalCard = document.createElement("div");
				journalCard.className = "card";
				journalCol.appendChild(journalCard);
				
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
				
				const journalBtnDiv = document.createElement("div");
				journalBtnDiv.classList.add("d-grid", "gap-2", "d-block");
				journalBod.appendChild(journalBtnDiv);
				
				const journalView = document.createElement("button");
				journalView.classList.add("btn", "btn-primary");
				journalView.innerText = "View";
				journalView.addEventListener('click', async function (e) {
					sessionStorage.setItem("journalId", journal.journalId);
					window.location.href = "../html/journal.html";
				})
				journalBtnDiv.appendChild(journalView);
				
				const journalDelete = document.createElement("button");
				journalDelete.classList.add("btn", "btn-danger", "gap-2");
				journalDelete.innerText = "Delete";
				journalDelete.addEventListener('click', async function (e) {
					deleteJournal(journal.journalId);
					e.target.parentElement.parentElement.remove();
				});
				journalBtnDiv.appendChild(journalDelete);
				
				journals.appendChild(journalCol);
			}
		})
		.catch(err => console.error(err));
}

window.location.href.endsWith("html/view.html") ? renderJournals() : 0;