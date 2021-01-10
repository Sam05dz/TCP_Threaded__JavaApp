import java.io.*;
import java.net.*;

public class Client {
   static final int port = 9999;

   public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", port);
        System.out.println("SOCKET = " + socket);

        BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

        String str = "bonjour";

        while(true){
          
            for (int i = 1; i < 10; i++) { 

           System.out.println(plec.readLine()); 
           pred.println(str+" "+i);
          
           }
           System.out.println(plec.readLine()");
        
        
        }
        
        
   }
}