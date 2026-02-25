public class Hebergement {

    public String identifiant;
    public String nom;
    public String adresse;
    public String type;
    public int nbMaxPersonne;
    public int prix;
    public String description;
    public String[] equipements;

    public Hebergement(){
        this.identifiant=null;
        this.nom=null;
        this.adresse=null;
        this.type=null;
        this.nbMaxPersonne=0;
        this.prix=0;
        this.description=null;
        this.equipements=null;
    }

    //méthodes
    //si dates libres renvoie 1 sinon 0
    public int dates_libres(){

        return 0;
    }

    public void Resume(){}//affiche les infos?

    public int prixTotal(){return 0;}

    public void Add_dispo(){}

    public void Suppr_dispo(){}

    public void Add_note(){}
}