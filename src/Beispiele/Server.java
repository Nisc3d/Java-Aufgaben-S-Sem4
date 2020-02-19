package Beispiele;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server = new ServerSocket(1234);

    Server() throws IOException{
        while (true){
            Socket client = server.accept();
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            int zahl1 = input.read();
            int zahl2 = input.read();
            output.write(zahl1 + zahl2);
            output.flush();
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
