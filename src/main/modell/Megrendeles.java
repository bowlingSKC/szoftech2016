package main.modell;

import java.util.ArrayList;
import java.util.List;

public class Megrendeles {
    
    private int azonosito;
    private int partazon;
    private int darab;
    private int koltseg;
    private ArrayList<Alkatresz> alkatreszek;

    //konstruktor úgy van megírva, hogy alkatrész listát is vár
    public Megrendeles(int azonosito, int partazon, int darab, int koltseg, List<Alkatresz> alkatreszek) {
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

    public void getMegrendeles()
    {
        System.out.println("Azonosito: " + azonosito);
        System.out.println("Koltseg: " + koltseg);
        System.out.println("Megrendelt alkatreszek:");
        for(int i = 0; i < alkatreszek.size(); i++)
        {
            System.out.println(alkatreszek.get(i).getNev());
            System.out.println(alkatreszek.get(i).getCikkszam());
            System.out.println(alkatreszek.get(i).getMarka());
            System.out.println(alkatreszek.get(i).getTipus());
            System.out.println(alkatreszek.get(i).getBeszerzesiar());
            System.out.println(alkatreszek.get(i).getEladasiAr());
        }
    }

    
    
}
