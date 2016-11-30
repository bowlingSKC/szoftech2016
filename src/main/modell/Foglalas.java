package main.modell;
import java.util.ArrayList;
import java.util.Date;

public class Foglalas {
    
    private ArrayList idopontok;

    public Foglalas() {
        idopontok = new ArrayList();
    }
    
    
    public void add(Date ido)
    {
        idopontok.add(ido);
    }
}
