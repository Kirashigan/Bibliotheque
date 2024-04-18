package bibliotheque.mvc.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface ControllerSpecialOuvrage {

    List<Exemplaire> listerExemplaire(Ouvrage o);

   List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation);

   double amendeRetard(Ouvrage o,int nj);
}
