package com.scm.SmartContactManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.SmartContactManager.entities.User;
import com.scm.SmartContactManager.forms.UserForm;
import com.scm.SmartContactManager.helper.Message;
import com.scm.SmartContactManager.helper.MessageType;
import com.scm.SmartContactManager.services.UserServices;

import jakarta.servlet.http.HttpSession;






@Controller
public class PageController {

    @Autowired
    private UserServices userServices;

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
    public String processRegister(@ModelAttribute UserForm userForm,HttpSession session)
    {
        System.out.println("processing register");
        //fetch the form data

        //validate form data
        //save to db
        //userservice
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

       
         User savedUser=userServices.saveUser(user);
         System.out.println("user saved");

        //messgae="Registration Successful"
        
        //add message
        Message message=Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);
        //redirect to login page
        return "redirect:/register";

    }
    
}
