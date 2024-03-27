package bibliotheque.metier;

public class Mail {
    private String objet;
    private String message;
    private String dateEnvoi;

    public Mail(String objet, String message, String dateEnvoi) {
        this.objet = objet;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "objet='" + objet + '\'' +
                ", message='" + message + '\'' +
                ", dateEnvoi='" + dateEnvoi + '\'' +
                '}';
    }
}
