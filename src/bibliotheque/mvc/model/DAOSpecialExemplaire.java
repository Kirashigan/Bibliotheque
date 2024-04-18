package bibliotheque.mvc.model;

import bibliotheque.metier.*;


public interface DAOSpecialExemplaire {

    public void modifierEtat(Exemplaire ex, String etat);
    public Lecteur lecteurActuel(Exemplaire ex);

    public void envoiMailLecteurActuel(Exemplaire ex,Mail m);

    public boolean enLocation(Exemplaire ex);
}