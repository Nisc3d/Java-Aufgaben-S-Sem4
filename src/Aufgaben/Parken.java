package Aufgaben;

public class Parken {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(10);
        for(int i = 0; i < 10; i++){
            new Auto(i, parkhaus);
        }
    }
}
