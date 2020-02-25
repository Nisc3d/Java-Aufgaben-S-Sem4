package Aufgaben;

public class Auto extends Thread {
    int nr;
    Parkhaus parkhaus;

    public Auto(int nr, Parkhaus parkhaus) {
        this.nr = nr;
        this.parkhaus = parkhaus;
        start();
    }

    public void run() {
        try {
            sleep(100);
            parkhaus.rein(this);
            sleep(100);
            parkhaus.raus(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
