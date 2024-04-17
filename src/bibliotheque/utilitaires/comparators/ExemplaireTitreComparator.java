package bibliotheque.utilitaires.comparators;

import bibliotheque.metier.Exemplaire;

import java.util.Comparator;

public class ExemplaireTitreComparator implements Comparator<Exemplaire> {
    @Override
    public int compare(Exemplaire e1, Exemplaire e2) {
        return e1.getOuvrage().getTitre().compareTo(e2.getOuvrage().getTitre());
    }
}
