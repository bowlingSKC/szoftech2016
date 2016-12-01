package main.kezelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.SzervizMain;
import main.modell.Foglalas;


public class FoglalasKezelo extends Kezelo {

    ArrayList foglalasok;

    public FoglalasKezelo() {
        foglalasok = new ArrayList();
    }
    
    
    public void add(Foglalas uj)
    {
        foglalasok.add(uj);
    }
    
    @Override
    public void hozzaad() {
        try
        {
            System.out.println("Uj foglalas");
            
            System.out.println("Adja meg a doglalas idopontjat: (eeee.hh.nn.)");
            String mikorra = SzervizMain.bekerSzoveg();
            String[] items = mikorra.split(".");
            String ev = items[0];
            String ho = items[1];
            String nap = items[2];
            int eev = Integer.valueOf(ev);
            int hoo = Integer.valueOf(ho);
            int naap = Integer.valueOf(nap);
            Date uj;
            uj = new Date(eev, hoo, naap);
            foglalasok.add(uj);
            
        }
        catch(Exception ep)
        {
             System.out.println(SzervizMain.HIBAUZENET);
        }
        
    }

    @Override
    public void torol() {
        
        
    }

    @Override
    public void listaz() {
        for (int i =0;i<foglalasok.size();i++)
        {
            System.out.println((i+1) + ": " + foglalasok.get(i));
        }
    }

    @Override
    public List kereses() {
        return null;
    }
    
    public void FoglalasModositas()
    {
        
    }
    
    
}
