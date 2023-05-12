package com.ongoodandevil.blog;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest
public class BlogApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BlogHelper helper;

	@Test
	public void shouldReturnHomepage() throws Exception {
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("<title>On Good And Evil</title>")))
			// Check top of title.
			.andExpect(content().string(containsString("<span id=\"title-on\">On</span>")))
			// Check bottom of title.
			.andExpect(content().string(containsString("<span id=\"title-good-and-evil\">GOOD AND EVIL</span>")))
			// Check tagline.
			.andExpect(content().string(containsString("Essays about morality")));
	}

	@Test
	public void shouldHaveNavbar() throws Exception {
		this.mockMvc.perform(get("/"))
			// Check for navbar tag.
			.andExpect(content().string(containsString("<nav")))
			// Check for logo in navbar.
			.andExpect(content().string(containsString("<img id=\"navbar-logo\"")))
			// Check for blog name in navbar.
			.andExpect(content().string(containsString("ON GOOD AND EVIL")))
			// Check for hamburger menu button.
			.andExpect(content().string(containsString("<button")))
			// Check for home link.
			.andExpect(content().string(containsString("href=\"/\"")))
			.andExpect(content().string(containsString("Home")))
			// Check for color theme dropdown setting.
			.andExpect(content().string(containsString("Theme:")))
			.andExpect(content().string(containsString("Use device theme")))
			.andExpect(content().string(containsString("Light theme")))
			.andExpect(content().string(containsString("Dark theme")));
	}

	@Test
	public void shouldHaveFooter() throws Exception {
		this.mockMvc.perform(get("/"))
			// Check for footer tag.
			.andExpect(content().string(containsString("<footer")))
			// Check for copyright notice.
			.andExpect(content().string(containsString("Copyright ©")))
			.andExpect(content().string(containsString("Westermeister")));
	}
}
