package bibliotheque.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Ouvrage {
    protected String titre;
    protected int ageMin;
    protected LocalDate dateParution;
    protected TypeOuvrage to;
    protected double prixLocation;
    protected String langue;
    protected String genre;

    protected Set<Auteur> lauteurs=new HashSet<>();

    protected Set<Exemplaire> lex = new HashSet<>();


    public Ouvrage(String titre, int ageMin, LocalDate dateParution, TypeOuvrage to, double prixLocation, String langue, String genre) {
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.to = to;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public void setDateParution(LocalDate dateParution) {
        this.dateParution = dateParution;
    }

    public TypeOuvrage getTo() {
        return to;
    }

    public void setTo(TypeOuvrage to) {
        this.to = to;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Auteur> getLauteurs() {
        return lauteurs;
    }

    public void setLauteurs(Set<Auteur> lauteurs) {
        this.lauteurs = lauteurs;
    }

    public Set<Exemplaire> getLex() {
        return lex;
    }

    public void setLex(Set<Exemplaire> lex) {
        this.lex = lex;
    }


    public abstract double amendeRetard(int njours);

    public abstract int njlocmax();

    @Override
    public String toString() {
        return "Ouvrage{" +
                "titre='" + titre + '\'' +
                ", ageMin=" + ageMin +
                ", dateParution=" + dateParution +
                ", to=" + to +
                ", prixLocation=" + prixLocation +
                ", langue='" + langue + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
    public void addAuteur(Auteur a ){
        lauteurs.add(a);
        a.getLouvrage().add(this);
    }

    public void remove(Auteur a){
        lauteurs.remove(a);
        a.getLouvrage().remove(this);
    }
    public void addExemplaire(Exemplaire e){
        lex.add(e);
        e.setOuvrage(this);
    }

    public void remove(Exemplaire e){
        lex.remove(e);
        e.setOuvrage(null);
    }
    public Set<Exemplaire>listerExemplaires(){
        return lex;
    }

    public List<Exemplaire>listerExemplaires(boolean enLocation){
        List<Exemplaire> lex2 = new ArrayList<>();
        for(Exemplaire ex : lex){
            if(ex.enLocation()==enLocation) lex2.add(ex);
        }
        return lex2;
    }
}
