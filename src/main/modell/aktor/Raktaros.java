package main.modell.aktor;

import java.io.Serializable;

public class Raktaros extends Alkalmazott implements Serializable {

    public Raktaros() {
    }

    public Raktaros(String szemszam, String nev, String jelszo, String email, int oraber) {
        super(szemszam, nev, jelszo, email, oraber);
    }
}
