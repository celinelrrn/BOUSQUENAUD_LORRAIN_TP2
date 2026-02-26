import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String adresse;
    private String date_inscription;
    private ArrayList<Reservation> reservations;

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public String getEmail(){
        return email;
    }

    public String getMdp(){
        return mdp;
    }

    // constructeur
    public Client (String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.date_inscription = date_inscription;
        this.reservations = new ArrayList<>();
    }

    ArrayList<Hebergement> filtrer (ArrayList<Hebergement> hebergements, Periodes periode, String type, String ville, double prixMin, double prixMax, int nbPersonnes) {
        ArrayList <Hebergement> resultat = new ArrayList<>(); // renvoyer une liste d'hebergements correspondant aux critères

        for (int i = 0; i<hebergements.size(); i++) {
            Hebergement hebergement = hebergements.get(i);
            if (hebergement.getAdresse().toLowerCase().contains(ville.toLowerCase())
                    && hebergement.type.equalsIgnoreCase(type)
                    && hebergement.prix >= prixMin
                    && hebergement.prix <= prixMax
                    && hebergement.nbMaxPersonne >= nbPersonnes
                    && hebergement.dates_libres(periode.getDateDebut(), periode.getDateFin())) {

                resultat.add(hebergement);
            }
        }
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
        if (hebergement.dates_libres(debut, fin)) {
            Random random = new Random();
            Periodes p = new Periodes(debut, fin);
            Reservation reservation = new Reservation(random.nextInt(100), 1, hebergement, this, p, 0, LocalDate.now());
            reservations.add(reservation);
            reservation.setStatut(2);
        }
    }

    public void Annuler_reservation(Reservation reservation) {
        reservation.Annuler_reservation();
        reservations.remove(reservation);
    }

    public int Verif_reduction() {
        return 0;
    }
}

class NouveauClient extends Client {
    public NouveauClient(String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        super(nom, prenom, email, mdp, adresse, date_inscription);
    }

    public AncienClient Sinscrire () {
        String nom;
        String prenom;
        String email;
        String mdp;
        String adresse;
        String date_inscription;

        Scanner sc = new Scanner(System.in);
        System.out.print("===== S'inscrire =====");
        System.out.print("Nom : ");
        nom = sc.nextLine();
        System.out.print("Prenom : ");
        prenom = sc.nextLine();
        System.out.print("Email : ");
        email = sc.nextLine();
        System.out.print("Mot de passe : ");
        mdp = sc.nextLine();
        System.out.print("Adresse : ");
        adresse = sc.nextLine();

        date_inscription = "jsp"; // A VOIR

        AncienClient client = new AncienClient(nom, prenom, email, mdp, adresse, date_inscription);
        return client;
    }

    public int Verif_reduction() {
        System.out.println("Pas encore de reduction");
        return 0;
    }
}

class AncienClient extends Client {
    public AncienClient(String nom, String prenom, String email, String mdp, String adresse, String date_inscription) {
        super(nom, prenom, email, mdp, adresse, date_inscription);
    }

    public void Historique_reservations() {
        ArrayList<Reservation> reservations = getReservations();

        System.out.println("Vos reservations :");
        for(int i = 0; i < reservations.size(); i++) {
            System.out.println(reservations.get(i));
        }
    }

    public static AncienClient Seconnecter(ArrayList<AncienClient> clients) {
        Scanner sc = new Scanner(System.in);

        System.out.print("===== Seconnecter =====");
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.println("Mot de passe : ");
        String mdp = sc.nextLine();

        for (int i = 0; i < clients.size(); i++) {

            AncienClient client = clients.get(i);

            if (client.getEmail().equals(email) && client.getMdp().equals(mdp)) {
                System.out.println("Connexion réussie !");
                return client;
            }
        }
        System.out.println("Email ou mot de passe incorrect.");
        return null;
    }

    public int Verif_reduction() {
        ArrayList <Reservation> reservations = getReservations();
        return reservations.size();
    }
}