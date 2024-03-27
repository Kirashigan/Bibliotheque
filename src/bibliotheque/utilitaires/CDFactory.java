package bibliotheque.utilitaires;

import bibliotheque.metier.CD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;

public class CDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        System.out.println("code : ");
        long code= sc.nextLong();
        System.out.println("nombre de plages :");
        byte nbrePlages= sc.nextByte();
        LocalTime dureeTotale = Utilitaire.lecTime();
        CD cd =new CD(titre,ageMin,dateParution,prixLocation,langue,genre,code,nbrePlages,dureeTotale);
        return cd;
    }
}
