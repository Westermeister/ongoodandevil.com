package com.ongoodandevil.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("templateEngineHelper", TemplateEngineHelper.getInstance());
		return "home";
	}

	@GetMapping("/blog/{id}")
	public String blog(Model model, @PathVariable String id) {
		model.addAttribute("templateEngineHelper", TemplateEngineHelper.getInstance());
		return String.format("blog/%s", id);
	}
}
