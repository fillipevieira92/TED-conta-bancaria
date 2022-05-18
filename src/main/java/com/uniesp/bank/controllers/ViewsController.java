package com.uniesp.bank.controllers;


import java.util.ArrayList;
import java.util.Map;

import com.uniesp.bank.dto.BankAccountDTO;
import com.uniesp.bank.service.BankService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ModelAndView loginSubmit(@RequestParam Map<String, String> body) {
        
        ArrayList<BankAccountDTO> conta = bankService.auth(body);
        System.out.println("response auth:");
        System.out.println(conta);

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
        
        // Cadastrando no banco.
        bankService.openAccount(body);

        return getLoginPage();
    }
    

    @GetMapping("/logout")
    public ModelAndView logout() {
        return getLoginPage();
    }

    // Funcao que trás a pagina home, recebendo o usuario do login como parametro.
    public ModelAndView index(BankAccountDTO usuario) {

        ModelAndView modelAndView = new ModelAndView("index");
        
        // Adicionando os dados de usuario.
        modelAndView.addObject("usuario", usuario);
        System.out.println("index view:");                    
        System.out.println(usuario);
        return modelAndView;
    }

    // Função para depositar.
    @PostMapping("/deposit")
    public ResponseEntity<BankAccountDTO> setDeposito(@RequestBody Map<String, String> body) {
        // Depositando o valor.
        BankAccountDTO conta = bankService.deposit(body);

        return new ResponseEntity<BankAccountDTO>(conta, HttpStatus.OK);
    }
    
    
    // Função para sacar.
    @PostMapping("/whitdraw")
    public ResponseEntity<BankAccountDTO> setSaque(@RequestBody Map<String, String> body) {
        // Retirando o valor.
        BankAccountDTO conta = bankService.withdraw(body);

        return new ResponseEntity<BankAccountDTO>(conta, HttpStatus.OK);
    }

    // Função para transferir.
    @PostMapping("/transfer")
    public ResponseEntity<BankAccountDTO> setTransfer(@RequestBody Map<String, String> body) {
        // Retirando o valor.
        BankAccountDTO conta = bankService.transfer(body);

        return new ResponseEntity<BankAccountDTO>(conta, HttpStatus.OK);
    }
    /* 


    // Função ajax para achar o destinatario pelo cpf.

     */
}
