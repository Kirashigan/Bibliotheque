package bibliotheque.mvcold.controller;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvcold.model.DAO;
import bibliotheque.mvcold.model.DAOLecteur;
import bibliotheque.mvcold.view.AbstractView;
import bibliotheque.mvcold.view.AbstractViewLecteur;

import java.util.List;

public class LecteurController extends Controller<Lecteur> {

    public LecteurController(DAO<Lecteur> model, AbstractView<Lecteur> view) {
        super(model, view);
    }
}
