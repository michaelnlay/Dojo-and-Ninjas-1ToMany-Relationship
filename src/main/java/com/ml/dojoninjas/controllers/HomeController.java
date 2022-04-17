package com.ml.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ml.dojoninjas.models.Dojo;
import com.ml.dojoninjas.models.Ninja;
import com.ml.dojoninjas.services.DojoService;
import com.ml.dojoninjas.services.NinjaService;



@Controller
public class HomeController {
	
	//Attributes=========================================================================
	//injecting Services to Controller
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;
	
//	Contructors=================================================
	
	public HomeController(NinjaService ninjaServ, DojoService dojoServ) {

		super();
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	

	//ROUTE to show all ninjas
	//Needs: Model model, 
	
	
	  @GetMapping("/dashboard") 
	  public String dashboard( Model model) {
	  
	 //Send our Ninjas to the JSP using Model model
		  model.addAttribute("allNinjas", ninjaServ.allNinjas()); 
		  return "dashboard.jsp"; 
		  
	  }

	//ROUTE to make a Ninja====================================================================
	
	
	//RENDER the new ninja Form==========================================================
	@GetMapping("/newNinja")
	public String newNinjaForm(
			@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		
		model.addAttribute("allDojos", dojoServ.allDojos());
		return "newNinja.jsp";
	}
	
	//Route to Render Dojo form=======================================================
	@GetMapping("/newDojo")
	public String newDojoForm(
			@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	
	//PROCESS the POST to create Ninja===================================================
	@PostMapping("/processNinja")
	public String postingNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja, 
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDojos",dojoServ.allDojos()); 
			//Without having Model model, all dojos on the select option will be disappear after submit
			
			return "newNinja.jsp";
			
		}else {
			ninjaServ.createNinja(ninja);
			return "redirect:/dashboard";
		}
		
		
	}
	//PROCESS the POST to create Dojo===================================================
		@PostMapping("/processDojo")
		public String postingDojo(
				@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
			if (result.hasErrors()) {
				return "newDojo.jsp";
			}else {
				dojoServ.createDojo(dojo);
				return "redirect:/dashboard";
			}
			
			
		}
	
	
	//ROUTE to show one Ninja
	@GetMapping("/oneNinja/{id}")
	public String oneNinja(Model model,
			@PathVariable(value="id") Long id) {
		Ninja ninja = ninjaServ.findNinja(id);
		model.addAttribute("ninja", ninja);
		return "oneNinja.jsp";
	}
	
	//ROUTE to show one Dojo with many Ninjas
	@GetMapping("/oneDojo/{id}")
	public String oneDojo(Model model,
			@PathVariable(value="id") Long id) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		System.out.println(dojo);
		
		return "oneDojo.jsp";
		}
	
	
	
	//Route to Delete a Ninja
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable(value="id") Long id) {
		ninjaServ.deleteNinja(id);
		return "redirect:/dashboard";
	}
	

	
	//====================================UPDATE=============================
	//ROUTES to Update a Ninja
	
	//Render the update Ninja Form
	//Don't forget to add id
	@GetMapping("/updateNinja/{id}")
	public String updateNinjaForm(@PathVariable("id") Long id, @ModelAttribute("ninja") Ninja ninja, Model model) {
		
		model.addAttribute("ninja", ninjaServ.findNinja(id));
		
		return "updateNinja.jsp";
	}
	
	//Process the Post to Update Ninja
	@RequestMapping(value="/updatingNinja/{id}", method=RequestMethod.PUT)
	public String updatingNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "updateNinja.jsp";
		}else {
			ninjaServ.updateNinja(ninja);
			return "redirect:/dashboard";
			
		}
	}
    
  
    
 
}
	
	
	
	
	
	
	
	
	

