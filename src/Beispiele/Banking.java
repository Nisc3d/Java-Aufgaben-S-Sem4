package Beispiele;

public class Banking {
    public static void main(String[] args) {
        // 2 Angestellte aus der gleichen Bank anlegen

        Bank myBank = new Bank();
        new Clerk("Andrea Müller", myBank);
        new Clerk("Petra Schmitt", myBank);
    }
}