package bibliotheque.utilitaires;

import bibliotheque.metier.CD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;

public class CDFactory extends OuvrageFactory{
    protected  long code;
    protected  byte nbrePlages;
    protected LocalTime dureeTotale;
    public Ouvrage create() {
        super.base();
        System.out.println("code : ");
        code= sc.nextLong();
        System.out.println("nombre de plages :");
        nbrePlages= sc.nextByte();
        LocalTime dureeTotale = Utilitaire.lecTime();
        CD cd =new CD(titre,ageMin,dateParution,prixLocation,langue,genre,code,nbrePlages,dureeTotale);
        return cd;
    }
}
