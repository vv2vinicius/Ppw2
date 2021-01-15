package br.edu.iftm.os.logic;


import br.edu.iftm.os.model.Status;
import br.edu.iftm.os.repository.StatusRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class StatusLogic implements CrudLogic<Status> {

    @Inject
    private StatusRepository repository;
    
    @Override
    @Transacao
    public Status salvar(Status entidade) throws ErroNegocioException, ErroSistemaException {
        
        if(entidade.getDescricao() == null || entidade.getDescricao().equals("")){
            throw new ErroNegocioException("Descrição é obrigatório");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Status entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Status buscarPorId(Status entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade == null || entidade.getId() == null){
            throw new ErroNegocioException("Servico não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;
        
    }

    @Override
    public List<Status> buscar(Status entidade) throws ErroNegocioException, ErroSistemaException {
        List Status = repository.listar();
        return Status;
    }
 
    
    
}
