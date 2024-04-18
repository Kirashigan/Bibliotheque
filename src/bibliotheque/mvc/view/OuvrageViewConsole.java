package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvc.controller.ControllerSpecialOuvrage;
import bibliotheque.utilitaires.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class OuvrageViewConsole extends AbstractView<Ouvrage> {
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
        Ouvrage a = la.get(nl);
        boolean ok = controller.remove(a);
        if(ok) affMsg("ouvrage effacé");
        else affMsg("ouvrage non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        //TODO rechercher ouvrage en demandant type d'ouvrage, puis l'info unique relative à au type recherché
    }


    public void modifier() {
        int choix = choixElt(la);
        Ouvrage a = la.get(choix-1);
         do {
            try {
                double ploc =Double.parseDouble(modifyIfNotBlank("prix location",""+a.getPrixLocation()));
                a.setPrixLocation(ploc);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        controller.update(a);
   }


    public void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage a = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        a = lof.get(choix-1).create();
        //TODO affecter un ou plusieurs auteurs
        //TODO trier les auteurs présentés par ordre de nom et prénom  ==>  classe anonyme
        //TODO ne pas présenter les auteurs déjà enregistrés pour cet ouvrage
        controller.add(a);
    }

    protected void special() {
        int choix =  choixElt(la);
        Ouvrage o = la.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires", "lister exemplaires en location", "lister exemplaires libres","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(o);
                    break;
                case 2:
                    enLocation(o, true);
                    break;
                case 3:
                    enLocation(o, false);
                    break;

                case 4 :return;
            }
        } while (true);

    }

    public void enLocation(Ouvrage o, boolean enLocation) {
        List<Exemplaire> l= ((ControllerSpecialOuvrage) controller).listerExemplaire(o, enLocation);
        affList(l);
    }

    public void exemplaires(Ouvrage o) {
        List<Exemplaire> l= ((ControllerSpecialOuvrage)controller).listerExemplaire(o);
        affList(l);
    }
    @Override
    public void affList(List la) {
        affListe(la);
    }
}
