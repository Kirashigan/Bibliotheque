package src.bibliotheque.metier;

import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.metier.TypeOuvrage;

import java.util.*;

import static bibliotheque.metier.TypeOuvrage.LIVRE;


public class Auteur {
    private  String nom,prenom;
    private String nationalite;
    private Set<bibliotheque.metier.Ouvrage> louvrage = new HashSet<>();


    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Set<bibliotheque.metier.Ouvrage> getLouvrage() {
        return louvrage;
    }

    public void setLouvrage(Set<bibliotheque.metier.Ouvrage> louvrage) {
        this.louvrage = louvrage;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) && Objects.equals(prenom, auteur.prenom) && Objects.equals(nationalite, auteur.nationalite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, nationalite);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nationalite='" + nationalite + '\'' +
                '}';
    }

    public void addOuvrage(bibliotheque.metier.Ouvrage o ){
        louvrage.add(o);
        o.getLauteurs().add(this);
    }

    public void remove(bibliotheque.metier.Ouvrage o){
        louvrage.remove(o);
        o.getLauteurs().remove(this);
    }

    public Set<bibliotheque.metier.Ouvrage> listerOuvrages(){

        return louvrage;
    }

    public List<bibliotheque.metier.Ouvrage> listerOuvrages(TypeOuvrage to){
        List<bibliotheque.metier.Ouvrage> lot = new ArrayList<>();
        for(bibliotheque.metier.Ouvrage o : louvrage){
            if(o.getTo().equals(to)) lot.add(o);
        }
        return lot;
    }
    public List<Livre> listerLivres(TypeLivre tl){
        List<Livre>ll = new ArrayList<>();
        for(bibliotheque.metier.Ouvrage o : louvrage){
            if(o.getTo().equals(LIVRE)) {
                Livre l = (Livre)o;
                if(l.getTl().equals(tl)) ll.add(l);
            }
        }
        return ll;
    }
    public List<bibliotheque.metier.Ouvrage> listerOuvrages(String genre){
        List<bibliotheque.metier.Ouvrage> lot = new ArrayList<>();
        for(Ouvrage o : louvrage){
            if(o.getGenre().equals(genre)) lot.add(o);
        }
        return lot;
    }
}
