package main.modell;

import java.util.Date;




public class Foglalas {
    
    Date idopontok;
    private String ugyfelazonosito;
    

    
    
    

    public Foglalas(Date idopontok, String azonosito) {
        this.idopontok = idopontok;
        this.ugyfelazonosito = azonosito;
    }

    public Foglalas() {
    }
    
    

    public Date getIdopontok() {
        return idopontok;
    }
    
    
    
}
