package br.edu.iftm.os.bean;

import br.edu.iftm.os.model.Usuario;
import br.edu.iftm.os.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
@Getter @Setter
public class UsuarioBean implements Serializable {
    
    @Inject
    private UsuarioRepository repostorio;
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init(){
        novo();
    }
    
    public void novo() {
        this.usuario = new Usuario();
    }
    
    public void salvar(){
        this.repostorio.salvar(this.usuario);
        novo();
    }
    
    public void editar(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void deletar(Usuario usuario){
        Usuario u = new Usuario();
        u.setId(usuario.getId());
        this.repostorio.deletar(u);
        usuarios.remove(u);
    }
    
    public void listar(){
        this.usuarios = this.repostorio.listar();
    }
    
}
