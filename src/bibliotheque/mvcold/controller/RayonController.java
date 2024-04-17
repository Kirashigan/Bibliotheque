package bibliotheque.mvcold.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvcold.model.DAORayon;
import bibliotheque.mvcold.model.DAORayon;
import bibliotheque.mvcold.view.AbstractViewRayon;
import bibliotheque.mvcold.view.RayonViewConsole;

import java.util.List;

public class RayonController {
    protected DAORayon model;
    protected AbstractViewRayon view;

    public RayonController(DAORayon model, AbstractViewRayon view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Rayon> getAll(){
        List<Rayon> l = model.getAll();
        return l;
    }

    public Rayon add( Rayon elt) {
        Rayon nelt = model.add(elt);
        return nelt;
    }
    public boolean remove(Rayon elt) {
        return model.remove(elt);
    }
    public Rayon update(Rayon elt) {
        return model.update(elt);
    }

    public Rayon search(Rayon rech) {
        return  model.read(rech);
    }

    public List<Exemplaire> listerExemplaires(Rayon r){
        return model.listerExemplaires(r);
    }

}
