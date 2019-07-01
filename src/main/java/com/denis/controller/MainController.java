package com.denis.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.denis.entity.Recipe;
import com.denis.entity.User;
import com.denis.repository.RecipeRepository;

@Controller
public class MainController {

	@Autowired
	private RecipeRepository recipeRepo;
	
	@Value("${upload.path}")
	private String uploadPath;

	@GetMapping("/")
	public String greeting(Map<String, Object> map) {

		return "greeting";
	}

	@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue = "") String filter, Model map) {

		Iterable<Recipe> recipes = recipeRepo.findAll();

		if (filter != null && !filter.isEmpty()) {
			recipes = recipeRepo.findByTag(filter);
		} else {
			recipes = recipeRepo.findAll();
		}
		map.addAttribute("recipes", recipes);
		map.addAttribute("filter", filter);
		return "main";
	}

	@PostMapping("/main")
	public String addRecipe(
			@AuthenticationPrincipal User user, 
			@RequestParam String text, 
			@RequestParam String tag,
			@RequestParam("file") MultipartFile file,
			Map<String, Object> map) throws IllegalStateException, IOException {

		Recipe recipe = new Recipe(text, tag, user);
		if (file != null && !file.getOriginalFilename().isEmpty()) {
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			String uuidFile = UUID.randomUUID().toString();
			String resFileName = uuidFile + "." + file.getOriginalFilename();			
			file.transferTo(new File(uploadPath + "/" + resFileName));
			
			recipe.setFilename(resFileName);
		}
		recipeRepo.save(recipe);
		return "redirect:/main";
	}

//	@PostMapping("filter")
//	public String searchRec(@RequestParam String tag, Map<String, Object> map) {
//		if (tag != "") {
//			map.put("recipes", recipeRepo.findByTag(tag));
//		} else {
//			return "redirect:/main";
//		}
//		return "main";
//	}

}
