import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Hebergement {

    //attributs
    private int id_unique;
    public String nom;
    private String adresse;
    private String ville;
    public String type;
    public int nbMaxPersonne;
    public double prix;
    public String description;
    public ArrayList<String> equipements;
    public ArrayList <Double> notes;
    public double moyenne;
    public ArrayList <Periodes> periodes_dispo;

    //constructeur
    public Hebergement(int id, String nom, String adr, String type, int nbMaxpers, double p, String d, double moyenne, String ville){
        this.id_unique=id;
        this.nom=nom;
        this.adresse=adr;
        this.ville=ville;
        this.type=type;
        this.nbMaxPersonne=nbMaxpers;
        this.prix=p;
        this.description=d;
        this.equipements= new ArrayList<>();
        this.notes=new ArrayList<>();
        this.moyenne=moyenne;
        this.periodes_dispo=new ArrayList<>();
    }

    //get
    public int getId_unique() {
        return id_unique;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Periodes> getPeriodes_dispo() {
        return periodes_dispo;
    }

    public String getVille() {
        return ville;
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
        String resume = "Description : \nNom: " + this.nom +
                "\nAdresse: " + this.adresse + this.ville +
                "\nType: " + this.type +
                "\nPrix par nuit: " + this.prix +
                "\nNombre max de personnes: " + this.nbMaxPersonne +
                "\n Moyenne du logement: " + this.moyenne +
                "\nEquipements disponibles: ";
        for(int i=0; i<this.equipements.size(); i++){
            resume += this.equipements + ", ";
        }
        return resume;
    }

    //calcule prix total en fonction du nbr de nuits et du prix par nuit
    public double prixTotal(LocalDate debut, LocalDate fin){
        int j1= debut.getDayOfYear();
        int j2 = fin.getDayOfYear();
        int nb_nuits = j2-j1;
        return (this.prix*nb_nuits);
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

    //ajoute un equipement
    public void Add_Equipements(String eqpmt){
        this.equipements.add(eqpmt);
    }
}