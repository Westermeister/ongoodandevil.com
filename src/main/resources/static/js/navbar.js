/** This file provides functions for the navigation bar. */

/**
 * "onclick" handler function that's called when the menu icon is clicked.
 * Toggles whether to show the menu links or not.
 * Also sets the menu icon to be an "X" icon or a hamburger icon, depending on the current state.
 */
function toggleMenuLinks() {
	const links = document.querySelector("#navbar-menu-links");
	const icon = document.querySelector("#navbar-menu-icon");

	// Initial "style" is empty string because we set "display: none" in stylesheet, NOT inline CSS.
	// Therefore we only check if display is "block" (i.e. visible) and default to always setting it to "block" if it isn't already.
	if (links.style.display === "block") {
		links.style.display = "none";
		icon.classList.remove("bi-x-lg");
		icon.classList.add("bi-list");
	} else {
		links.style.display = "block";
		icon.classList.remove("bi-list");
		icon.classList.add("bi-x-lg");
	}
};
