// import java.net.ServerSocket;
// import java.net.Socket;

import java.io.*;
import java.net.*;

public class Server  {
   
    public static void main(String[] args) {
        try  {
            //conection is established here
            //serversocket is started
        ServerSocket server=new ServerSocket(4000);
        System.out.println("Server is Started");
        System.out.println("Waiting for Client...");
                //socket is created
        Socket socket=server.accept();
        System.out.println("Client is Connected");
                //taking input from server
        BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line="";
        line=input.readLine();
        System.out.println("Client says:"+ line);
                //sending output from client
        PrintStream out=new PrintStream(socket.getOutputStream(),true);
        out.println(line);
                //closing all connection
        socket.close();
        server.close();
       } 
       catch (Exception e) {
           System.out.println(e);
       } 

    }
}
