import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private int id;
    private String statut;
    private Client client;
    private Hebergement hebergement;
    private Periodes periode;
    private double prix;
    private LocalDate date_reservation;

    public Reservation (int id, String statut, Hebergement hebergement, Client client, Periodes periode, double prix, LocalDate reserv){
        this.id=id;
        this.statut=statut;
        this.hebergement = hebergement;
        this.client = client;
        this.periode=periode;
        this.prix=prix;
        this.date_reservation=reserv;
    }

    //getter
    public int getId() {
        return id;
    }
    public LocalDate getDate_reservation() {
        return date_reservation;
    }
    public double getPrix() {
        return prix;
    }
    public Periodes getPeriode() {
        return periode;
    }
    public Hebergement getHebergement() {
        return hebergement;
    }
    public Client getClient() {
        return client;
    }
    public String getStatut() {
        return statut;
    }

    //setter
    public void setStatut(String statut) {
        this.statut = statut;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }


    void Calcul_prix_total_reduc() {
        double prix_sansReduc = this.hebergement.prix;
        int nbr_Reservations = 2;

    }

    //retourne 1 si confirmée sinon 0
    void Verif_confirmation() {


    }

    void Application_reduc() {

    }

    void Annuler_reservation() {

    }
}
