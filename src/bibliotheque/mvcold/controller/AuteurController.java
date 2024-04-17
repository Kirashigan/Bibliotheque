package bibliotheque.mvcold.controller;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvcold.model.DAOAuteur;
import bibliotheque.mvcold.view.AbstractViewAuteur;


import java.util.List;
import java.util.Set;


public class AuteurController {

    protected DAOAuteur model;
    protected AbstractViewAuteur view;

    public AuteurController(DAOAuteur model, AbstractViewAuteur view) {
        this.model=model;
        this.view=view;
        this.view.setController(this);
    }

    public List<Auteur> getAll(){
        List<Auteur> l = model.getAll();
        return l;
    }

    public Auteur add( Auteur elt) {
        Auteur nelt = model.add(elt);
        return nelt;
    }
    public boolean remove(Auteur elt) {
        return model.remove(elt);
    }
    public Auteur update(Auteur elt) {
        return model.update(elt);
    }

    public Auteur search(Auteur rech) {
        return  model.read(rech);
    }
    public Set<Ouvrage> listerOuvrages(Auteur a) {
      return model.listerOuvrages(a);
    }

    public List<Livre> listerLivre(Auteur a, TypeLivre tl) {

        return model.listerLivre(a,tl);
    }
    public List<Ouvrage> listerOuvrages(Auteur a, String genre) {
       return model.listerOuvrages(a,genre);
    }
}
