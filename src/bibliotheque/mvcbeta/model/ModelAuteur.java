package bibliotheque.mvcbeta.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.List;
import java.util.Set;

public class ModelAuteur extends ModelList<Auteur> implements DAOSpecialAuteur{
    @Override
    public Set<Ouvrage> listerOuvrages(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Livre> listerLivre(Auteur a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur a, String genre) {
        return a.listerOuvrages(genre);
    }
}