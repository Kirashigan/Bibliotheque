package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.controller.LecteurController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;


public abstract  class AbstractViewLecteur implements Observer {

    protected LecteurController LecteurController;
    protected List<Lecteur> le;

    public void setController(LecteurController auteurController) {
        this.LecteurController = LecteurController;
    }

    public abstract void menu();

    public abstract void affList(List le);

    public List<Lecteur> getAll(){
        return le;
    }
    @Override
    public void update(List le) {
        this.le = le;
        affList(le);
    }
}
