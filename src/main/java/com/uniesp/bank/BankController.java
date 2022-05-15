package com.uniesp.bank;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BankController {

    // Pagina de login GET    
    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }
    // Pagina de login POST
    @PostMapping("/login/submit")
    public ModelAndView setLoginPage(@RequestParam Map<String,String> body) {
        System.out.println(body);
        
        Object data = body.values().toArray()[0];
            

        System.out.println(data);
                
        return new ModelAndView("login");
    }

    // Pagina de cadastro GET
    @GetMapping("/cadastro")
    public ModelAndView getCadastro() {
        return new ModelAndView("cadastro");
    }
    // Pagina de cadastro POST
    @PostMapping("/cadastro")
    public ModelAndView setCadastro() {
        return new ModelAndView("cadastro");
    }


    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");          
    }
}
