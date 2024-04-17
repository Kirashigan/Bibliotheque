package bibliotheque.mvcold.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAORayon extends Subject {

    public abstract Rayon add( Rayon elt) ;

    public abstract boolean remove( Rayon elt) ;

    public abstract Rayon update (Rayon elt) ;

    public abstract Rayon read(Rayon rech) ;

    public abstract List<Exemplaire> listerExemplaires(Rayon r);

    public abstract List<Rayon> getAll() ;

    public List<Rayon> getNotification(){
        return getAll();
    }
}