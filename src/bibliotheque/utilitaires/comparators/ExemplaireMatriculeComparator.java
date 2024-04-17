package bibliotheque.utilitaires.comparators;

import bibliotheque.metier.Exemplaire;

import java.util.Comparator;

public class ExemplaireMatriculeComparator implements Comparator<Exemplaire> {
    @Override
    public int compare(Exemplaire e1, Exemplaire e2) {
        return e1.getMatricule().compareTo(e2.getMatricule());
    }
}
