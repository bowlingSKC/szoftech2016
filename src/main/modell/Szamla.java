package main.modell;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Szamla {

    private Date kiallitasDatuma = new Date();
    private String ugyfelNev;
    private int osszeg;

    public Date getKiallitasDatuma() {
        return kiallitasDatuma;
    }

    @Override
    public String toString() {
        return "Ugyfel: " + ugyfelNev + ", kiallitas datuma: " + new SimpleDateFormat("yyyy-MM-dd").format(kiallitasDatuma) + ", ar: " + osszeg + " Ft";
    }

    public void setKiallitasDatuma(Date kiallitasDatuma) {
        this.kiallitasDatuma = kiallitasDatuma;
    }

    public String getUgyfelNev() {
        return ugyfelNev;
    }

    public void setUgyfelNev(String ugyfelNev) {
        this.ugyfelNev = ugyfelNev;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }
}
