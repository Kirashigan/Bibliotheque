package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvc.controller.ControllerSpecialRayon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class RayonViewConsole extends AbstractView<Rayon> {
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

    @Override
    public void affList(List la) {
        affListe(la);
    }

    private void retirer() {
        int nl = choixElt(la)-1;
        Rayon r = la.get(nl);
        boolean ok = controller.remove(r);
        if(ok) affMsg("rayon effacé");
        else affMsg("rayon non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("code du rayon :");
            String code= sc.nextLine();
            Rayon rech = new Rayon(code,"");
            Rayon r = controller.search(rech);
            if(r==null) affMsg("rayon inconnu");
            else {
                affMsg(r.toString());
                special(r);
             }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }

    private void special(Rayon r) {
        List options = Arrays.asList("lister exemplaires","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    listerExemplaires(r);
                    break;

                case 2 :return;
            }
        } while (true);

    }

    public void listerExemplaires(Rayon r){
        List<Exemplaire> le = ((ControllerSpecialRayon)controller).listerExemplaires(r);
        affListe(le);
    }



    public void modifier() {
        int choix = choixElt(la);
        Rayon r  = la.get(choix-1);
         do {
            try {
                String genre = modifyIfNotBlank("nom", r.getGenre());
                r.setGenre(genre);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        controller.update(r);
   }


    public void ajouter() {
       Rayon r;
        do {
            try {
                System.out.println("code ");
                String code = sc.nextLine();
                System.out.println("genre ");
                String genre = sc.nextLine();
                 r = new Rayon(code,genre);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        r=controller.add(r);
        affMsg("création du rayon : "+r);
    }

}
