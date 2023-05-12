# 2023.05.11.1

- Added custom 404 error page.
- Added XML sitemap for all existing pages + corresponding `robots.txt` that links to the sitemap.
- Added tests.
- Changed name of light / dark theme setting from "Color theme" to just "Theme".

# 2023.05.11

- Now using PNG favicon instead of SVG favicon.

# 2023.05.10

- Migrated Gradle build files from Groovy DSL to Kotlin DSL.

# 2023.05.09.1

- Fixed a bug where the color-theme dropdown setting lags behind the rest of the page when switching themes.
	- Specifically, the dropdown border color had a short transition before changing colors due to the default Bootstrap styling.

# 2023.05.09

- Refactored backend and added Javadoc comments.
- Added language metadata i.e. `lang="en-US"` for post `Sensation Precedes Thought`.
- Now using Bootstrap for the color theme dropdown in the navbar.
- Now using Bootstrap Reboot instead of Normalize; refactored stylesheets accordingly.
- Made essay titles slightly smaller on mobile.
- Added a border around the essay list-items on the homepage.
- Other minor refactors.

# 2023.05.07.3

- Fixed incorrect publish date on homepage for post `Sensation Precedes Thought`.
- Added missing version tags with `git tag`.

# 2023.05.07.2

- Slightly increased spacing between title and navigation bar on homepage.
- Refactored `index.css` stylesheet to use more `rem` units instead of `px` units.

# 2023.05.07.1

- Added `www` to canonical URLs for all existing pages.

# 2023.05.07

- Initial release with one blog post: `Sensation Precedes Thought`
