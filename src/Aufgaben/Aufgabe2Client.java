package Aufgaben;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Aufgabe2Client {

    Aufgabe2Client(int anzahlZahlen, int zahl1, int zahl2, int zahl3, int zahl4, int operation) throws IOException{
        Socket server = new Socket("localhost", 1234);
        InputStream input = server.getInputStream();
        OutputStream output = server.getOutputStream();
        output.write(anzahlZahlen);
        output.write(zahl1);
        output.write(zahl2);
        output.write(zahl3);
        output.write(zahl4);
        output.write(operation);
        output.flush();
        System.out.println(input.read());
        server.close();
        input.close();
        output.close();
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wie viele Zahlen sollen benutzt werden?");
            int anzahlZahlen = scanner.nextInt();
            if (anzahlZahlen == 1){
                System.out.println("Zahl1: ");
                int zahl1 = scanner.nextInt();
            }else if (anzahlZahlen == 2){

            }
            System.out.println("Zahl1: ");
            int zahl1 = scanner.nextInt();
            System.out.println("Zahl2: ");
            int zahl2 = scanner.nextInt();
            System.out.println("Zahl3: ");
            int zahl3 = scanner.nextInt();
            System.out.println("Zahl4: ");
            int zahl4 = scanner.nextInt();
            System.out.println("Rechenoperation (1 = +, 2 = -, 3 = *, 4= /): ");
            int operation = scanner.nextInt();

            Aufgabe2Client client = new Aufgabe2Client(anzahlZahlen, zahl1, zahl2, zahl3, zahl4, operation);

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
