package Aufgaben;

public class Auto extends Thread {
    public int nr;
    public Parkhaus parkhaus;

    public Auto(int nr, Parkhaus parkhaus) {
        this.nr = nr;
        this.parkhaus = parkhaus;
        start();
    }

    public void run() {
        try {
            sleep(100);
            synchronized (parkhaus) {
                parkhaus.rein(this);
            }
            sleep(100);
            synchronized (parkhaus) {
                parkhaus.raus(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
