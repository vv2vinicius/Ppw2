package br.edu.iftm.os.bean;
import br.edu.iftm.os.logic.ServicoLogic;
import br.edu.iftm.os.model.Servico;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class ServicoBean extends CrudBean<Servico, ServicoLogic> {

    public ServicoBean() {
        super(Servico.class);
    }
    
    @Override
    public ServicoLogic getLogic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
