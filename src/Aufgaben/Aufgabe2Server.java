package Aufgaben;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Aufgabe2Server {
    ServerSocket server = new ServerSocket(1234);

    Aufgabe2Server() throws IOException{
        while (true){
            Socket client = server.accept();
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            int anzahlZahlen = input.read();

            int zahl1 = input.read();
            int zahl2 = input.read();
            int zahl3 = input.read();
            int zahl4 = input.read();
            int operation = input.read();
            String serveroperation = null;
            if (operation == 1){
                output.write(zahl1 + zahl2 + zahl3 + zahl4);
            }else if(operation == 2){
                output.write(zahl1 - zahl2 - zahl3 - zahl4);
            }else if (operation == 3){
                output.write(zahl1 + zahl2 * zahl3 * zahl4);
            }else if (operation == 4 ){
                output.write(zahl1 / zahl2 / zahl3 / zahl4);
            }
            output.flush();
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) {
        try {
            Aufgabe2Server server = new Aufgabe2Server();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
