package bibliotheque.gestion;

import bibliotheque.metier.*;
import bibliotheque.utilitaires.*;
import bibliotheque.utilitaires.comparators.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.choixListe;

public class GestionOld {
    Scanner sc = new Scanner(System.in);
//on a ôté static pour les listes qui n'est plus nécessaire
    private List<Auteur> laut = new ArrayList<>();
    private List<Lecteur> llect = new ArrayList<>();
    private List<Ouvrage> louv= new ArrayList<>();
    private List<Exemplaire> lex = new ArrayList<>();
    private List<Rayon> lrayon= new ArrayList<>();

    public static final Map<Exemplaire,Lecteur> LOCATIONS = new HashMap();


    public void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,LocalTime.of(2,0,0),(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

         a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        a.addOuvrage(d);


        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);
        e.setRayon(r);


        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        e.setRayon(r);


        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        LOCATIONS.put(e,lec);

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","restitution","fin"));
      do{
        int choix = choixListe(options);

            switch (choix){
                case 1 :gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                case 7 : gestRestitution();break;
                default:System.exit(0);
            }
        }  while (true);
    }

    private void gestRestitution() {
        //TODO lister exemplaires en location , choisir l'un d'entre eux, enregistrer sa restitution et éventuellement changer état
    }

    private void gestLocations() {
        int choix;
        List<Exemplaire> lex2 = new ArrayList<>(lex);
        Iterator<Exemplaire> itlex2 = lex2.iterator();
        while(itlex2.hasNext()){
            if(itlex2.next().enLocation()) itlex2.remove();
        }
        lex2.sort(new ExemplaireMatriculeComparator());
        choix =choixListe(lex2);
        if(choix==0)return;
        Exemplaire ex = lex2.get(choix-1);
        choix=choixListe(llect);
        if(choix==0)return;
        Lecteur lec = llect.get(choix-1);
        LOCATIONS.put(ex,lec);
    }

    private void gestLecteurs() {
        System.out.println("numéro");
        int num=sc.nextInt();
        sc.skip("\n");
        System.out.println("nom ");
        String nom=sc.nextLine();
        System.out.println("prénom ");
        String prenom=sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn= LocalDate.of(a,m,j);
        System.out.println("adresse");
        String adr=sc.nextLine();
        System.out.println("mail");
        String mail=sc.nextLine();
        System.out.println("tel ");
        String tel=sc.nextLine();
        Lecteur lect = new Lecteur(num,nom,prenom,dn,adr,mail,tel);
        llect.add(lect);
        System.out.println("lecteur créé");

    }

    private void gestRayons() {
        System.out.println("code ");
        String code=sc.next();
        System.out.println("genre ");
        String genre=sc.next();
        Rayon r = new Rayon(code,genre);
        System.out.println("rayon créé");
        lrayon.add(r);
        List<Exemplaire>  lex2= new ArrayList<>(lex);
        Iterator<Exemplaire> itLex2 = lex2.iterator();
        while(itLex2.hasNext()){
            Rayon ract = itLex2.next().getRayon();
            if(r.equals(ract)) itLex2.remove();
        }
        lex2.sort(new ExemplaireTitreComparator());
        do {
            int choix = choixListe(lex2);
            if(choix==0) break;
            r.addExemplaire(lex.get(choix - 1));
            System.out.println("exemplaire ajouté");
            lex2.remove(choix-1);
        }
        while(true);
    }

    private void gestExemplaires() {
        System.out.println("matricule ");
        String mat=sc.next();
        System.out.println("etat  ");
        String etat=sc.next();
        System.out.println("ouvrage ");
        int choix = choixListe(louv);
        Exemplaire ex = new Exemplaire(mat,etat,louv.get(choix-1));
        lex.add(ex);
        System.out.println("exemplaire créé");
        lrayon.sort(new RayonComparator());
        choix = choixListe(lrayon);
        if(choix==0) return;
        ex.setRayon(lrayon.get(choix-1));
           }

    private void gestOuvrages() {


        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = choixListe(lto);
        if(choix==0) return;
        Ouvrage o = null;

    /* switch(choix) {
            case 1 : o = new LivreFactoryBeta().create();break;
            case 2 : o = new CDFactoryBeta().create();break;
            case 3 : o = new DVDFactoryBeta().create();break;
        }*/
        List<OuvrageFactory> lof = Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory());
        OuvrageFactory of = lof.get(choix-1);
        o = of.create();
        louv.add(o);
        System.out.println("ouvrage créé");
        List<Auteur> laut2 = new ArrayList<>(laut);
        Iterator<Auteur> itlaut = laut2.iterator();
        while(itlaut.hasNext()){
            if(o.getLauteurs().contains(itlaut.next())) itlaut.remove();
        }
        laut2.sort(new AuteurComparator());
        do {
            choix = choixListe(laut2);
            if(choix==0) break;
            o.addAuteur(laut2.get(choix - 1));
            laut2.remove(choix-1);
            System.out.println("auteur ajouté");
        }while(true);

    }

       private void gestAuteurs() {
        System.out.println("nom ");
        String nom=sc.nextLine();
        System.out.println("prénom ");
        String prenom=sc.nextLine();
        System.out.println("nationalité");
        String nat=sc.nextLine();
        Auteur a  = new Auteur(nom,prenom,nat);
        laut.add(a);
        System.out.println("écrivain créé");

        List<Ouvrage> lo2 = new ArrayList<>(louv);
        Iterator<Ouvrage> itlo2 = lo2.iterator();
        while(itlo2.hasNext()){
            if(a.getLouvrage().contains(itlo2.next())) itlo2.remove();
        }
        lo2.sort(new OuvrageComparator());
        do {
            int choix = choixListe(lo2);
            if (choix == 0) break;
            a.addOuvrage(lo2.get(choix - 1));
            System.out.println("ouvrage ajouté");
            lo2.remove(choix - 1);
        }
        while(true);
    }

    public static void main(String[] args) {
        GestionOld g = new GestionOld();
        g.populate();
        g.menu();
    }

  
}
