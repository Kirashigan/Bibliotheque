package bibliotheque.mvc.model;

import bibliotheque.metier.Livre;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LivreModel extends Livre {

    private List<Livre> ldatas = new ArrayList<>();


    public LivreModel(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre, String isbn, int nbrePages, TypeLivre tl, String resume) {
        super(titre, ageMin, dateParution, prixLocation, langue, genre, isbn, nbrePages, tl, resume);
    }
}

