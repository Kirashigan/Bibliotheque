package bibliotheque.mvcold.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.observer.Observer;
import bibliotheque.mvcold.controller.LecteurController;

import java.util.List;


public abstract  class AbstractViewLecteur implements Observer {

    protected LecteurController lecteurController;
    protected List<Lecteur> la;

    public void setController(LecteurController lecteurController) {
        this.lecteurController = lecteurController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Lecteur> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
