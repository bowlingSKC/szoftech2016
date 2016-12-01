package main.modell;
import java.util.Date;

public class Foglalas {
    
    Date idopontok;

    public Foglalas(int ev, int ho, int nap) {
        idopontok = new Date(ev,ho,nap);
       
    }

    public Foglalas(Date idopontok) {
        this.idopontok = idopontok;
    }

    public Date getIdopontok() {
        return idopontok;
    }
    
    
    
}
