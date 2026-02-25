public class Client {
    String nom;
    String prenom;
    String email;
    String mdp;
    String adresse;
    String date_inscription;

}

class NouveauClient extends Client {

}

class AncienClient extends Client {
    Reservation[] liste_reservation;

}