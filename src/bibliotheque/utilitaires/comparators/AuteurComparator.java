package bibliotheque.utilitaires.comparators;

import bibliotheque.metier.Auteur;

import java.util.Comparator;

public class AuteurComparator implements Comparator<Auteur> {
    @Override
    public int compare(Auteur o1, Auteur o2) {
        if(o1.getNom().compareTo(o2.getNom())!=0) return (o1.getNom().compareTo(o2.getNom()));
        return o1.getPrenom().compareTo(o2.getPrenom())  ;
    }
}
