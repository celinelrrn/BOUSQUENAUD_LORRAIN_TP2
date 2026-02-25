import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String adresse;
    private String date_inscription;
    private ArrayList<Reservation> reservations;

    // constructeur
    public Client (String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.date_inscription = date_inscription;
    }

    ArrayList<Hebergement> filtrer (ArrayList<Hebergement> hebergements) {
        ArrayList <Hebergement> resultat = new ArrayList<>();
        // on fait des criteres precis un par un ??

        return resultat;
    }

    public void Afficher_infos() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Email : " + email);
        System.out.println("Adresse : " + adresse);
        System.out.println("Date d'inscription : " + date_inscription);
        System.out.println("Nombre de réservations : " + reservations.size());
    }

    public void Reserver (Hebergement hebergement, LocalDate debut, LocalDate fin) {
        if (true/*fonction pour savoir s'il est dispo dans la classe hebergement*/) {
            Reservation reservation = new Reservation(hebergement, this);
            reservations.add(reservation);
        }
    }

    public void Annuler_reservation(Reservation reservation) {
        reservation.Annuler_reservation(); // a creer dans la classe Reservation
        reservations.remove(reservation);
    }

    public void Verif_reduction() {

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