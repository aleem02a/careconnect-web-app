import { savePatient, saveVolunteer } from "./firebase.js";

/* PATIENT FORM */
document.getElementById("supportForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const issue = issueText = document.getElementById("issue").value.toLowerCase();

  let category = "General Health";
  let urgency = "Low";
  let response = "Our volunteer will contact you shortly.";

  if (issue.includes("fever")) {
    category = "Common Illness";
    urgency = "Medium";
  }
  if (issue.includes("pain") || issue.includes("injury")) {
    category = "Physical Injury";
    urgency = "High";
  }
  if (issue.includes("breathing") || issue.includes("emergency")) {
    category = "Emergency";
    urgency = "Critical";
    response = "Please seek immediate medical help.";
  }

  await savePatient({
    name: name.value,
    age: age.value,
    issue,
    category,
    urgency,
    time: new Date()
  });

  category.innerText = category;
  urgency.innerText = urgency;
  response.innerText = response;
  result.classList.remove("hidden");
});

/* VOLUNTEER FORM */
document.getElementById("volunteerForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  await saveVolunteer({
    name: vname.value,
    email: vemail.value,
    skills: vskills.value,
    joined: new Date()
  });

  alert("Volunteer registered successfully!");
  e.target.reset();
});

/* CHATBOT */
window.sendMessage = function () {
  const input = userInput.value.toLowerCase();
  chat.innerHTML += `<p><b>You:</b> ${input}</p>`;

  let reply = "Our volunteers will assist you soon.";

  if (input.includes("fever")) reply = "Fever usually requires rest and hydration.";
  if (input.includes("emergency")) reply = "Please visit the nearest hospital immediately.";
  if (input.includes("covid")) reply = "If symptoms persist, consult a doctor.";

  chat.innerHTML += `<p><b>Bot:</b> ${reply}</p>`;
  userInput.value = "";
};
