package bibliotheque.metier;

import java.util.*;

public class Rayon {
    private String codeRayon;
    private String genre;
    private Set<Exemplaire> lex = new HashSet<>();


    public Rayon(String codeRayon, String genre) {
        this.codeRayon = codeRayon;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rayon rayon = (Rayon) o;
        return Objects.equals(codeRayon, rayon.codeRayon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeRayon);
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "codeRayon='" + codeRayon + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
    public void addExemplaire(Exemplaire e){
        lex.add(e);
        e.setRayon(this);
    }

    public void remove(Exemplaire e){
        lex.remove(e);
        e.setRayon(null);
    }
    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Exemplaire> getLex() {
        return lex;
    }

    public void setLex(Set<Exemplaire> lex) {
        this.lex = lex;
    }

    public Set<Exemplaire>listerExemplaires(){
        return lex;
    }


}
