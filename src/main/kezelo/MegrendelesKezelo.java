package main.kezelo;

import java.util.ArrayList;
import java.util.List;
import main.modell.Megrendeles;

public class MegrendelesKezelo extends Kezelo {

    ArrayList<Megrendeles> megrendelesek;
    
    @Override
    public void hozzaad() {
        System.out.println("=========Megrendeles felvetele=========");
        
    }

    @Override
    public void torol() {
        
    }

    @Override
    public void listaz() {
        
        System.out.println("Folyamatban levo megrendelesek:");
        for(int i = 0; i < megrendelesek.size(); i++)
        {
            megrendelesek.get(i).getMegrendeles();
        }
        
    }

    @Override
    public List kereses() {
        return null;
    }
    
}
