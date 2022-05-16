package com.uniesp.bank;


import java.util.Map;

import com.uniesp.bank.objects.AccountsController;
import com.uniesp.bank.objects.BankAccounts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BankController {

    private AccountsController controle;
    
    // Pagina de login GET    
    @GetMapping("/")
    public ModelAndView getLoginPage() {

        return new ModelAndView("login");
    }
    // Pagina de login POST
    @PostMapping("/login/submit")
    public ModelAndView setLoginPage(@RequestParam Map<String, String> body) {
        
        boolean logged = false;

        String cpf = body.get("cpf");
        String senha = body.get("senha");

        logged = controle.autenticar(cpf, senha);

        if (logged) {
            return index(controle.getAccountByCPF(cpf));
        } else {
            return getLoginPage();
        }
    }

    // Pagina de cadastro GET
    @GetMapping("/cadastro")
    public ModelAndView getCadastro() {
        return new ModelAndView("cadastro");
    }
    // Pagina de cadastro POST
    @PostMapping("/cadastro/submit")
    public ModelAndView setCadastro(@RequestParam Map<String, String> body) {       

        String nome = body.get("nome").toUpperCase();
        String cpf = body.get("cpf");
        String senha = body.get("senha");   
        
        controle.cadastrar(nome, cpf, senha);

        return getLoginPage();
    }

    public ModelAndView index(BankAccounts usuario) {

        ModelAndView modelAndview = new ModelAndView("index");
        modelAndview.addObject("usuario", usuario);
        modelAndview.addObject("destinatarioConta", "");
        modelAndview.addObject("destinatarioNome", "");

        return modelAndview;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return getLoginPage();
    }
}
