package main.modell.aktor;

import java.io.Serializable;

public class Tulajdonos extends Alkalmazott implements Serializable {

    public Tulajdonos() {
    }

    public Tulajdonos(String szemszam, String nev, String jelszo, String email, int oraber) {
        super(szemszam, nev, jelszo, email, oraber);
    }
}
