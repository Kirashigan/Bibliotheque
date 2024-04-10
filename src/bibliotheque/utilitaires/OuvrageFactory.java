package bibliotheque.utilitaires;


import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;

import java.time.LocalDate;
import java.util.Scanner;

public  abstract class OuvrageFactory {
   protected Scanner sc= new Scanner(System.in);

    protected String titre;
    protected int ageMin;
    protected LocalDate dateParution;
    protected TypeOuvrage to;
    protected double prixLocation;
    protected String langue;
    protected String genre;

   public void base() {
       System.out.println("titre");
       titre= sc.nextLine();
       System.out.println("age minimum");
       ageMin= sc.nextInt();
       sc.skip("\n");
       System.out.println("date de parution");

       dateParution= Utilitaire.lecDate();
       System.out.println("prix de location");
       prixLocation = sc.nextDouble();
       sc.skip("\n");
       System.out.println("langue");
       langue=sc.nextLine();
       System.out.println("genre");
       genre=sc.nextLine();
   }

    public abstract Ouvrage create();
}
