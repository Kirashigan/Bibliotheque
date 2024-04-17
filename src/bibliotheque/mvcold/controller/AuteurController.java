package bibliotheque.mvcold.controller;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvcold.model.DAO;
import bibliotheque.mvcold.model.DAOAuteur;
import bibliotheque.mvcold.model.DAOSpecialAuteur;
import bibliotheque.mvcold.model.ModelAuteur;
import bibliotheque.mvcold.view.AbstractView;
import bibliotheque.mvcold.view.AbstractViewAuteur;


import java.util.List;
import java.util.Set;


public class AuteurController extends Controller<Auteur> implements ControllerSpecialAuteur {

    public AuteurController(DAO<Auteur> model, AbstractView<Auteur> view) {
        super(model, view);
    }

    public Set<Ouvrage> listerOuvrages(Auteur a) {
      return ((DAOSpecialAuteur)model).listerOuvrages(a);
    }

    public List<Livre> listerLivre(Auteur a, TypeLivre tl) {

        return ((DAOSpecialAuteur)model).listerLivre(a,tl);
    }
    public List<Ouvrage> listerOuvrages(Auteur a, String genre) {
       return ((DAOSpecialAuteur)model).listerOuvrages(a,genre);
    }
}
