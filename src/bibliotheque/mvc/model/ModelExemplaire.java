package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Mail;

import java.util.ArrayList;
import java.util.List;


public class ModelExemplaire extends DAO<Exemplaire> implements DAOSpecialExemplaire{

    private List<Exemplaire> ldatas = new ArrayList<>();


    @Override
    public Exemplaire add( Exemplaire elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( Exemplaire elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Exemplaire update(Exemplaire elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Exemplaire read(Exemplaire rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Exemplaire> getAll() {
        return ldatas;
    }

    public void modifierEtat(Exemplaire ex, String etat) {
        ex.setDescriptionEtat(etat);
    }

    @Override
    public Lecteur lecteurActuel(Exemplaire ex) {
        return ex.lecteurActuel();
    }


    @Override
    public void envoiMailLecteurActuel(Exemplaire ex,Mail m) {

        ex.envoiMailLecteurActuel(m);
    }
    @Override
    public boolean enLocation(Exemplaire ex) {
        return ex.enLocation();
    }
}