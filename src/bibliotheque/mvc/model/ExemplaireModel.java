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


    public ExemplaireModel(String matricule, String descriptionEtat, String titre) {
        super(matricule, descriptionEtat, titre);
    }
}
