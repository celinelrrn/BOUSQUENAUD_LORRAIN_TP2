import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Hebergement {

    private int id_unique;
    public String nom;
    private String adresse;
    public String type;
    public int nbMaxPersonne;
    public double prix;
    public String description;
    public ArrayList<String> equipements;
    public ArrayList <Double> notes;
    public double moyenne;
    private ArrayList <Periodes> periodes_dispo;


    public Hebergement(int id, String nom, String adr, String type, int nbMaxpers, double p, String d, double moyenne){
        this.id_unique=id;
        this.nom=nom;
        this.adresse=adr;
        this.type=type;
        this.nbMaxPersonne=nbMaxpers;
        this.prix=p;
        this.description=d;
        this.equipements= new ArrayList<>();
        this.notes=new ArrayList<>();
        this.moyenne=moyenne;
        this.periodes_dispo=new ArrayList<>();
    }

    public int getId_unique() {
        return id_unique;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Periodes> getPeriodes_dispo() {
        return periodes_dispo;
    }

    //méthodes
    //si dates libres renvoie 1 sinon 0
    public boolean dates_libres(LocalDate debut, LocalDate fin){
        for(int i =0; i<this.periodes_dispo.size(); i++) {
            //si notre date de début < à date debut dispo et date fin > date fin dispo => impossible, periode non dispo
            if (debut.isBefore(this.periodes_dispo.get(i).getDateDebut()) || fin.isAfter(this.periodes_dispo.get(i).getDateFin())) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    //retourne un descriptif de l'hébergement
    public String Resume(){
        String resume = "Nom: " + this.nom +
                "\nAdresse: " + this.adresse +
                "\nType: " + this.type +
                "\nPrix par nuit: " + this.prix +
                "\nNombre max de personnes: " + this.nbMaxPersonne +
                "\nEquipements disponibles: ";
        for(int i=0; i<this.equipements.size(); i++){
            resume += this.equipements + ", ";
        }
        return resume;
    }

    //calcule prix total en fonction du nbr de nuits et du prix par nuit
    public double prixTotal(LocalDate debut, LocalDate fin){
        int j1= debut.getDayOfMonth();
        int j2 = fin.getDayOfMonth();
        int nb_nuits = j2-j1;
        return (this.prix*nb_nuits) ;
    }

    //ajoute une dispo
    public void Add_dispo(LocalDate debut, LocalDate fin){
        Periodes n = new Periodes(debut, fin);
        this.periodes_dispo.add(n);
    }

    //supprime une dispo
    public void Suppr_dispo(LocalDate debut, LocalDate fin){
        for(int i=0; i<this.periodes_dispo.size();i++){
            if(debut.isEqual(this.periodes_dispo.get(i).getDateDebut()) && fin.isEqual(this.periodes_dispo.get(i).getDateFin())){
                this.periodes_dispo.remove(i);
            }
        }
    }

    //ajoute une note
    public void Add_note(double newNote){
        this.notes.add(newNote);
    }

    //calcule la moyenne des notes de l'hebergement
    public void Calcul_moyenne(){
        float sum =0;
        for(int i=0; i<this.notes.size();i++){
            sum+=this.notes.get(i);
        }
        this.moyenne= sum/this.notes.size();
    }

    public void Add_Equipements(String eqpmt){
        this.equipements.add(eqpmt);
    }

    /*public static void main(String[] args){
        Hebergement h1 = new Hebergement(null);
        h1.Add_dispo(LocalDate.of(2026, 5, 15), LocalDate.of(2026, 5, 18));
        h1.Add_note(8.5);
        h1.Calcul_moyenne();
        double prixTot = h1.prixTotal(LocalDate.of(2026, 5, 15), LocalDate.of(2026, 5, 17));
        System.out.println(h1.Resume());
        System.out.println("prix total "+ prixTot);
        if(h1.dates_libres(LocalDate.of(2026, 5, 15), LocalDate.of(2026, 5, 18))){
            System.out.println("dates libres");
        }
        else{
            System.out.println("dates pas libres");
        }
        h1.Suppr_dispo(LocalDate.of(2026, 5, 15), LocalDate.of(2026, 5, 18));
    }*/
}