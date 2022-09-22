"use strict";

const journals = document.querySelector("#journalOutput");

async function deleteJournal(id) {
	await axios.delete("/journal/delete/" + id);
}

function renderJournals() {
	axios.get("/journal/list-journals")
		.then(res => {
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
				
				if (entry.length < 60 && entry.includes(".")) {
					journalText.innerText = entry;
				}
				else if (entry.length < 60 && !entry.includes(".")) {
					journalText.innerText = entry + ".";
				}
				else {
					journalText.innerText = entry.substring(0, 60) + "\u2026";
				}
				
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
				journalDelete.setAttribute("data-bs-toggle", "modal");
				journalDelete.setAttribute("data-bs-target", "#deleteModal");
				journalDelete.addEventListener("click", () => sessionStorage.setItem("journalId", journal.journalId));
				document.querySelector("#deleteJournal").addEventListener("click", async function () {
					await deleteAJournal();
				});
				journalBtnDiv.appendChild(journalDelete);
				journals.prepend(journalCol);
			}
		})
		.catch(err => console.error(err));
}

async function deleteAJournal() {
	await deleteJournal(sessionStorage.getItem("journalId"));
	window.location.reload();
}

window.addEventListener("load", renderJournals)