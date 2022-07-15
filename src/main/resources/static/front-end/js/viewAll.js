"use strict";

function getMyJournal(id) {
	axios.get("http://localhost:8080/journal/get-journal/" + id)
		.then(res => {
			console.log(res);

			const journalName = document.querySelector("#journalName");
			journalName.value = res.data.journalName;
			
			const gameName = document.querySelector("#gameName");
			gameName.value = res.data.gameName;
			
			const journalEntry = document.querySelector("#entry");
			journalEntry.innerText = res.data.entry;
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

document.querySelector("#deleteJournal").addEventListener("click", async function () {
	await deleteJournal(sessionStorage.getItem("journalId"));
	goBack();
});

document.querySelector("#goBack").addEventListener("click", () => goBack());

document.querySelector("#journal").addEventListener('input', enableSaveButton);

function enableSaveButton() {
	const saveButton = document.querySelector("#saveJournal")
	saveButton.classList.remove("btn", "btn-outline-secondary", "disabled");
	saveButton.classList.add("btn", "btn-secondary");
}