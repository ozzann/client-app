
import java.io.*;
import java.net.Socket;

/**
 * Created by asla on 06/09/2016.
 */
public class MyClient {

    public static void main(String[] args){
        while(true) {
            System.out.print("Please print server's name:");
            String input = System.console().readLine();
            String serverName;
            if (input != null && !input.isEmpty()) {
                serverName = input;
            } else {
                System.out.println("Localhost is server's name by default");
                serverName = "localhost"; // default server's name
            }

            System.out.print("Please print server's port:");
            int port = 9090;  // default
            try {
                port = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Port should be a number");
                System.out.println("Port is assgined to 9090 by default");
            }

            try {
                System.out.println("Connecting to " + serverName +
                        " on port " + port);
                Socket client = new Socket(serverName, port);
                System.out.println("Just connected to "
                        + client.getRemoteSocketAddress());

                DataInputStream in =
                        new DataInputStream(client.getInputStream());
                System.out.println("Server says " + in.readUTF());
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

