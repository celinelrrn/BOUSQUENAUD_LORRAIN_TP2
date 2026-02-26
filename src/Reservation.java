import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private int id;
    private int statut; //0->annulé, 1->en cours, 2->confirmé
    private Client client;
    private Hebergement hebergement;
    private Periodes periode;
    private double prix;
    private LocalDate date_reservation;

    public Reservation (int id, int statut, Hebergement hebergement, Client client, Periodes periode, double prix, LocalDate reserv){
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
    public int getStatut() {
        return statut;
    }

    //setter
    public void setStatut(int statut) {
        this.statut = statut;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }


    void Calcul_prix_total_reduc() {

        double prix_sansReduc = this.hebergement.prix;
        double reduc = this.client.Verif_reduction();
        double prix_avecReduc = prix_sansReduc-(reduc * prix_sansReduc);
    }

    //retourne 1 si confirmée sinon 0
    void Verif_confirmation() {


    }

    void Application_reduc() {

    }

    void Annuler_reservation() {

    }
}
