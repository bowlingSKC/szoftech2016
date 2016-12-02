package main.modell;

public class Auto {
    private String rendszam;
    private String marka;
    private String tipus;
    
    
    public Auto() {
        
        
    }

    
    public Auto(String rendszam, String marka, String tipus) {
        this.rendszam = rendszam;
        this.marka = marka;
        this.tipus = tipus;
    }
    
    

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    @Override
    public String toString()
    {
        return "Rendszam: " + rendszam + "\n\tMarka: " + marka + "\n\tTipus: " + tipus;
    }
    
}
