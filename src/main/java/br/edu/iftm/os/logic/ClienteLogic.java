package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteLogic implements CrudLogic<Cliente> {

    @Override
    public Cliente salvar(Cliente entidade) {
        System.out.println("######## Salvando cliente ");
        return entidade;
    }

    @Override
    public void deletar(Cliente entidade) {
        System.out.println("######## Deletando cliente");
    }

    @Override
    public Cliente buscarPorId(Cliente entidade) {
        System.out.println("######## Buscando pelo ID cliente");
        return entidade;
        
    }

    @Override
    public List<Cliente> buscar(Cliente entidade) {
        System.out.println("######## Buscando cliente");
        return new ArrayList<>();
    }
 
    
    
}
