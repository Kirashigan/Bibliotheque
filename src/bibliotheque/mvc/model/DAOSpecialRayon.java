package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAOSpecialRayon {
    public List<Exemplaire> listerExemplaires(Rayon r) ;
}
