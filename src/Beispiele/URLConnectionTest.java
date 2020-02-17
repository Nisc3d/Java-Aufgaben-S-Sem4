package Beispiele;

import java.net.*;
import java.io.*;

public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            // Erzeugen einer URL
            URL url = new URL("http://www.dhbw-stuttgart.de");

            // Verbindung zur Ressource bereitstellen
            URLConnection connection = url.openConnection();

            System.out.println("Typ des URLConnection-Objekts:");
            System.out.println(connection.getClass());
            // Verbindung herstellen
            connection.connect();
            // Auslesen der HTTP-Version
            System.out.print("\nVersion des HTTP-Protokolls: ");
            System.out.println(connection.getHeaderField(0));
            // Typ der abrufbaren Daten erfragen
            System.out.print("\nTyp der Daten: ");
            System.out.println(connection.getContentType());
        } catch (NullPointerException e) {
            // Exception, wenn der Verbindungsaufbau nicht funktioniert
            System.out.println(e.getMessage());
        } catch (MalformedURLException e) {
            // Exception, wenn der übergebene String
            // keine gültige URL darstellt.

            System.out.println(e.getMessage());
        } catch (IOException e) {
            // Die Methoden openURLConnection() und connect()
            // werfen beide Exceptions vom Typ IOException
            System.out.println(e.getMessage());
        }
    }
}
