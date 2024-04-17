package bibliotheque.mvc.model;

import bibliotheque.metier.Mail;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MailModel extends Mail {

    private List<Mail> ldatas = new ArrayList<>();


    public MailModel(String objet, String message, String dateEnvoi) {
        super(objet, message, dateEnvoi);
    }
}

