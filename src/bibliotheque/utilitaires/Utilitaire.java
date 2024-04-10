package bibliotheque.utilitaires;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {
    private static Scanner sc = new Scanner(System.in);


    public static int lireInt(){
        int n=0;
        do{
            try {
                String ns = sc.nextLine();
                n=Integer.parseInt(ns);
                return n;
            }
            catch(NumberFormatException e){
                System.out.println("valeur numérique incorrecte");
            }

        } while(true);
    }

    public static long lireLong(){
        long n=0;
        do{
            try {
                String ns = sc.nextLine();
                n=Long.parseLong(ns);
                return n;
            }
            catch(NumberFormatException e){
                System.out.println("valeur numérique incorrecte");
            }

        } while(true);
    }
    public static double lireDouble(){
        double n=0;
        do{
            try {
                String ns = sc.nextLine();
                n=Double.parseDouble(ns);
                return n;
            }
            catch(NumberFormatException e){
                System.out.println("valeur numérique incorrecte");
            }

        } while(true);
    }
    public static int choixListe(List l){
        affListe(l);
        return choixElt(l);
    }

    public static void affListe(List l){
        int i =1;
        for(Object o :l) {
            System.out.println((i++)+"."+o);
        }
    }

    public static int choixElt(List l){
        int choix;
        do {
            System.out.println("choix :");
            choix = lireInt();

        } while(choix <1 || choix > l.size());
        return choix;
    }

    public static LocalDate lecDate(){
        do {
            String dateLue= sc.nextLine();
            try {
                return getDate(dateLue);
            } catch (Exception e) {
                System.out.println("date incorrecte");
            }
        }while (true);
    }

    public static LocalDate getDate(String dateLue) {
        String[] jma = dateLue.split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        return LocalDate.of(a, m, j);
    }

    public static LocalTime lecTime(){
        do {
            try {
                String[] hms = sc.nextLine().split(" ");
                int h = Integer.parseInt(hms[0]);
                int m = Integer.parseInt(hms[1]);
                int s = Integer.parseInt(hms[2]);
                return LocalTime.of(h, m, s);
            }
            catch (Exception e){
                System.out.println("temps incorrect");
            }
        }
        while (true);
    }

    public static String getDateFrench(LocalDate d){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MM yyyy");
        return dtf.format(d);
    }

    public static String modifyIfNotBlank(String label,String oldValue){
        System.out.println(label+" : "+oldValue);
        System.out.print("nouvelle valeur (enter si pas de changement) : ");
        String newValue= sc.nextLine();
        if(newValue.isBlank()) return oldValue;
        return newValue;
    }
}
