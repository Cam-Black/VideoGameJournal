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
			
			const journalTitleText = document.createElement("span");
			journalTitleText.innerText = res.data.journalName;
			journalTitleText.setAttribute("contenteditable", "true");
			journalTitle.appendChild(journalTitleText);
			
			const journalSubtitle = document.createElement("h4");
			journalSubtitle.innerText = "Game Name: ";
			journalSection.appendChild(journalSubtitle);
			
			const journalSubText = document.createElement("span");
			journalSubText.innerText = res.data.gameName;
			journalSubText.setAttribute("contenteditable", "true");
			journalSubtitle.appendChild(journalSubText);
			
			const journalEntry = document.createElement("p");
			journalEntry.innerText = res.data.entry;
			journalEntry.setAttribute("contenteditable", "true");
			journalSection.appendChild(journalEntry);
			
			const saveButton = document.createElement("button");
			saveButton.classList.add("btn", "btn-secondary", "disabled");
			saveButton.innerText = "Save"
			journalSection.appendChild(saveButton);
			
		})
		.catch(err => console.error(err));
}

getMyJournal(sessionStorage.getItem("journalId"));

function goBack() {
	window.location.href = "../html/view.html";
}

async function deleteJournal(id) {
	await axios.delete("http://localhost:8080/journal/delete/" + id);
}

document.querySelector("#deleteJournal").addEventListener("click", async function() {
	await deleteJournal(sessionStorage.getItem("journalId"));
	goBack();
})
document.querySelector("#goBack").addEventListener("click", () => goBack());