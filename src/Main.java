import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Hebergement> hebergements = new ArrayList<Hebergement>();
        ArrayList<Client> clients = new ArrayList<Client>();

        //créer hebergements
        Random random = new Random();
        Hebergement h1= new Hebergement(random.nextInt(100), "L'intercontinental", "12 rue colonel faux", "hotel", 2,100.5, " ",0, "Paris");
        hebergements.add(h1);
        Hebergement h2 = new Hebergement(random.nextInt(100), "Le Bristol", "112 avenue des Champs-Élysées", "hotel", 3, 150.0, " ", 0, "Paris");
        hebergements.add(h2);
        Hebergement h3 = new Hebergement(random.nextInt(100), "Auberge du Lac", "5 route du Lac", "auberge", 1, 80.0, " ", 0, "Annecy");
        hebergements.add(h3);
        Hebergement h4 = new Hebergement(random.nextInt(100), "Résidence Soleil", "22 boulevard Victor Hugo", "appartement", 4, 60.0, " ", 0, "Lyon");
        hebergements.add(h4);
        Hebergement h5 = new Hebergement(random.nextInt(100), "Maison du jardin", "1 chemin du Château", "maison", 5, 200.0, " ", 0, "Tours");
        hebergements.add(h5);

        //menu
        Scanner s=new Scanner(System.in);
        String menu = "Bienvenue sur Booking :" + "\n 1)S'inscrire \n 2)Se connecter \n 3)Rechercher un hebergement";
        System.out.println(menu);
        int choix = s.nextInt();
        switch(choix){
            case 1:
                //CODE POUR SINSCRIRE

                break;
            case 2:
                //CODE POUR SE CONNECTER
                break;
            case 3:
                //FILTRER
        }

    }
}