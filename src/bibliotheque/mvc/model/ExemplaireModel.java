package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExemplaireModel extends Exemplaire {

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

    @Override
    public Set<Ouvrage> listerOuvrages(Exemplaire a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Livre> listerLivre(Exemplaire a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Exemplaire a, String genre) {
        return a.listerOuvrages(genre);
    }
}
