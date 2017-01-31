package pt.adrz.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {
 
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC!!");
        return "welcome";
    }
 
    @RequestMapping(value="/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value="/first", method = RequestMethod.GET)
    public String first(ModelMap model) {
        return "first";
    }

    @RequestMapping(value="/secound", method = RequestMethod.GET)
    public String secound(ModelMap model) {
        return "first";
    }
}