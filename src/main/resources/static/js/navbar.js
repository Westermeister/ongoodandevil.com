/** This file provides functions for the navigation bar. */

/**
 * "onclick" handler function that's called when the menu icon is clicked.
 * Toggles whether to show the menu items or not.
 * Also sets the menu icon to be an "X" icon or a hamburger icon, depending on the current state.
 */
function toggleMenuItems() {
	const items = document.querySelector("#navbar-menu-items");
	const icon = document.querySelector("#navbar-menu-icon");

	// Initial "style" is empty string because we set "display: none" in stylesheet, NOT inline CSS.
	// Therefore we only check if display is "block" (i.e. visible) and default to always setting it to "block" if it isn't already.
	if (items.style.display === "block") {
		items.style.display = "none";
		icon.classList.remove("bi-x-lg");
		icon.classList.add("bi-list");
	} else {
		items.style.display = "block";
		icon.classList.remove("bi-list");
		icon.classList.add("bi-x-lg");
	}
};

/**
 * Sets preferred theme and saves preference.
 *
 * @param {String} theme - Either "light-theme" or "dark-theme" or "device-theme".
 */
function setPreferredTheme(theme) {
	const root = document.documentElement;
	if (theme === "device-theme") {
		// Remove saved preference (if any) and fallback to OS preference; failing that, just use light theme.
		localStorage.removeItem("theme");
		if (window.matchMedia && window.matchMedia("(prefers-color-scheme: light)").matches) {
			root.classList.remove("dark-theme");
			root.classList.add("light-theme");
		} else if (window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches) {
			root.classList.remove("light-theme");
			root.classList.add("dark-theme");
		} else {
			root.classList.remove("dark-theme");
			root.classList.add("light-theme");
		}
	} else if (theme === "light-theme") {
		// Set theme and save preference.
		root.classList.remove("dark-theme");
		root.classList.add(theme);
		localStorage.setItem("theme", theme);
	} else if (theme === "dark-theme") {
		// Set theme and save preference.
		root.classList.remove("light-theme");
		root.classList.add(theme);
		localStorage.setItem("theme", theme);
	} else {
		throw new Error(`Unrecognized theme: ${theme}`);
	}
}
