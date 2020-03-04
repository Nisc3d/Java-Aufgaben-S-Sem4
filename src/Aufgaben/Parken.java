package Aufgaben;

public class Parken {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(10);
        //15 Autos erzeugen
        for(int i = 0; i < 25; i++){
            new Auto(i, parkhaus);
        }
    }
}
