package com.ml.fullcrud.controllers;

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

import com.ml.fullcrud.models.Candy;
import com.ml.fullcrud.models.Owner;
import com.ml.fullcrud.services.CandyService;
import com.ml.fullcrud.services.OwnerService;

//no longer want RestController for RawData

//@RestController
//we want a controller to render jsp

@Controller
public class HomeController {
	
	//injecting Services to Controller
	private final CandyService candyServ;
	private final OwnerService ownerServ;
	
	public HomeController(CandyService candyServ, OwnerService ownerServ) {
		super();
		this.candyServ = candyServ;
		this.ownerServ= ownerServ;
	}
	
		
    
	//ROUTE to show all candies
	//Needs: Model model, 

	@GetMapping("/dashboard")
	public String dashboard(
			Model model) {
		
		//Send our Candies to the JSP using Model model
		model.addAttribute("allCands", candyServ.allCandys());
		return "dashboard.jsp";
	}
	
	//ROUTE to make a Candy====================================================================
	
	
	//RENDER the new candy Form==========================================================
	@GetMapping("/newCandy")
	public String newCandyForm(
			@ModelAttribute("candy") Candy candy,
			Model model) {
		
		model.addAttribute("allOwners", ownerServ.allOwners());
		return "newCandy.jsp";
	}
	
	//Route to Render Owner form=======================================================
	@GetMapping("/newOwner")
	public String newOwnerForm(
			@ModelAttribute("owner") Owner owner) {
		return "newOwner.jsp";
	}
	
	
	//PROCESS the POST to create Candy===================================================
	@PostMapping("/processCandy")
	public String postingCandy(
			@Valid @ModelAttribute("candy") Candy candy, 
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allOwners",ownerServ.allOwners()); 
			//Without having Model model, all owners on the select option will be disappear after submit
			
			return "newCandy.jsp";
			
		}else {
			candyServ.createCandy(candy);
			return "redirect:/dashboard";
		}
		
		
	}
	//PROCESS the POST to create Owner===================================================
		@PostMapping("/processOwner")
		public String postingOwner(
				@Valid @ModelAttribute("owner") Owner owner, BindingResult result) {
			if (result.hasErrors()) {
				return "newOwner.jsp";
			}else {
				ownerServ.createOwner(owner);
				return "redirect:/dashboard";
			}
			
			
		}
	
	
	//ROUTE to show one Candy
	@GetMapping("/oneCandy/{id}")
	public String oneCandy(Model model,
			@PathVariable(value="id") Long id) {
		Candy candy = candyServ.findCandy(id);
		model.addAttribute("candy", candy);
		return "oneCandy.jsp";
	}
	
	//Route to Delete a Candy
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable(value="id") Long id) {
		candyServ.candyMan(id);
		return "redirect:/dashboard";
	}
	

	
	//====================================UPDATE=============================
	//ROUTES to Update a Candy
	
	//Render the update Candy Form
	//Don't forget to add id
	@GetMapping("/updateCandy/{id}")
	public String updateCandyForm(@PathVariable("id") Long id, @ModelAttribute("candy") Candy candy, Model model) {
		
		model.addAttribute("candy", candyServ.findCandy(id));
		
		return "updateCandy.jsp";
	}
	
	//Process the Post to Update Candy
	@RequestMapping(value="/updatingCandy/{id}", method=RequestMethod.PUT)
	public String updatingCandy(@Valid @ModelAttribute("candy") Candy candy, BindingResult result) {
		if(result.hasErrors()) {
			return "updateCandy.jsp";
		}else {
			candyServ.updateCandy(candy);
			return "redirect:/dashboard";
			
		}
	}
    
  
    
 
}
	
	
	
	
	
	
	
	
	

