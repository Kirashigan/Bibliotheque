package bibliotheque.mvcold.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvc.observer.Observer;
import bibliotheque.mvcold.controller.RayonController;

import java.util.List;


public abstract  class AbstractViewRayon implements Observer {

    protected RayonController rayonController;
    protected List<Rayon> la;

    public void setController(RayonController rayonController) {
        this.rayonController = rayonController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Rayon> getAll(){
        return la;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
