import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    int id;
    String statut;
    Client client;
    Hebergement hebergement;
    LocalDate[] dates;
    float prix;
    String date_reservation;

    public Reservation (Hebergement hebergement, Client client){
        this.hebergement = hebergement;
        this.client = client;
    }

    void Calcul_prix_total() {

    }

    void Verif_confirmation() {


    }

    void Application_reduc() {

    }

    void Annuler_reservation() {

    }
}
