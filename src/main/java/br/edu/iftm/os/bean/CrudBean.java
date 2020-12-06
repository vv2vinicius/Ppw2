package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.CrudLogic;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CrudBean<E, L extends CrudLogic<E>> extends JSFUtil {

    private Status status = Status.BUSCA;

    private E entidade;
    private List<E> entidades;
    private Class<E> classeEntidade;
    
    private enum Status {
        BUSCA,
        NOVO,
        EDITA
    }

    public CrudBean(Class<E> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }

    public void novo() {
        try {
            this.entidade = classeEntidade.getDeclaredConstructor().newInstance();
            status = Status.NOVO;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(E entidade) {
        this.entidade = getLogic().buscarPorId(entidade);
        status = Status.EDITA;
    }

    public void salvar() {
        getLogic().salvar(this.entidade);
        addMensagemInfo("Salvo com sucesso");
        buscar();
    }

    public void buscar() {
        if (!status.equals(Status.BUSCA)) {
            status = Status.BUSCA;
            return;
        }
        this.entidades = getLogic().buscar(entidade);
        if (this.entidades.isEmpty()) {
            addMensagemAviso("Nenhum dado cadastrado.");
        }

    }

    public abstract L getLogic();

}
