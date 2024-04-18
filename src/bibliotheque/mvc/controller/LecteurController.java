package bibliotheque.mvc.controller;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.model.DAO;
import bibliotheque.mvc.view.AbstractView;

public class LecteurController extends Controller<Lecteur> {

    public LecteurController(DAO<Lecteur> model, AbstractView<Lecteur> view) {
        super(model, view);
    }
}
