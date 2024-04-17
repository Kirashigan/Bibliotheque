    package bibliotheque.mvc;

    import bibliotheque.metier.*;
    import bibliotheque.mvc.model.*;
    import bibliotheque.mvc.controller.*;
    import bibliotheque.mvc.view.*;
    import bibliotheque.utilitaires.Utilitaire;

    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;

    public class GestionMVC {

        private DAO<Auteur> am;
        private AbstractView<Auteur> av;
        private Controller<Auteur> ac;

        public static final HashMap<Exemplaire,Lecteur> LOCATION = new HashMap<>();

        public void gestion(){
            am = new ModelAuteur();
            av = new AuteurViewConsole();
            ac = new AuteurController(am,av);//création et injection de dépendance
            am.addObserver(av);

            //TODO créer les éléments relatifs aux autres classes

            //TODO associer les vues entre elles pour exploiter leurs getAll()

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
            //TODO ajouter autres éléments, les associer entre eux et créer des locations

        }

        public static void main(String[] args) {
            GestionMVC gb = new GestionMVC();
            gb.gestion();
        }
    }
