package main;

import main.modell.Auto;
import main.modell.Munkalap;
import main.modell.aktor.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FajlKezelo {

    private static final String USER_FILE_PATH = "felhasznalok.dat";
    private static final String WORKSHEET_FILE_PATH = "munkalapok.dat";

    public static void feltolt() {
        ArrayList<Felhasznalo> felhasznalok = new ArrayList<>();
        felhasznalok.add(new Raktaros("123456SA", "Raktaros Robi", "pswd", "robi@szerviz.com", 870));
        felhasznalok.add(new Raktaros("785648SA", "Toth Janos", "pswd", "janos@szerviz.com", 900));
        felhasznalok.add(new Recepcios("456784SA", "Recepcios Roberta", "pswd", "reci@szerviz.com", 850));
        felhasznalok.add(new Szerelo("568684SA", "Szerelo Szilveszter", "pswd", "szilveszter@szerviz.com", 1200));

        Szerelo szerelo = new Szerelo("648648SA", "Sz. Nagy Szabolcs", "pswd", "szabi@szerviz.com", 1350);
        felhasznalok.add(szerelo);
        felhasznalok.add(new Tulajdonos("648568KJ", "Sipeki Elvira", "pswd", "elvira@szerviz.com", 3500));

        Ugyfel ugyfel1 = new Ugyfel("645273TH", "Barna Bettina", "pswd", "bbetti@gmail.com", 10000);
        ugyfel1.getAutok().add(new Auto("MLH-001", "Reanult", "Thalia"));
        ugyfel1.getAutok().add(new Auto("AAA-124", "BMW", "Indicidual"));
        felhasznalok.add(ugyfel1);

        Ugyfel ugyfel2 = new Ugyfel("273537HU", "Kovacs David", "pswd", "kde@gmail.com", 23000);
        ugyfel2.getAutok().add(new Auto("EHT-363", "Opel", "Astra"));
        felhasznalok.add(ugyfel2);

        felhasznalokMent(felhasznalok);

        Munkalap m1 = new Munkalap();
        m1.setAuto(ugyfel1.getAutok().get(0));
        m1.setAzonosito(23232);
        m1.setHibaleiras("Bal elso index nem villog");
        m1.setIdo(1);
        m1.setSzerelo(szerelo);

        Munkalap m2 = new Munkalap();
        m2.setAuto(ugyfel2.getAutok().get(0));
        m2.setAzonosito(23232);
        m2.setHibaleiras("Erosen fog a fek");
        m2.setIdo(3);
        m2.setSzerelo(szerelo);

        ArrayList<Munkalap> munkalaok = new ArrayList<>();
        munkalaok.add(m1);
        munkalaok.add(m2);
        munkalapokMent(munkalaok);
    }

    public static void felhasznalokMent(List<Felhasznalo> felhasznalok) {
        try {
            FileOutputStream fos = new FileOutputStream(USER_FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject( felhasznalok );
            fos.close();
        } catch (Exception ex) {
            System.out.println("Hiba tortent az adatok kiirasa kozben!");
        }
    }

    public static void munkalapokMent(List<Munkalap> munkalapok) {
        try {
            FileOutputStream fos = new FileOutputStream(WORKSHEET_FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject( munkalapok );
            fos.close();
        } catch (Exception ex) {
            System.out.println("Hiba tortent az adatok kiirasa kozben!");
        }
    }

    public static ArrayList<Felhasznalo> felhasznalokBeolvas() {
        try {
            FileInputStream fis = new FileInputStream(USER_FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Felhasznalo>) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Nem sikerult az adatok beolvasasa!");
            return new ArrayList<>();
        }
    }

    public static ArrayList<Munkalap> munkalapokBeolvas() {
        try {
            FileInputStream fis = new FileInputStream(WORKSHEET_FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Munkalap>) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Nem sikerult az adatok beolvasasa!");
            return new ArrayList<>();
        }
    }

}
