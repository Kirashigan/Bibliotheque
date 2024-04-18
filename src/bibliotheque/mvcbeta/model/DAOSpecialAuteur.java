package bibliotheque.mvcbeta.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.List;
import java.util.Set;

public interface DAOSpecialAuteur {

    public Set<Ouvrage> listerOuvrages(Auteur a);

    public List<Livre> listerLivre(Auteur a, TypeLivre tl);


    public List<Ouvrage> listerOuvrages(Auteur a, String genre) ;
}
