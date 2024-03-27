package bibliotheque.utilitaires;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {
    private static Scanner sc = new Scanner(System.in);
    public static int choixListe(List l){

       int i =1;
       for(Object o :l) {
         System.out.println((i++)+"."+o);
       }
       int choix;
        do {
                System.out.println("choix :");
                choix = sc.nextInt();
                sc.skip("\n");
            } while(choix <1 || choix > l.size());
        return choix;
    }

    public static LocalDate lecDate(){
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        return LocalDate.of(a,m,j);
    }

    public static LocalTime lecTime(){
        String[] hms = sc.nextLine().split(" ");
        int h = Integer.parseInt(hms[0]);
        int m = Integer.parseInt(hms[1]);
        int s = Integer.parseInt(hms[2]);
        return LocalTime.of(h,m,s);
    }
}
