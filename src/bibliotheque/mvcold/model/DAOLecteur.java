package bibliotheque.mvcold.model;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOLecteur extends Subject {

    public abstract Lecteur add( Lecteur elt) ;

    public abstract boolean remove( Lecteur elt) ;

    public abstract Lecteur update (Lecteur elt) ;

    public abstract Lecteur read(Lecteur rech) ;

    public abstract List<Lecteur> getAll() ;

    public List<Lecteur> getNotification(){
        return getAll();
    }
}