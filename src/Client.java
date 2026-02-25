import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String adresse;
    private String date_inscription;

    // constructeur
    public Client (String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.date_inscription = date_inscription;
    }


}

class NouveauClient extends Client {
    public NouveauClient(String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        super(nom, prenom, email, mdp, adresse, date_inscription);
    }

}

class AncienClient extends Client {
    ArrayList<Reservation> reservations;

    public AncienClient(String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        super(nom, prenom, email, mdp, adresse, date_inscription);
    }
}