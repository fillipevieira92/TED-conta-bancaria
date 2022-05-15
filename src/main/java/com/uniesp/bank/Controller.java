package com.uniesp.bank;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }
    @RequestMapping("/cadastro")
    public ModelAndView cadastro() {
        return new ModelAndView("cadastro");
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
