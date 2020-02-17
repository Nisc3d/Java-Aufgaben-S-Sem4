package Beispiele;

import java.net.*;

public class NameServerTest {
    public static void main(String[] args) {
        try {
            String host = "www.dhbw-stuttgart.de";

            // Erfragen der IP-Adresse der DHBW Stuttgart
            InetAddress adresse = InetAddress.getByName(host);

            System.out.println(host + " hat die IP-Adresse " + adresse.getHostAddress());

            host = "www.google.de";

            // Alle IP-Adressen erfragen, unter denen der
            // Server www.google.de erreichbar ist
            InetAddress[] alleAdressen = InetAddress.getAllByName(host);

            System.out.println(host + " ist unter folgenden " + "IP-Adressen erreichbar:");

            for (InetAddress a : alleAdressen) {
                System.out.println("\t" + a.getHostAddress());
            }

            // Die lokale Adresse nachfragen:
            InetAddress lokaleAdresse = InetAddress.getLocalHost();

            System.out.println("Die IP-Adresse dieses Rechners lautet " + lokaleAdresse.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.print("Adresse ist nicht ermittelbar: ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
} 