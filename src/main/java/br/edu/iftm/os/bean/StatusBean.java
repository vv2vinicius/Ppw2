package br.edu.iftm.os.bean;
import br.edu.iftm.os.logic.StatusLogic;
import br.edu.iftm.os.model.Status;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class StatusBean extends CrudBean<Status, StatusLogic> {

    public StatusBean() {
        super(Status.class);
    }
    
    @Override
    public StatusLogic getLogic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
