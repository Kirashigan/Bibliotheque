package bibliotheque.mvc.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvc.model.DAO;
import bibliotheque.mvc.model.DAOSpecialRayon;
import bibliotheque.mvc.view.AbstractView;


import java.util.List;

public class RayonController extends Controller<Rayon> implements ControllerSpecialRayon{

    public RayonController(DAO<Rayon> model, AbstractView<Rayon> view) {
        super(model, view);
    }

    public List<Exemplaire> listerExemplaires(Rayon r){
        return ((DAOSpecialRayon)model).listerExemplaires(r);
    }

}
