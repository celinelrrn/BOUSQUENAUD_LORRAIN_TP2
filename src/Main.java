import java.time.LocalDate;
import java.util.Random;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Hebergement> hebergements = new ArrayList<>();
        ArrayList<Personne> clients = new ArrayList<>();

        Random random = new Random();
        Hebergement h1 = new Hebergement(random.nextInt(100), "L'intercontinental", "12 rue colonel faux", "hotel", 2, 100.5, "", 0, "Paris");
        h1.Add_dispo(LocalDate.of(2026, 4, 12), LocalDate.of(2026, 8, 12));
        h1.Add_Equipements("Serviettes" + "Savon" + "produits hygieniques");
        h1.Add_note(9.7);
        h1.Add_note(8);
        h1.Calcul_moyenne();
        hebergements.add(h1);

        Hebergement h2 = new Hebergement(random.nextInt(100), "Le Bristol", "112 avenue des Champs-Élysées", "hotel", 3, 150.0, " ", 0, "Paris");
        h2.Add_dispo(LocalDate.of(2026, 1, 5), LocalDate.of(2026, 10, 12));
        h2.Add_Equipements("Wifi" + "Télévision" + "Climatisation");
        h2.Add_note(10);
        h2.Add_note(7);
        h2.Calcul_moyenne();
        hebergements.add(h2);

        Hebergement h3 = new Hebergement(random.nextInt(100), "Auberge du Lac", "5 route du Lac", "auberge", 1, 80.0, " ", 0, "Annecy");
        h3.Add_dispo(LocalDate.of(2026, 9, 1), LocalDate.of(2026, 10, 30));
        h3.Add_Equipements("Petit-déjeuner inclus" + "Parking" + "Jardin");
        h3.Add_note(9);
        h3.Add_note(7);
        h3.Calcul_moyenne();
        hebergements.add(h3);

        Hebergement h4 = new Hebergement(random.nextInt(100), "Résidence Soleil", "22 boulevard Victor Hugo", "appartement", 4, 60.0, " ", 0, "Lyon");
        h4.Add_dispo(LocalDate.of(2027, 2, 10), LocalDate.of(2027, 4, 25));
        h4.Add_Equipements("Cuisine équipée" + "Lave-linge" + "Balcon");
        h4.Add_note(5);
        h4.Add_note(8);
        h4.Calcul_moyenne();
        hebergements.add(h4);

        Hebergement h5 = new Hebergement(random.nextInt(100), "Maison du jardin", "1 chemin du Château", "maison", 5, 200.0, " ", 0, "Tours");
        h5.Add_dispo(LocalDate.of(2027, 6, 1), LocalDate.of(2027, 9, 1));
        h5.Add_Equipements("Piscine" + "Barbecue" + "Garage");
        h5.Add_note(8);
        h5.Add_note(9);
        h5.Calcul_moyenne();
        hebergements.add(h5);

        Menu menu = new Menu(hebergements, clients);
        menu.afficher();
    }
}