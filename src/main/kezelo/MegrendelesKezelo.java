package main.kezelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.SzervizMain;
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
        
        hossz++; //megrendelesazonosito
        
        
        
        int partaz;
        
        int koltseg = 0;
        ArrayList<Tetel> tetelek = new ArrayList<>();
        Tetel egytetel;
        egytetel = new Tetel();
        try {
            System.out.println("Tetel megnevezese:");
            egytetel.setMegnevezes(SzervizMain.bekerSzoveg());
            System.out.println("Kerem adja meg az alkatresz cikszamat: ");
            egytetel.setAlkatresz(raktar.getAlkatresz(SzervizMain.bekerSzam())); //cikszám
            System.out.println("Adja meg az alkatresz darabszamat: ");
            egytetel.setDarabalkatresz(SzervizMain.bekerSzam());
            System.out.println("Tetel leirasa:");
            egytetel.setLeiras(SzervizMain.bekerSzoveg());
            tetelek.add(egytetel);
            System.out.println("Partnerazonosito: ");
            partaz = SzervizMain.bekerSzam();
            for(int i = 0; i < tetelek.size(); i++)
            {
                koltseg = (tetelek.get(i).getDarabalkatresz())*(egytetel.getAlkatresz().getBeszerzesiar());
            }
            Megrendeles uj = new Megrendeles(hossz,partaz,koltseg,tetelek);
            egyedek.add(uj);
        
        } catch (IOException ex) {
            System.out.println(SzervizMain.HIBAUZENET);
        }
       
        
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
