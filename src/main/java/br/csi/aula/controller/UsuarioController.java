package br.csi.aula.controller;


import br.csi.aula.model.Usuario;
import br.csi.aula.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", new UsuarioService().listar());
        model.addAttribute("usuario", new Usuario());

        return "pages/usuarios";
    }

    @PostMapping
    public String criarUsuario(Usuario usuario, RedirectAttributes redirectAttributes){
        String retorno = new UsuarioService().inserir(usuario);
        redirectAttributes.addFlashAttribute("msg", "Criado com sucesso!");

        return "redirect:/usuario";
    }

    @GetMapping("/excluir/{usuarioID}")
    public String excluir(@PathVariable int usuarioID, RedirectAttributes redirectAttributes){
        String retorno = new UsuarioService().excluir(usuarioID);
        redirectAttributes.addFlashAttribute("msg", "Excluido com sucesso!");

        return "redirect:/usuario";
    }


}
