package bibliotheque.mvcold.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOExemplaire extends Subject {

    public abstract Exemplaire add( Exemplaire elt) ;

    public abstract boolean remove( Exemplaire elt) ;

    public abstract Exemplaire update (Exemplaire elt) ;

    public abstract Exemplaire read(Exemplaire rech) ;

    public abstract List<Exemplaire> getAll() ;

    public List<Exemplaire> getNotification(){
        return getAll();
    }
}