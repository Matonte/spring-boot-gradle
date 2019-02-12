package com.javainuse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.javainuse.BankAccountApplication;
import com.javainuse.User;
import com.javainuse.UserDAO;
import com.javainuse.UserForm;

@Controller
public class MainController {
	@Autowired
    UserDAO userDAO;
	

	@GetMapping("/")
	public ModelAndView viewHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;

	
	} 
		 
	
	@RequestMapping("/users")
	public String viewUsers(Model model) {
		List<User> list = UserDAO.getUsers();
		
		model.addAttribute("users", list);
		
		return "usersPage";
	}
	
	@RequestMapping("/registerSuccessful")
	public String viewRegisterSuccessful() {
		return "registerSuccessfulPage";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegister(Model model) {
		UserForm form = new UserForm();

	    model.addAttribute("userForm", form);
	    
	    return "registerPage";
	}
	
	public String saveRegister( Model model, //
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