/** Provides functions for the navigation bar. */

/** Toggle whether the navbar menu links are shown or not. */
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
