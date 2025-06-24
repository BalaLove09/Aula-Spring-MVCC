package br.csi.aula.controller;

import br.csi.aula.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    @GetMapping
    public String index() {
        return "index";
    }


    @PostMapping("/login")
    public String login(Model model, String email, String senha) {
        System.out.println("Realizando login do usuario \n" +email);

        if(new LoginService().autenticar(email, senha)) {
            return "redirect:/dashboard";
        }
        else{
            model.addAttribute("msg", "Login ou senha Incorreto!");
            return "redirect:/index";
        }
    }


  @GetMapping("/dashboard")
  public String dashboard() {
        return "pages/dashboard";
  }

}
