package src.bibliotheque.utilitaires;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;
import bibliotheque.utilitaires.OuvrageFactory;
import bibliotheque.utilitaires.Utilitaire;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class DVDFactory extends OuvrageFactory {
    protected long code;
    protected LocalTime dureeTotale;
    protected byte nbreBonus;

    public Ouvrage create(){
        super.base();
        System.out.println("code : ");
        code= sc.nextLong();
        dureeTotale= bibliotheque.utilitaires.Utilitaire.lecTime();
        nbreBonus= sc.nextByte();
        DVD dvd =new DVD(titre,ageMin,dateParution,prixLocation,langue,genre,code,dureeTotale,nbreBonus);
        System.out.println("autres langues");
        List<String> langues = Arrays.asList("anglais","français","italien","allemand","fin");
        int choix;
        do{
            choix= bibliotheque.utilitaires.Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            dvd.getAutresLangues().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set et pas de doublon avec langue d'origine
        }while(true);
        System.out.println("sous-titres");
        do{
            choix= Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            dvd.getSousTitres().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set
        }while(true);
        return dvd;
    }
}
