package bibliotheque.mvc.controller;


import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.model.DAOSpecialOuvrage;
import bibliotheque.mvc.view.AbstractView;
import bibliotheque.mvc.model.DAO;
import java.util.List;

public class OuvrageController extends Controller<Ouvrage> implements ControllerSpecialOuvrage{

    public OuvrageController(DAO<Ouvrage> model, AbstractView<Ouvrage> view) {
        super(model,view);
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o){
        return((DAOSpecialOuvrage)model).listerExemplaire(o);
    }
    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation){
        return((DAOSpecialOuvrage)model).listerExemplaire(o,enLocation);
    }

    @Override
    public double amendeRetard(Ouvrage o,int nj) {
        return ((DAOSpecialOuvrage)model).amendeRetard(o,nj);
    }
}
