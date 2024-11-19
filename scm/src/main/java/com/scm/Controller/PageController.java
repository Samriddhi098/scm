package com.scm.Controller;

// import org.hibernate.validator.internal.util.stereotypes.Lazy;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.form.UserForm;
import com.scm.helper.msg;
import com.scm.helper.msgtype;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class PageController {

    // @Autowired
    private UserService userService;



    @RequestMapping("/home")

public String home(Model model){
    System.out.println("home page handler");
    model.addAttribute("name","Samriddhi");
    model.addAttribute("YouTubeChannel","samriddhi");
return "home";
}
//about route
@RequestMapping("/about")
public String aboutPage() {
    System.out.println("about page load");
    return "about";
}
@RequestMapping("/services")
public String servicesPage() {
    System.out.println("services page load");
    return "services";
//service route
}
//contact page
@GetMapping("/contact")
public String contact() {
    return new String("contact");
}
@GetMapping("/login")
public String login() {
    return new String("login");
}
@GetMapping("/register")
public String register(Model model) {
   UserForm userform= new UserForm();
   userform.setName("bearrrr");
    model.addAttribute("userform", userform);
    return "register";
}
//processing register
@RequestMapping(value="/do-register", method = RequestMethod.POST)
public String processRegister(@Valid @ModelAttribute("userform") UserForm userform,BindingResult rBindingResult ,HttpSession session){
    System.out.println("Processing Register");
    //fetch form data
     //userform
     System.out.println(userform);
    //validate form data
    if(rBindingResult.hasErrors()){
        return "register";
    }
    //todo next video
    //save to database

    //UserForm --> User
// User user=User.builder()
// .name(userform.getName())
// .email(userform.getEmail())
// .password(userform.getPassword())
// .about(userform.getAbout())
// .phonenumber(userform.getPhonenumber())


// .build();
User user=new User();
user.setName(userform.getName());
user.setEmail(userform.getEmail());
user.setPassword(userform.getPassword());
user.setAbout(userform.getAbout());
user.setPhonenumber(userform.getPhonenumber());

User saveduser=userService.saveuser(user);

System.out.println("user saved:");
    //userservice

    //message ="registration successful"
    //add the msg
    msg m=msg.builder().content("Registration Successful").type(msgtype.green).build();
session.setAttribute("msg",m);
    //redirect login page
    return "redirect:/register";
}
}
