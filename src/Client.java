import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

abstract class Personne {

    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String adresse;

    public Personne(String nom, String prenom, String email, String mdp, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public String getMdp() { return mdp; }
    public String getAdresse() { return adresse; }
}


public class Client extends Personne {
    private LocalDate date_inscription;
    private ArrayList<Reservation> reservations;

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    // constructeur
    public Client(String nom, String prenom, String email, String mdp,
                  String adresse) {

        super(nom, prenom, email, mdp, adresse); // appel au constructeur Personne
        this.date_inscription = LocalDate.now();
        this.reservations = new ArrayList<>();
    }

    public static ArrayList<Hebergement> Filtrer (ArrayList<Hebergement> hebergements, Periodes periode, String type, String ville, double prixMin, double prixMax, int nbPersonnes) {
        ArrayList <Hebergement> resultat = new ArrayList<>(); // renvoyer une liste d'hebergements correspondant aux critères

        for (int i = 0; i<hebergements.size(); i++) {
            Hebergement hebergement = hebergements.get(i);
            if (hebergement.getVille().equals(ville)
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
        System.out.println("Nom : " + getNom());
        System.out.println("Prénom : " + getPrenom());
        System.out.println("Email : " + getEmail());
        System.out.println("Adresse : " + getAdresse());
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
        if(reservation!=null && LocalDate.now().isBefore(reservation.getPeriode().getDateDebut())){
            reservation.Annuler();
            reservations.remove(reservation);
        }
    }

    public int Verif_reduction() {
        return 0;
    }
}

class NouveauClient extends Client {
    public NouveauClient(String nom, String prenom, String email, String mdp, String adresse) {
        super(nom, prenom, email, mdp, adresse);
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

        AncienClient client = new AncienClient(nom, prenom, email, mdp, adresse);
        return client;
    }

    public int Verif_reduction() {
        System.out.println("Pas encore de reduction");
        return 0;
    }
}

class AncienClient extends Client {
    public AncienClient(String nom, String prenom, String email, String mdp, String adresse) {
        super(nom, prenom, email, mdp, adresse);
    }

    public String Historique_reservations() {
        ArrayList<Reservation> reservations = getReservations();

        System.out.println("Vos reservations :");
        String histo="";

        for(int i = 0; i < reservations.size(); i++) {
            histo += "Reservation " + (i+1) + ": \nEtablissement :" + reservations.get(i).getHebergement().type + " " + reservations.get(i).getHebergement().nom +
                    "\n du " + reservations.get(i).getPeriode().getDateDebut() + " au " + reservations.get(i).getPeriode().getDateFin() +
                    "\n prix : " + reservations.get(i).getPrix() +
                    "\n effectuée le :" + reservations.get(i).getDate_reservation();
            if(reservations.get(i).getStatut()==0){
                histo += "\nReservation annulée";
            }
            else if(reservations.get(i).getStatut()==1){
                histo += "\nReservation en cours";
            }
            else{
                histo += "\nReservation confirmée";
            }

        }
        return histo;
    }

    public static int Seconnecter(ArrayList<Personne> clients) {
        Scanner sc = new Scanner(System.in);

        System.out.print("===== Seconnecter =====");
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.println("Mot de passe : ");
        String mdp = sc.nextLine();

        for (int i = 0; i < clients.size(); i++) {

            Personne client = clients.get(i);

            if (client.getEmail().equals(email) && client.getMdp().equals(mdp)) {
                System.out.println("Connexion réussie !");
                return i;
            }
        }
        System.out.println("Email ou mot de passe incorrect.");
        return -1;
    }

    public int Verif_reduction() {
        ArrayList <Reservation> reservations = getReservations();
        return reservations.size();
    }
}