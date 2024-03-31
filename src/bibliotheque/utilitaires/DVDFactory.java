package bibliotheque.utilitaires;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class DVDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        System.out.println("code : ");
        long code= sc.nextLong();
        LocalTime dureeTotale=Utilitaire.lecTime();
        byte nbreBonus= sc.nextByte();
        DVD dvd =new DVD(titre,ageMin,dateParution,prixLocation,langue,genre,code,dureeTotale,nbreBonus);
        System.out.println("autres langues");
        Set<String> langues = new HashSet<>();
        langues.add("anglais");
        langues.add("français");
        langues.add("allemand");
        langues.add("fin");
        int choix;
        do{
            choix=Utilitaire.choixListe(Collections.singletonList(langues));
            if(choix==langues.size())break;
            if(dvd.getAutresLangues().equals(choix))break;
            for (String s : langues){
                if(s.equalsIgnoreCase(String.valueOf(choix))) break;
            }
            dvd.getAutresLangues().add(String.valueOf(langues.equals(choix-1)));
        }while(true);
        System.out.println("sous-titres");
        do{
            choix=Utilitaire.choixListe(Collections.singletonList(langues));
            if(choix==langues.size())break;
            dvd.getSousTitres().add(String.valueOf(langues.equals(choix-1)));
        }while(true);
        return dvd;
    }
}
