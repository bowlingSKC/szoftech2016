
package main.kezelo;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.modell.Alkatresz;
import main.SzervizMain;


public class Raktar extends Kezelo {
    
   
    
    
    @Override
    public void hozzaad() { //nincs teljesen megírva
         Alkatresz alkatresz = new Alkatresz();
        try {
            alkatresz.setCikkszam(SzervizMain.bekerSzam());
            alkatresz.setBeszerzesiar(alkatresz.getCikkszam());
            
        } catch (IOException ex) {
             System.out.println(SzervizMain.HIBAUZENET);
        }
        egyedek.add(alkatresz);
    }

    @Override
    public void torol() {}

    @Override
    public void listaz() {
        for(int i = 0; i < egyedek.size(); i++)
        {
           Alkatresz a =  (Alkatresz) egyedek.get(i);
            System.out.println(a.getCikkszam());
        }
    }

    @Override
    public List kereses() {
        return null;
    }

    
    public Alkatresz getAlkatresz(int cikkszam)
    {
        for(int i = 0; i< egyedek.size();i++)
            if(((Alkatresz)egyedek.get(i)).getCikkszam() == cikkszam)
            {
                return (Alkatresz)egyedek.get(i);
            }
        return null;
    }
    
    
}
