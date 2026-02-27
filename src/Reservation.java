import java.time.LocalDate;

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


    //calcule le prix avec reduc en fonction du nombre de nuits et du prix sans reduc
    public void Calcul_prix_total_reduc() {
        double prix_sansReduc = this.hebergement.prixTotal(this.periode.getDateDebut(), this.periode.getDateFin());
        double reduc = 0.02*this.client.Verif_reduction();
        double prix_avecReduc = prix_sansReduc-(reduc * prix_sansReduc);
        this.setPrix(prix_avecReduc);
    }

    //retourne 1 si confirmée sinon 0
    public boolean Verif_confirmation() {
        if(this.statut==2){
            System.out.println("Réservation confirmée");
            return true;
        }
        else if(this.statut==1){
            System.out.println("Réservation en cours");
            return false;
        }
        else{
            System.out.println("Réservation annulée");
            return false;
        }
    }

    public void Annuler() {
        this.statut=0;
    }
}
