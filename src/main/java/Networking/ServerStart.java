package Networking;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerStart {

    public static void startServer() throws IOException {

        ServerSocket serverSocket = null;
        boolean listening = true;
        final short port = 1000;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e)

        {
            System.out.println("Could not listen to port.");
        }

        while (listening)
            new MultiServerThread(serverSocket.accept()).start();
            serverSocket.close();
        }

        public static void main(String[] args){
            try {
                startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


