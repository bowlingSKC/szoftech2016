package main.modell.aktor;

import java.io.Serializable;

public class Recepcios extends Alkalmazott implements Serializable {

    public Recepcios() {
    }

    public Recepcios(String szemszam, String nev, String jelszo, String email, int oraber) {
        super(szemszam, nev, jelszo, email, oraber);
    }
}
