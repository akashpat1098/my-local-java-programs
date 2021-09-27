// import java.io.BufferedReader;
// import java.io.InputStream;
// import java.io.PrintStream;
// import java.net.Socket;


// import jdk.internal.org.jline.utils.InputStreamReader;
import java.io.*;
import java.net.*;

public class Client {
      
     public static void main(String[] args) {
        try {
            //socket is created and giving detail
            Socket socket=new Socket("localhost",4000);
            System.out.println("Connected");
            //taking input from keyboard
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the String");
        String line="";
        line=input.readLine();
        // sending data to server
        PrintStream out=new PrintStream(socket.getOutputStream(),true);
        out.println(line);
        //now taking data from server
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server says"+ in.readLine());
                //closing connection
        socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
}
