import java.time.LocalDate;

public class Periodes {
    public LocalDate debut;
    public LocalDate fin;

    //constructeur
    public Periodes(LocalDate debut, LocalDate fin){
        this.debut= debut;
        this.fin=fin;
    }

    //methodes
    public LocalDate getDateDebut(){
        return this.debut;
    }
    public LocalDate getDateFin(){
        return this.fin;
    }
}

