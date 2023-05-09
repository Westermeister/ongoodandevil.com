package com.ongoodandevil.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller that maps incoming requests to the proper views i.e. templates.
 */
@Controller
public class BlogController {
	private BlogHelper helper;

	/**
	 * Inject dependencies.
	 *
	 * @param helper  spring bean for the helper class
	 */
	@Autowired
	public BlogController(BlogHelper helper) {
		this.helper = helper;
	}

	/**
	 * Serve the homepage.
	 *
	 * @param model  spring mvc model
	 * @return       name of homepage template
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("helper", helper);
		return "index";
	}

	/**
	 * Serve the blog posts.
	 *
	 * @param model  spring mvc model
	 * @param id     filename (without extension) of blog post e.g. "a-specific-blog-post"
	 * @return       path to specific blog post template e.g. "blog/a-specific-blog-post"
	 */
	@GetMapping("/blog/{id}")
	public String blog(Model model, @PathVariable String id) {
		model.addAttribute("helper", helper);
		return String.format("blog/%s", id);
	}
}
