package main.kezelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.modell.Alkatresz;
import main.modell.Megrendeles;
import main.modell.Tetel;

public class MegrendelesKezelo extends Kezelo {

   
    
    Raktar raktar;

    public MegrendelesKezelo(Raktar raktar) {
       this.raktar = raktar;
    }
    @Override
    public void hozzaad() {
        raktar.listaz();
        System.out.println("=========Megrendeles felvetele=========");
        int hossz = egyedek.size();
        
        hossz++; //azonosito
        
        
        
        int partaz = 1;
        int darab = 5;
        int koltseg = 0;
        ArrayList<Tetel> tetelek = new ArrayList<>();
        Tetel egytetel;
        egytetel = new Tetel();
        egytetel.setMegnevezes("kuplung");
        egytetel.setAlkatresz(raktar.getAlkatresz(5)); //cikszám
        tetelek.add(egytetel);
        Megrendeles uj = new Megrendeles(hossz,partaz,koltseg,tetelek);
        egyedek.add(uj);
        
        
    }

    @Override
    public void torol() {
        
    }

    @Override
    public void listaz() {
        
        System.out.println("Folyamatban levo megrendelesek:");
        for(int i = 0; i < egyedek.size(); i++)
        {
           Megrendeles a =  (Megrendeles) egyedek.get(i);
            a.kiirMegrendeles();
        }
        
    }

    @Override
    public List kereses() {
        return null;
    }
    
}
