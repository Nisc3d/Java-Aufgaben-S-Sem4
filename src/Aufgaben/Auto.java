package Aufgaben;

public class Auto extends Thread {
    public int nr;
    public Parkhaus parkhaus;
    public boolean eingeparkt;

    public Auto(int nr, Parkhaus parkhaus) {
        this.nr = nr;
        this.parkhaus = parkhaus;
        start();
    }

    public void run() {
        while (true) {
            try {
                sleep((long) (Math.random() * 10000));
                eingeparkt = parkhaus.rein(this);
                sleep((long) (Math.random() * 10000));
                if (eingeparkt) {
                    parkhaus.raus(this);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
