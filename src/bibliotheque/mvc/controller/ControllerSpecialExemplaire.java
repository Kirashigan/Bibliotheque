package bibliotheque.mvc.controller;

import bibliotheque.metier.*;

public interface ControllerSpecialExemplaire {

    void modifierEtat(Exemplaire ex, String etat);

   Lecteur LecteurActuel(Exemplaire ex);

    void envoiMailLecteurActuel(Exemplaire ex, Mail m);

    boolean enLocation(Exemplaire ex);
}
