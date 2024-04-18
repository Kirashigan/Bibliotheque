package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelOuvrage extends DAO<Ouvrage> implements DAOSpecialOuvrage{
    private List<Ouvrage> ldatas = new ArrayList<>();


    @Override
    public Ouvrage add( Ouvrage elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( Ouvrage elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Ouvrage update(Ouvrage elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Ouvrage read(Ouvrage rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Ouvrage> getAll() {
        return ldatas;
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o) {
        return new ArrayList<>(o.listerExemplaires());
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation) {
        List<Exemplaire> l = listerExemplaire(o);
        Iterator<Exemplaire> it = l.iterator();
        while(it.hasNext()){
            if(it.next().enLocation()!=enLocation) it.remove();
        }
        return l;
    }

    @Override
    public double amendeRetard(Ouvrage o,int nj) {
        return o.amendeRetard(nj);
    }
}
