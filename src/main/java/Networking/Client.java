package Networking;

import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try
        {
            kkSocket = new Socket("192.168.0.15", 1000);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            System.out.println("Connected!");
        } catch (UnknownHostException e)

        {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null)
        {
              System.out.println(processOutput(fromServer));
            System.out.print("---->");
            if (fromServer.equals("Bye."))
                break;

            fromUser = stdIn.readLine();
            if (fromUser != null)
            {
                out.println(fromUser);
            }
        }

        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
    private static String processOutput(String input)
    {
        String output;
        output = "";
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) != '|')
            {
                output+=input.charAt(i);
            }
            else
            {
                output+="\n";
            }
        }
        return output;
    }
}