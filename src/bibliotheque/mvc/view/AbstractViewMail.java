package bibliotheque.mvc.view;

import bibliotheque.metier.Mail;
import bibliotheque.mvc.controller.MailController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewMail implements Observer {

    protected MailController MailController;
    protected List<Mail> le;

    public void setController(MailController auteurController) {
        this.MailController = MailController;
    }

    public abstract void menu();

    public abstract void affList(List le);

    public List<Mail> getAll(){
        return le;
    }
    @Override
    public void update(List le) {
        this.le = le;
        affList(le);
    }
}
