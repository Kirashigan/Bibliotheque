package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.observer.Subject;
import java.util.List;
import java.util.Set;

public abstract class DAOExemplaire extends Subject {


    public abstract Exemplaire add( Exemplaire elt) ;

    public abstract boolean remove( Exemplaire elt) ;

    public abstract Exemplaire update(Exemplaire elt) ;

    public abstract Exemplaire read(Exemplaire rech) ;

    public abstract List<Exemplaire> getAll() ;


    public abstract Set<Ouvrage> listerOuvrages(Exemplaire a);

    public abstract List<Livre> listerLivre(Exemplaire a, TypeLivre tl) ;

    public abstract List<Ouvrage> listerOuvrages(Exemplaire a, String genre);

    public List<Exemplaire> getNotification(){
        return getAll();
    }
}