package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public  class ModelRayon extends DAO<Rayon> implements DAOSpecialRayon{

    private List<Rayon> ldatas = new ArrayList<>();


    @Override
    public Rayon add( Rayon elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( Rayon elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Rayon update(Rayon elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Rayon read(Rayon rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Rayon> getAll() {
        return ldatas;
    }


    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return new ArrayList<>(r.listerExemplaires());
    }
}