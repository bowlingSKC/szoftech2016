package main.modell;

import java.util.ArrayList;

public class Megrendeles {
    
    private int azonosito;
    private int partazon;
    private int darab;
    private int koltseg;
    private ArrayList<Alkatresz> alkatreszek;

    public Megrendeles(int azonosito, int partazon, int darab, int koltseg) {
        this.azonosito = azonosito;
        this.partazon = partazon;
        this.darab = darab;
        this.koltseg = koltseg;
        alkatreszek = new ArrayList();
    }

    
    
    
    public int getAzonosito() {
        return azonosito;
    }

    public int getKoltseg() {
        return koltseg;
    }

    
    
}
