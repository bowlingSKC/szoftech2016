
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


public class Raktar extends Kezelo<Alkatresz> {
    
   
    
    
    @Override
    public void hozzaad() { //nincs teljesen megírva
         Alkatresz alkatresz = new Alkatresz();
        try {
            System.out.println("A termek cikkszama: ");
            alkatresz.setCikkszam(SzervizMain.bekerSzam());
            System.out.println("A termek markaja: ");
            alkatresz.setMarka(SzervizMain.bekerSzoveg());
            System.out.println("A termek neve: ");
            alkatresz.setNev(SzervizMain.bekerSzoveg());
            System.out.println("A termek tipusa: ");
            alkatresz.setTipus(SzervizMain.bekerSzoveg());
            System.out.println("A termek eladasi ara: ");
            alkatresz.setEladasiAr(SzervizMain.bekerSzam());
            System.out.println("A termek beszerzesi ara: ");
            alkatresz.setBeszerzesiar(SzervizMain.bekerSzam());
            
            
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
           Alkatresz a =  egyedek.get(i);
            System.out.println("A termek cikkszama: " + a.getCikkszam());
            System.out.println("A termek markaja: " + a.getMarka());
            System.out.println("A termek neve: " + a.getNev());
            System.out.println("A termek tipusa: " + a.getTipus());
            System.out.println("A termek beszerzesi ara: " + a.getBeszerzesiar());
            System.out.println("A termek eladasi ara: " + a.getEladasiAr());
            System.out.println();
            
        }
    }

    @Override
    public List<Alkatresz> kereses() {
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
                    Alkatresz a = egyedek.get(i);
                    if(a.getCikkszam()== id) {
                        exist=true;   
                    }
                    if(exist) {
                        return (List) egyedek.get(id);
                    } else {
                        return (List) egyedek.get(id);
                    }
                }    
            break;
            case 2:
                System.out.println("Adja meg a nevet: ");
                String nev = bekerSzoveg();
                id=0;
                for(int i=0;i<this.egyedek.size();i++) {
                    Alkatresz a = egyedek.get(i);
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
