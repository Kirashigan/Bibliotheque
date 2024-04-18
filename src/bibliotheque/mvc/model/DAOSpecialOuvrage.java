package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface DAOSpecialOuvrage {
   public List<Exemplaire> listerExemplaire(Ouvrage o);
    public List<Exemplaire> listerExemplaire(Ouvrage o,boolean enLocation);

    public double amendeRetard(Ouvrage o,int nj);

}