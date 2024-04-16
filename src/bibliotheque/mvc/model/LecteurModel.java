package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LecteurModel extends Lecteur {

    private List<Lecteur> ldatas = new ArrayList<>();


    public LecteurModel(int numlecteur, String nom, String prenom, LocalDate dn, String adresse, String mail, String tel) {
        super(numlecteur, nom, prenom, dn, adresse, mail, tel);
    }
}

