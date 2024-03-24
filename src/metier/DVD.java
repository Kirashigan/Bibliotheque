package metier;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DVD extends Ouvrage{

    private long code;
    private LocalTime dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues=new ArrayList<>();
    private List<String> sousTitres=new ArrayList<>();
    public DVD(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre, long code, LocalTime dureeTotale, byte nbreBonus) {
        super(titre, ageMin, dateParution, TypeOuvrage.DVD, prixLocation, langue, genre);
        this.code=code;
        this.dureeTotale=dureeTotale;
        this.nbreBonus=nbreBonus;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public LocalTime getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(LocalTime dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    public byte getNbreBonus() {
        return nbreBonus;
    }

    public void setNbreBonus(byte nbreBonus) {
        this.nbreBonus = nbreBonus;
    }

    public List<String> getAutresLangues() {
        return autresLangues;
    }

    public void setAutresLangues(List<String> autresLangues) {
        this.autresLangues = autresLangues;
    }

    public List<String> getSousTitres() {
        return sousTitres;
    }

    public void setSousTitres(List<String> sousTitres) {
        this.sousTitres = sousTitres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return code == dvd.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
    @Override
    public double amendeRetard(int njours) {

        return njours * 1.50;
    }

    @Override
    public int njlocmax() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString()+"DVD{" +
                "code=" + code +
                ", dureeTotale='" + dureeTotale + '\'' +
                ", nbreBonus=" + nbreBonus +
                ", autresLangues=" + autresLangues +
                ", sousTitres=" + sousTitres +
                "} " + super.toString();
    }
}
