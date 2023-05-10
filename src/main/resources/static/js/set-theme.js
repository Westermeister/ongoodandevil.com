/** This script sets the color theme for the website. */

const root = document.documentElement ?? document.querySelector("html");
const savedPreference = localStorage.getItem("theme");
const hasSavedPreference = savedPreference === "light-theme" || savedPreference === "dark-theme";

if (hasSavedPreference) {
	root.classList.add(savedPreference);
	root.setAttribute("data-bs-theme", savedPreference.split("-")[0]);
} else if (window.matchMedia && window.matchMedia("(prefers-color-scheme: light)").matches) {
	root.classList.add("light-theme");
	root.setAttribute("data-bs-theme", "light");
} else if (window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches) {
	root.classList.add("dark-theme");
	root.setAttribute("data-bs-theme", "dark");
} else {
	root.classList.add("light-theme");
	root.setAttribute("data-bs-theme", "light");
}

// Need to defer until page is loaded until we can access and set the navbar dropdown appropriately.
window.onload = function () {
	const navbarDropdown = document.querySelector("#navbar-theme-dropdown");
	if (hasSavedPreference) {
		navbarDropdown.value = savedPreference;
	}
};
