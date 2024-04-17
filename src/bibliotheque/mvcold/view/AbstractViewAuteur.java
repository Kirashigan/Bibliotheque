package bibliotheque.mvcold.view;

import bibliotheque.metier.Auteur;
import bibliotheque.mvc.observer.Observer;
import bibliotheque.mvcold.controller.AuteurController;

import java.util.List;


public abstract  class AbstractViewAuteur implements Observer {

    protected AuteurController auteurController;
    protected List<Auteur> la;

    public void setController(AuteurController auteurController) {
        this.auteurController = auteurController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Auteur> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
