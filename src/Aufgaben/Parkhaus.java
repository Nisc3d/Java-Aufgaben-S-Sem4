package Aufgaben;

public class Parkhaus {
    public Auto[] plaetze;

    public Parkhaus(int anzahlplaetze) {
        plaetze = new Auto[anzahlplaetze];
    }

    public void rein(Auto auto) {
        int i = 0;
        int freierplatz = -1;
        
        //Prüfen ob Platz frei ist
        while (i < plaetze.length) {
            if (plaetze[i] == null) {
                freierplatz = i;
            }
            i += 1;
        }
        
        //Wenn Platz frei ist einparken
        if (freierplatz != -1){
            plaetze[freierplatz] = auto;
            System.out.println("Auto " + auto.nr + " steht nun auf Platz " + freierplatz);
        }
    }

    public void raus(Auto auto) {
        int i = 0;
        int standplatz = 100;
        //Schauen an welchem Platz das Auto steht
        while (i < plaetze.length){
            if (auto.equals(plaetze[i])){
                standplatz = i;
            }
        }
        
        //Auto ausparken
        plaetze[standplatz] = null;
        System.out.println("Auto " + auto.nr + " ausgeparkt");
    }
}

