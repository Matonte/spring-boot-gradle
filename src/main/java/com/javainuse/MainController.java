package com.javainuse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.capgemini.spring.service.BankAccountApplication;
//import com.capgemini.spring.service.User;
//import com.capgemini.spring.service.UserDAO;
//import com.capgemini.spring.service.UserForm;


public class MainController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		return "welcomeHome";
	}
	
	@RequestMapping("/users")
	public String viewUsers(Model model) {
		List<User> list = UserDAO.getUsers();
		
		model.addAttribute("users", list);
		
		return "usersPage";
	}
	
	@RequestMapping("/registerSuccessful")
	public String viewRegisterSuccessful(Model model) {
		return "registerSuccessfulPage";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegister(Model model) {
		UserForm form = new UserForm();

	    model.addAttribute("userForm", form);
	    
	    return "registerPage";
	}
	
	public String saveRegister(Model model, //
	         @ModelAttribute("userForm") @Validated UserForm userForm, //
	         BindingResult result, //
	         final RedirectAttributes redirectAttributes) {
	 
	      // Validate result
	      if (result.hasErrors()) {
	         return "registerPage";
	      }
	      User newUser= null;
	      try {
	         newUser = userDAO.createUser(userForm);
	      }
	      // Other error!!
	      catch (Exception e) {
	         model.addAttribute("errorMessage", "Error: " + e.getMessage());
	         return "registerPage";
	      }
	 
	      redirectAttributes.addFlashAttribute("newUser", newUser);
	       
	      return "redirect:/registerSuccessful";
	   }
}