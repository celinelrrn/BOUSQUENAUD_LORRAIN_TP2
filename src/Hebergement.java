public class Hebergement {
    //mettre en privé?? pour sécurité?? jsp
    public String identifiant;
    public String nom;
    public String adresse;
    public String type;
    public int nbMaxPersonne;
    public int prix;
    public String description;
    public String[] equipements;

    //méthodes
    //si dates libres renvoie 1 sinon 0
    public int dates_libres(){

        return 0;
    }

    public void Resume(){}//affcihe les infos?

    public int prixTotal(){return 0;}

    public void Add_dispo(){}

    public void Suppr_dispo(){}

    public void Add_note(){}
}