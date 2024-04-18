package bibliotheque.mvc.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.List;

public interface ControllerSpecialRayon {
    public List<Exemplaire> listerExemplaires(Rayon r);
}
