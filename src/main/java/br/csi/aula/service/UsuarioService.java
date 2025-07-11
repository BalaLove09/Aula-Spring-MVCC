package br.csi.aula.service;




import br.csi.aula.dao.UsuarioDAO;
import br.csi.aula.model.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    private static UsuarioDAO dao = new UsuarioDAO();

    public String excluir(int id){

        if(dao.excluir(id)){
            return "Sucesso ao excluir usuario";
        }else{
            return "Erro ao excluir usuario";
        }

    }

        public ArrayList<Usuario> listar(){

        //o usuário q está solicitando
        // a requisição pode acessar essa lista?
        return dao.listar();
    }

    public Usuario buscar(int usuarioId) {
        return dao.buscar(usuarioId);
    }

    public String inserir(Usuario usuario) {
        return dao.inserir(usuario);
    }

}
