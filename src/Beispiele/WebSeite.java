package Beispiele;

import java.io.*;
import java.net.*;

public class WebSeite {
    private int port;

    // port in Konstruktor übergeben
    public WebSeite(int port) {
        this.port = port;
    }

    public void doWork() {
// Sockets für client und server
// sowie InputStream in deklarieren
        ServerSocket server = null;
        Socket client = null;
        InputStream in = null;

        try {
// ServerSocket anlegen und Server “aktiv” setzen
            server = new ServerSocket(port);
            client = server.accept();

// InputStream und OutputStream
// (als PrintWriter) bereitstellen
            in = client.getInputStream();
            PrintWriter out = new PrintWriter(client.getOutputStream());

// Timeout, da die Leseschleife nicht beendet wird.
            client.setSoTimeout(3000);

// (sehr triviale) HTML-Seite mit Steuerinformationen
// zu HTTP-Version und erfolgreicher Datenübertragung
// an client zurücksenden
// Trennung zwischen Steuerinformation und Nutzdaten
// durch Leerzeile
            out.println("HTTP/1.1 200 OK\n\r\n\r<b>Hallo</b>");
            out.flush();

// “Verwaltungsinformationen” vom Client abarbeiten
            int c;
            while ((c = in.read()) != -1)
            {System.out.print((char) c);}

        }
        catch (IOException e) {
            System.err.println(e);
        }
        finally {
            try {

// alle verwendeten Ströme schließen
                if (in != null)
                    in.close();
                if (client != null)
                    client.close();
                if (server != null)
                    server.close();
            }

            catch (IOException e) { }
        }
    }

    public static void main(String[] args) {
// Fehlermeldung, falls falsche Parameterzahl
        if (args.length != 1) {
            System.err.println("java WebSeite <port>");
            System.exit(1);
        }

// vor Programmstart übergebene Portnummer lesen
        int port = Integer.parseInt(args[0]);

// Seite darstellen
        new WebSeite(port).doWork();
    }
}
