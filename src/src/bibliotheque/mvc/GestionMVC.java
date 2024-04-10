    package src.bibliotheque.mvc;

    import bibliotheque.metier.Auteur;
    import bibliotheque.mvc.controller.*;
    import bibliotheque.mvc.model.*;
    import bibliotheque.mvc.view.*;
    import bibliotheque.utilitaires.Utilitaire;

    import java.util.Arrays;
    import java.util.List;

    public class GestionMVC {


        private DAOAuteur am;
        private AbstractViewAuteur av;
        private AuteurController ac;


        public void gestion(){

            am = new AuteurModel();
            av = new AuteurViewConsole();
            ac = new AuteurController(am,av);//création et injection de dépendance
            am.addObserver(av);

    try {
        populate();
    }
    catch (Exception e) {
        System.out.println("erreur lors du populate : " + e);
        System.exit(1);
    }
            List<String> loptions = Arrays.asList("auteurs","fin");
            do {
                int ch = Utilitaire.choixListe(loptions);
                switch (ch){
                    case 1: av.menu();
                        break;
                     case 2 : System.exit(0);
                }
            }while(true);
        }
        public void populate()  {

            Auteur a = new Auteur("Verne", "Jules", "France");
            am.getAll().add(a);
            a = new Auteur("Spielberg", "Steven", "USA");
            am.getAll().add(a);
            a = new Auteur("Kubrick", "Stanley", "GB");
            am.getAll().add(a);
        }

        public static void main(String[] args) {
            GestionMVC gb = new GestionMVC();
            gb.gestion();
        }
    }
