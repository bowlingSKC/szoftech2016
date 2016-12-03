
package main.kezelo;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static main.MenuKiiro.keresesMenuKiir;
import main.modell.Alkatresz;
import main.SzervizMain;
import static main.SzervizMain.bekerSzam;
import static main.SzervizMain.bekerSzoveg;


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
        boolean exist=false;
        if(this.egyedek.isEmpty()) {
            System.out.println("Nincs elem a raktarban!");
            return null;
        }
        keresesMenuKiir();
        int input;
        try {
            input = bekerSzam();
            switch (input) {
            case 1: 
                System.out.println("Adja meg a cikkszamot: ");
                int id = bekerSzam();
                for(int i=0;i<this.egyedek.size();i++) {
                    Alkatresz a = (Alkatresz) egyedek.get(i);
                    if(a.getCikkszam()== id) {
                        exist=true;   
                    }
                    if(exist) {
                        return (List) this.egyedek.get(id);
                    } else {
                        return (List) this.egyedek.get(id);
                    }
                }    
            break;
            case 2:
                System.out.println("Adja meg a nevet: ");
                String nev = bekerSzoveg();
                id=0;
                for(int i=0;i<this.egyedek.size();i++) {
                    Alkatresz a = (Alkatresz) egyedek.get(i);
                    if(a.getNev().equalsIgnoreCase(nev)) {
                        exist=true;
                        id=i;
                    }
                    if(exist) {
                        return (List) this.egyedek.get(id);
                    } else {
                        return (List) this.egyedek.get(id);
                    }
                }    
            break;
        }
        } catch (IOException ex) {
            Logger.getLogger(Raktar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
