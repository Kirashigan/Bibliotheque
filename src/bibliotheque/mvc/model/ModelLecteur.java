package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;

public class ModelLecteur extends DAO<Lecteur> {
    private List<Lecteur> ldatas = new ArrayList<>();


    @Override
    public Lecteur add( Lecteur elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove( Lecteur elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Lecteur update(Lecteur elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Lecteur read(Lecteur rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Lecteur> getAll() {
        return ldatas;
    }

}
