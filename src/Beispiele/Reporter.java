package Beispiele;

import java.io.*;
import java.net.*;

public class Reporter {
    private int port;
    private String file;

    public Reporter(int port, String file) {
        this.port = port;
        this.file = file;
    }

    public void doWork() {
        ServerSocket server = null;
        Socket client = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            server = new ServerSocket(port);
            client = server.accept();

            in = client.getInputStream();
            out = new FileOutputStream(file);

            // Timeout, da die Leseschleife nicht beendet wird.
            client.setSoTimeout(3000);

            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }

        catch (IOException e) {
            System.err.println(e);
        }

        finally {
            try {
                if (in != null)
                    in.close();
                if (out != null) {
                    out.flush();
                    out.close();
                }
                if (client != null)
                    client.close();
                if (server != null)
                    server.close();
            }
            catch (IOException e) { }
        }
    }


    public static void main(String[] args) {

//  <file> mit komplettem Pfad –
//  eingeschlossen in doppelte Hochkommas
// z.B. 12345 “C:\\Sander\\Vorlesungen\\test.txt“

        if (args.length != 2) {
            System.err.println("java Reporter <port> <file>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        String file = args[1];
        new Reporter(port, file).doWork();
    }
}