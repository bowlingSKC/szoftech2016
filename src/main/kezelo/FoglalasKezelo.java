package main.kezelo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.SzervizMain;
import main.modell.Foglalas;

public class FoglalasKezelo extends Kezelo {

    private List<Foglalas> foglalasok;

    public FoglalasKezelo() {
        foglalasok = new ArrayList<>();
    }

    public void add(Foglalas uj) {
        foglalasok.add(uj);
    }

    @Override
    public void hozzaad() {
        try {
            System.out.println("Uj foglalas");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.dd HH:mm");
            System.out.println("Adja meg a doglalas idopontjat: (eeee.hh.nn hh:mm)");
            String mikorra = SzervizMain.bekerSzoveg();
            
            Foglalas uj;
            uj = new Foglalas(sdf.parse(mikorra));
            foglalasok.add(uj);

        } catch (IOException ep) {
            System.out.println(SzervizMain.HIBAUZENET);
        } catch (ParseException ex) {
            Logger.getLogger(FoglalasKezelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void torol() {
        try {
            
            System.out.println("Adja meg torolni valo idopontot: (eeee.hh.nn.)");
            listaz();
            int azon = SzervizMain.bekerSzam(); //println-t megírni
           
            foglalasok.remove(azon-1);

        }
        catch(Exception e)
        {
            System.out.println(SzervizMain.HIBAUZENET);
        }

    }

    @Override
    public void listaz() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.dd HH:mm");
            String dateString;
            for (int i = 0; i < foglalasok.size(); i++) {
                
                dateString = sdf.format(foglalasok.get(i).getIdopontok());
                System.out.println((i + 1) + ": " + dateString);
            }
       
    }

    @Override
    public List kereses() {
        
        return null;
    }

    public void FoglalasModositas() {
        torol();
        //pár dolog, hogy mit adjon hozzá
        hozzaad();
    }
}
