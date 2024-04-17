package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LecteurViewConsole extends AbstractViewLecteur {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(LecteurController.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher","modifier","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void retirer() {
        int nl = choixElt(le)-1;
        Lecteur a = le.get(nl);
        boolean ok = LecteurController.remove(a);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("Nom ");
            String nom = sc.nextLine();
            System.out.println("Prenom ");
            String prenom = sc.nextLine();
            Lecteur rech = new Lecteur(nom, prenom);
            Lecteur a = LecteurController.search(rech);
            if(a==null) affMsg("Lecteur inconnu");
            else {
                affMsg(a.toString());
                special(a);
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }

    public void modifier() {
        int choix = choixElt(le);
        Lecteur a = le.get(choix-1);
        do {
            try {
                String nom = modifyIfNotBlank("Nom: ", a.getNom());
                String prenom = modifyIfNotBlank("Prenom: ", a.getPrenom());
                a.setNom(nom);
                a.setPrenom(prenom);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        LecteurController.update(a);
    }


    public void ajouter() {
        Lecteur a;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                a = new Lecteur(nom, prenom);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        LecteurController.add(a);
    }

    public void special(Lecteur a) {

        List options = Arrays.asList("lister ouvrages", "lister livres", "lister par genre","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    listerOuvrages(a);
                    break;
                case 2:
                    listerLivres(a);
                    break;
                case 3:
                    listerGenre(a);
                    break;
                case 4 :return;
            }
        } while (true);

    }


    public void listerGenre(Lecteur a) {
        System.out.println("genre :");
        String genre = sc.nextLine();
        affListe(new ArrayList(LecteurController.listerOuvrages(a,genre)));
    }


    public void listerOuvrages(Lecteur a){
        affList(new ArrayList(LecteurController.listerOuvrages(a)));
    }


    public void listerLivres(Lecteur a){
        TypeLivre[] tlv = TypeLivre.values();
        int ch2 = choixListe(List.of(tlv));
        TypeLivre tl = tlv[ch2-1];
        affList(new ArrayList(LecteurController.listerLivre(a,tl)));
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
