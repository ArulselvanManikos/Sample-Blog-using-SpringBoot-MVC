package com.sampleblogger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.sampleblogger.model.PostModelEntity;
import com.sampleblogger.repositary.PostRepositary;
import com.sampleblogger.service.PostService;



	
	
@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private PostRepositary postRepo;
	
	@GetMapping("/" )
	public String index(Model model)
	{
		 List<PostModelEntity> post =postService.getAllPost();		
			 model.addAttribute("posts", postRepo.findAll());		
		        return "index.html";

	}

	@GetMapping("/create" )
	public String create()
	{
		return "create.html";
	}
	 @PostMapping("/new")
	    public String createPost(@ModelAttribute PostModelEntity poste) {
		 PostModelEntity postdetails=postService.createPost(poste);
		 System.out.println(postdetails);
		 if (postdetails!=null) {
			 return "redirect:/" ;
		} else {
			return "redirect:/create" ;
		}
		 
			
	    }
	 @GetMapping("/editPost/{id}")
	 public String showUpdateForm(@PathVariable long id, Model model) {
	     PostModelEntity post = postService.getPostById(id);
	      
	     
	     model.addAttribute("posts", post);
	     return "edit.html";
	 }
	 

	 @PostMapping("/update/{id}")
	 public String updatePost(@ModelAttribute PostModelEntity poste, Model model) {
		 PostModelEntity post = postService.updatePost(poste);
	         
		 model.addAttribute("posts", post);
	     return "redirect:/";
	 }
	     
	 @GetMapping("/delete/{id}")
	 public String deleteUser(@PathVariable("id") long id) {
		 PostModelEntity post = postService.deletePost(id);
	       
		
	     return "redirect:/";
	 }

}
