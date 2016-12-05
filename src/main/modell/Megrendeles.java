package main.modell;

import java.util.ArrayList;

public class Megrendeles {
    
    private int azonosito;
    private int partazon;
    
    private int koltseg;
    private ArrayList<Tetel> soktetel;
    
    

    public Megrendeles() {
        
        
    }
    
    

    //konstruktor úgy van megírva, hogy alkatrész listát is vár
    public Megrendeles(int azonosito, int partazon, int koltseg, ArrayList<Tetel> soktetel) {
        this.azonosito = azonosito;
        this.partazon = partazon;
        
        this.koltseg = koltseg;
        this.soktetel = soktetel;
    }

    
    
    
    public int getAzonosito() {
        return azonosito;
    }

    public int getKoltseg() {
        return koltseg;
    }

    public void kiirMegrendeles()
    {
       
            System.out.println("Azonosito: " + azonosito);
            System.out.println("Koltseg: " + koltseg);
            System.out.println("Megrendelt alkatreszek:");
         for(int i = 0; i < soktetel.size(); i++)
        {
            System.out.println("Db: " + soktetel.get(i).getDarabalkatresz());
            System.out.println("Megnevezes: " + soktetel.get(i).getMegnevezes());
            System.out.println("Cikkszam: " + soktetel.get(i).getAlkatresz().getCikkszam());
            System.out.println("Marka: " + soktetel.get(i).getAlkatresz().getMarka());
            System.out.println("Tipus: " + soktetel.get(i).getAlkatresz().getTipus());
            System.out.println("Beszerzesiar: " + soktetel.get(i).getAlkatresz().getBeszerzesiar());
            System.out.println("Eladasiar: " + soktetel.get(i).getAlkatresz().getEladasiAr());
        }
    }

    
    
}
