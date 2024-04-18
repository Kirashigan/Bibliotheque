package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Mail;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Rayon;
import bibliotheque.mvc.GestionMVC;
import bibliotheque.mvc.controller.ControllerSpecialExemplaire;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.affListe;

public class ExemplaireViewConsole extends AbstractView<Exemplaire> {

    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(controller.getAll());
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
        int nl = choixElt(la)-1;
        Exemplaire a = la.get(nl);
        boolean ok = controller.remove(a);
        if(ok) affMsg("exemplaire effacé");
        else affMsg("exemplaire non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("matricule ");
            String mat = sc.nextLine();
            Exemplaire rech = new Exemplaire(mat,"",null);
            Exemplaire a = controller.search(rech);
            if(a==null) affMsg("exemplaire inconnu");
            else {
                affMsg(a.toString());
                special(a);
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Exemplaire a = la.get(choix-1);
        do {
            try {
                String description = modifyIfNotBlank("nom", a.getDescriptionEtat());
                a.setDescriptionEtat(description);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        controller.update(a);
    }


    public void ajouter() {
        Exemplaire a;
        do {
            try {
                System.out.println("matricule ");
                String mat = sc.nextLine();
                System.out.println("description ");
                String descr = sc.nextLine();
                System.out.println("ouvrage : ");
                List<Ouvrage> lo = GestionMVC.ov.getAll();
                //TODO présenter les ouvrages par ordre de titre ==> classe anonyme
                int ch = choixListe(lo);
                a = new Exemplaire(mat, descr,lo.get(ch-1));
                System.out.println("rayon");
                List<Rayon> lr = GestionMVC.rv.getAll();
                //TODO présenter les rayons par ordre de code ==> classe anonyme
                ch= choixListe(lr);
                a.setRayon(lr.get(ch-1));
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        controller.add(a);
    }

    public void special(Exemplaire a) {

        List options = Arrays.asList("modifier etat", "lecteur actuel", "envoi mail","en location","louer","rendre","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    modifierEtat(a);
                    break;
                case 2:
                    lecteurActuel(a);
                    break;
                case 3:
                    envoiMail(a);
                    break;
                case 4 :
                    enLocation(a);
                    break;
                case 5 :
                    louer(a);
                    break;
                case 6 :
                    rendre(a);
                    break;
                case 7: return;
            }
        } while (true);

    }

    private void rendre(Exemplaire a) {
        GestionMVC.LOCATIONS.remove(a);
   }

    private void louer(Exemplaire a) {
        //TODO chosir un lecteur et enregistrer la location dans LOCATIONS
    }


    public void enLocation(Exemplaire ex) {
        boolean loc = ((ControllerSpecialExemplaire)controller).enLocation(ex);
        if(loc) System.out.println("en location");
        else System.out.println("pas en location");
    }


    public void envoiMail(Exemplaire ex) {
        Mail m = new Mail("demo","message de test","01-01-2024");
        ((ControllerSpecialExemplaire)controller).envoiMailLecteurActuel(ex,m);
    }


    public void lecteurActuel(Exemplaire ex) {
        ((ControllerSpecialExemplaire)controller).LecteurActuel(ex);
    }


    public void modifierEtat(Exemplaire ex) {
        System.out.println("nouvel état :");
        String etat = sc.nextLine();
        ((ControllerSpecialExemplaire)controller).modifierEtat(ex,etat) ;
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
