    package bibliotheque.mvc;

    import bibliotheque.metier.*;
    import bibliotheque.mvc.controller.*;
    import bibliotheque.mvc.model.*;
    import bibliotheque.mvc.view.*;
    import bibliotheque.utilitaires.Utilitaire;


    import java.time.LocalDate;
    import java.time.LocalTime;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;


    public class GestionMVC {

        public static  HashMap<Exemplaire,Lecteur> LOCATIONS = new HashMap<>();
        public static  DAO<Auteur> am;
        public static  AbstractView<Auteur> av;
        public static  Controller<Auteur> ac;

        public static  DAO<Ouvrage> om;
        public static  AbstractView<Ouvrage> ov;
        public static  Controller<Ouvrage> oc;

        public static  DAO<Lecteur> lm;
        public static  AbstractView<Lecteur> lv;
        public static  Controller<Lecteur> lc;

        public static  DAO<Exemplaire> em;
        public static  AbstractView<Exemplaire> ev;
        public static  Controller<Exemplaire> ec;

        public static  DAO<Rayon> rm;
        public static  AbstractView<Rayon> rv;
        public static  Controller<Rayon> rc;


        public void gestion(){

            am = new ModelAuteur() ;
            av = new AuteurViewConsole();
            ac = new AuteurController(am,av);//création et injection de dépendance
            am.addObserver(av);

            om = new ModelOuvrage() ;
            ov = new OuvrageViewConsole();
            oc = new OuvrageController(om,ov);//création et injection de dépendance
            om.addObserver(ov);

            lm = new ModelLecteur() ;
            lv = new LecteurViewConsole();
            lc = new LecteurController(lm,lv);//création et injection de dépendance
            lm.addObserver(lv);

            em = new ModelExemplaire() ;
            ev = new ExemplaireViewConsole();
            ec = new ExemplaireController(em,ev);//création et injection de dépendance
            em.addObserver(ev);

            rm = new ModelRayon() ;
            rv = new RayonViewConsole();
            rc = new RayonController(rm,rv);//création et injection de dépendance
            rm.addObserver(rv);
            
            
    try {
        populate();
    }
    catch (Exception e) {
        System.out.println("erreur lors du populate : " + e);
        System.exit(1);
    }
            List<String> loptions = Arrays.asList("auteurs","lecteurs","ouvrages","exemplaires","rayons","fin");
            do {
                int ch = Utilitaire.choixListe(loptions);
                switch (ch){
                    case 1: av.menu();
                        break;
                    case 2: lv.menu();
                        break;
                    case 3: ov.menu();
                        break;
                    case 4: ev.menu();
                        break;
                    case 5: rv.menu();
                        break;
                     case 6: System.exit(0);
                }
            }while(true);
        }
        public void populate()  {

            Auteur a1 = new Auteur("Verne", "Jules", "France");
            am.add(a1);
            Auteur a2 = new Auteur("Spielberg", "Steven", "USA");
            am.add(a2);
            Auteur a3 = new Auteur("Kubrick", "Stanley", "GB");
            am.add(a3);


            Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
            om.add(l);
            a1.addOuvrage(l);


            DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l, LocalTime.of(2,0,0),(byte)2);
            d.getAutresLangues().add("français");
            d.getAutresLangues().add("italien");
            d.getSousTitres().add("néerlandais");
            om.add(d);

            a2.addOuvrage(d);

            a3.addOuvrage(d);


            CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
            om.add(c);

            Rayon r = new Rayon("r12","aventure");
            rm.add(r);

            Exemplaire e = new Exemplaire("m12","état neuf",l);
            em.add(e);
            e.setRayon(r);


            r = new Rayon("r45","science fiction");
            rm.add(r);

            e = new Exemplaire("d12","griffé",d);
            em.add(e);

            e.setRayon(r);


            Lecteur lec = new Lecteur("Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
            lm.add(lec);

            LOCATIONS.put(e,lec);

            lec = new Lecteur("Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
            lm.add(lec);
        }

        public static void main(String[] args) {
            GestionMVC gb = new GestionMVC();
            gb.gestion();
        }
    }
