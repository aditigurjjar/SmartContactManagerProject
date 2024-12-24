package com.scm.SmartContactManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




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


}
