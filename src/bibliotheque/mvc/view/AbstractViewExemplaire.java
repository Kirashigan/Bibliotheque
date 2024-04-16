package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewExemplaire implements Observer {

    protected ExemplaireController exemplaireController;
    protected List<Exemplaire> le;

    public void setController(ExemplaireController auteurController) {
        this.exemplaireController = exemplaireController;
    }

    public abstract void menu();

    public abstract void affList(List le);

    public List<Exemplaire> getAll(){
        return le;
    }
    @Override
    public void update(List le) {
        this.le = le;
        affList(le);
    }
}
