package bibliotheque.mvc.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Mail;
import bibliotheque.mvc.model.DAO;
import bibliotheque.mvc.model.DAOSpecialExemplaire;
import bibliotheque.mvc.view.AbstractView;

public class ExemplaireController extends Controller<Exemplaire> implements ControllerSpecialExemplaire{

    public ExemplaireController(DAO<Exemplaire> model, AbstractView<Exemplaire> view) {
        super(model, view);
    }

    @Override
    public void modifierEtat(Exemplaire ex, String etat) {
        ((DAOSpecialExemplaire)model).modifierEtat(ex,etat);
     }


    @Override
    public Lecteur LecteurActuel(Exemplaire ex) {
        return ((DAOSpecialExemplaire)model).lecteurActuel(ex);

    }


    @Override
    public void envoiMailLecteurActuel(Exemplaire ex, Mail m) {
        ((DAOSpecialExemplaire)model).envoiMailLecteurActuel(ex,m);
     }


    @Override
    public boolean  enLocation(Exemplaire ex) {
        return ((DAOSpecialExemplaire)model).enLocation(ex);

    }
}
