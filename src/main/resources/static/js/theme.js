/** This script checks the user's preferred theme BEFORE page is rendered. */

const root = document.documentElement;
const savedPreference = localStorage.getItem("theme");

// If user has previously visited site and has explicitly indicated a preference, use that.
// Otherwise, try getting OS preference; failing that, just use light theme.
if (savedPreference === "light-theme" || savedPreference === "dark-theme") {
	root.classList.add(savedPreference);
} else if (window.matchMedia && window.matchMedia("(prefers-color-scheme: light)").matches) {
	root.classList.add("light-theme");
} else if (window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches) {
	root.classList.add("dark-theme");
} else {
	root.classList.add("light-theme");
}
