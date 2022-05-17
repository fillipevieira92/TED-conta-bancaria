package com.uniesp.bank.controllers;


import java.util.ArrayList;
import java.util.Map;

import com.uniesp.bank.model.BankAccount;
import com.uniesp.bank.service.Auth;
import com.uniesp.bank.service.BankService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class ViewsController {

    BankService bankService;

    // Pagina de login GET    
    @GetMapping("/")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    // Login submit.
    @PostMapping("/")
    public ModelAndView setLoginPage(@RequestParam Map<String, String> body) {
        // Pegando os dados do form.
        String cpf = body.get("cpf");
        String senha = body.get("senha");

        ArrayList<BankAccount> conta = bankService.auth(cpf, senha);
        if (!conta.isEmpty()) {

            return index(conta.get(0));

        } else {

            return getLoginPage();

        }
    }

    // Pagina de cadastro
    @GetMapping("/signup")
    public ModelAndView getCadastro() {
        return new ModelAndView("cadastro");
    }

    // Responsável por efetuar o cadastro do usuário.
    @PostMapping("/signup")
    public ModelAndView setCadastro(@RequestParam Map<String, String> body) {       

        // Pegando os dados do form.
        String nome = body.get("nome").toUpperCase();
        String cpf = body.get("cpf");
        String senha = body.get("senha");   
        
        // Cadastrando no banco.
        bankService.createAccount(nome, cpf, senha);

        return getLoginPage();
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return getLoginPage();
    }

    // Funcao que trás a pagina home, recebendo o usuario do login como parametro.
    public ModelAndView index(BankAccount usuario) {

        ModelAndView modelAndView = new ModelAndView("index");
        
        // Adicionando os dados de usuario.
        modelAndView.addObject("usuario", usuario)
                    .addObject("destinatarioConta", "")
                    .addObject("destinatarioNome", "");
        
        return modelAndView;
    }

    // Função para depositar.
    @PostMapping("/deposit")
    public ModelAndView setDeposito(@RequestParam Map<String, String> body) {

        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println(body.get("valorDeposito"));
        // Recebendo os dados do form deposito.
        String cpf = body.get("cpfDeposito");
        double valor = Double.parseDouble(body.get("valorDeposito").replaceAll("[\", ]", ""));
        
        // Depositando.
        BankAccount conta = accountsController.depositar(cpf, valor);
        
        modelAndView.addObject("usuario", conta);

        return modelAndView;
    }
    
    
    // Função para sacar.
    @PostMapping("/whitdraw")
    public ModelAndView setSaque(@RequestParam Map<String, String> body) {

        ModelAndView modelAndView = new ModelAndView("index");

        // Recebendo os dados do form deposito.
        String cpf = body.get("cpfSaque");
        double valor = Double.parseDouble(body.get("valorSaque").replaceAll("[\"R$ ]", ""));
        
        // Depositando.
        BankAccount conta = accountsController.sacar(cpf, valor);
        
        modelAndView.addObject("usuario", conta);

        return modelAndView;
    }
    // Função para transferir.
    // Função ajax para achar o destinatario pelo cpf.

    
}
