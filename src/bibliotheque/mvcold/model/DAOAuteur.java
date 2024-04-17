package bibliotheque.mvcold.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.observer.Subject;

import java.util.List;
import java.util.Set;

public abstract class DAOAuteur extends Subject {

    public abstract Auteur add( Auteur elt) ;

    public abstract boolean remove( Auteur elt) ;

    public abstract Auteur update (Auteur elt) ;

    public abstract Auteur read(Auteur rech) ;

    public abstract List<Auteur> getAll() ;


    public abstract Set<Ouvrage> listerOuvrages(Auteur a);

    public abstract List<Livre> listerLivre(Auteur a, TypeLivre tl) ;

    public abstract List<Ouvrage> listerOuvrages(Auteur a, String genre);

    public List<Auteur> getNotification(){
        return getAll();
    }
}