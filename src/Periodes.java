import java.time.LocalDate;

public class Periodes {
    private LocalDate debut;
    private LocalDate fin;

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

