import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Menu {

    private ArrayList<Hebergement> hebergements;
    private ArrayList<Personne> clients;
    private Personne persConnecte;
    private Scanner s;

    public Menu(ArrayList<Hebergement> hebergements, ArrayList<Personne> clients) {
        this.hebergements = hebergements;
        this.clients = clients;
        this.persConnecte = null;
        this.s = new Scanner(System.in);
    }

    public void afficher() {

        while (true) {
            String menu = "\nBienvenue sur Booking :" +
                    "\n 1) S'inscrire" +
                    "\n 2) Se connecter" +
                    "\n 3) Rechercher un hebergement" +
                    "\n 4) Historique des réservations" +
                    "\n 5) Annuler une reservation" +
                    "\n 0) Quitter";

            System.out.println(menu);
            int choix = s.nextInt();

            switch (choix) {

                case 0:
                    persConnecte=null;
                    System.out.println("Au revoir");
                    break;

                case 1:
                    inscription();
                    break;

                case 2:
                    connexion();
                    break;

                case 3:
                    rechercher();
                    break;

                case 4:
                    historique();
                    break;

                case 5 :
                    cancel();
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void inscription() {
        NouveauClient n = new NouveauClient("", "", "", "", "");
        AncienClient inscrit = n.Sinscrire();
        clients.add(inscrit);
        persConnecte = inscrit;
        System.out.println("Inscription réussie, bienvenue " + inscrit.getPrenom());
    }

    private void connexion() {
        int indice = AncienClient.Seconnecter(clients);
        if (indice != -1) {
            persConnecte = clients.get(indice);
            System.out.println("Connexion réussie.");
        } else {
            System.out.println("Echec de connexion.");
        }
    }

    private void rechercher() {

        s.nextLine();

        System.out.print("Ville : ");
        String ville = s.nextLine();

        System.out.print("Type (hotel, auberge, appartement, maison) : ");
        String type = s.nextLine();

        System.out.print("Prix minimum : ");
        double prixMin = s.nextDouble();

        System.out.print("Prix maximum : ");
        double prixMax = s.nextDouble();

        System.out.print("Nombre de personnes : ");
        int nbPersonnes = s.nextInt();

        s.nextLine();

        System.out.print("Date de début (AAAA-MM-JJ) : ");
        LocalDate debut = LocalDate.parse(s.nextLine());

        System.out.print("Date de fin (AAAA-MM-JJ) : ");
        LocalDate fin = LocalDate.parse(s.nextLine());

        Periodes periode = new Periodes(debut, fin);

        ArrayList<Hebergement> resultats =
                Client.Filtrer(hebergements, periode, type, ville, prixMin, prixMax, nbPersonnes);

        if (resultats.isEmpty()) {
            System.out.println("Aucun hébergement trouvé.");
            return;
        }

        System.out.println("\n--- Hébergements disponibles ---");

        for (int i = 0; i < resultats.size(); i++) {
            System.out.println(i + ") " +
                    resultats.get(i).Resume() +
                    "\n Prix du séjour sans reductions: " +
                    resultats.get(i).prixTotal(debut, fin));
        }

        System.out.println("Réserver ? (1 = oui / autre = non)");
        int reserver = s.nextInt();

        if (reserver != 1)
            return;

        System.out.println("Numéro de l'hébergement : ");
        int indexH = s.nextInt();

        if (indexH < 0 || indexH >= resultats.size()) {
            System.out.println("Numéro invalide.");
            return;
        }

        if (persConnecte == null) {
            System.out.println("\nVous devez vous connecter.");
            System.out.println("1) S'inscrire\n2) Se connecter");
            int choix = s.nextInt();

            if (choix == 1)
                inscription();
            else if (choix == 2)
                connexion();
        }

        if (persConnecte != null) {
            int indexR = ((Client)persConnecte).getReservations().size();
            ((Client) persConnecte).Reserver(resultats.get(indexH), debut, fin);
            ((Client)persConnecte).getReservations().get(indexR).Calcul_prix_total_reduc();
            System.out.println("Réservation réussie.");
        }
    }

    private void historique() {

        if (persConnecte == null) {
            System.out.println("Veuillez vous connecter.");
            return;
        }

        ArrayList<Reservation> historique =
                ((Client) persConnecte).getReservations();

        if (historique == null || historique.isEmpty()) {
            System.out.println("Aucune réservation trouvée.");
            return;
        }

        System.out.println("\n--- Historique ---");
        System.out.println(((AncienClient)persConnecte).Historique_reservations());
    }

    private void cancel(){
        historique();
        System.out.println("Numero de la reservation a annuler :");
        int i = s.nextInt();
        Reservation r = ((Client)persConnecte).getReservations().get(i-1);
        r.Annuler();
        ((Client)persConnecte).Annuler_reservation(r);
        System.out.println("Reservation annulee");
    }
}

