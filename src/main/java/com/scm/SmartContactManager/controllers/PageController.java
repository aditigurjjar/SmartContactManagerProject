package com.scm.SmartContactManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.SmartContactManager.forms.UserForm;






@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page");
        model.addAttribute("name", "Aditi Gurjar");
        model.addAttribute("email", "gurjar@gmail.com");
        model.addAttribute("github", "https://github.com/aditigurjjar");
       return "home";
    }

    //about route
    @RequestMapping("/about")  
   public String aboutPage()
   {
    System.out.println("About Page");
    return "about";
   }
    

    //services
    @RequestMapping("/services")  
    public String servicesPage()
    {
     System.out.println("Services Page");
     return "services";
    }

    //contact page
    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    

    //login
    @GetMapping("login")
    public String login() {
        return new String("login");
    }
    
    //register
    @GetMapping("register")
    public String register(Model model) {
        UserForm userForm=new UserForm();
        model.addAttribute("userForm", userForm);
        return new String("register");
    }

    //prosessing register
    @RequestMapping(value="/do-register",method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm)
    {
        System.out.println("processing register");
        //fetch the form data

        //validate form data
        //save to db
        //messgae="Registration Successful"
        //redirect to login page
        return "redirect:/register";

    }
    
}
