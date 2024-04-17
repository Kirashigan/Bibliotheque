package bibliotheque.mvc.controller;


import bibliotheque.metier.*;
import bibliotheque.mvc.model.DAOLivre;
import bibliotheque.mvc.view.AbstractViewLivre;

import java.util.List;
import java.util.Set;

public class LivreController {

    protected  DAOLivre model;
    protected AbstractViewLivre view;

    public LivreController(DAOLivre model, AbstractViewLivre view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Livre> getAll(){
        List<Livre> l = model.getAll();
        return l;
    }

    public Livre add( Livre elt) {
        Livre nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Livre elt) {
        return model.remove(elt);
    }
    public Livre update(Livre elt) {
        return model.update(elt);
    }

    public Livre search(Livre rech) {
        return  model.read(rech);
    }

    public List<Livre> listerLivre(Livre a, TypeLivre tl) {

        return model.listerLivre(a,tl);
    }


}
