package Beispiele;

class Clerk extends Thread // Angestellte/r als Thread
{
    private Bank bank;
    // Warum fehlt hier name ?
    // kommt aus Klasse Thread !

    public Clerk(String name, Bank bank) {
        super(name);
        this.bank = bank;
        //Start des Threads bei Erstellung des Objekts
        start();
    }

    public void run() {
        // 10000 Umbuchungen durch 1 Angestellte/n

        for (int i = 0; i < 10000; i++) {
            /*Kontonummer ermitteln; durch Wahl
            einer Zufallszahl zwischen 0 und 99 */
            int accountNumber = (int) (Math.random() * 100);
            /*
             Überweisungsbetrag einlesen; simuliert durch
             Wahl einer Zufallszahl zwischen -500 und +499
            */

            float amount = (int) (Math.random() * 1000) - 500;
            System.out.println(i + " Konto: " + accountNumber + " Betrag: " + amount);

            bank.transferMoney(accountNumber, amount);
        }
    }
}