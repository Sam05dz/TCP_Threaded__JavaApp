import java.io.*;
import java.net.*;

public class Serveur extends Thread{
    int port = 9999;
    @Override
    public void run(){
        try {
            ServerSocket s = new ServerSocket(port);
            while(true){
                Socket soc =s.accept();
                new Client(soc).start();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }
    
    class Client extends Thread{
        private Socket socket;
        public Client(Socket socket) {
           
            this.socket = socket;
           
        }

                
         @Override
        public void run(){
            try {
              
            	BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pred = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                
                String IP = socket.getRemoteSocketAddress().toString();
                System.out.println("Connection d'un Client avec l'IP "+ IP);
                pred.println("Bienvenue");
                
                while(true){
                	String request ;
                	
                	while((request=plec.readLine())!=null){

                	System.out.println(request+ " recu.");  
                    String response="Message Recu";
                    pred.println(response);
                    
                   }
                    }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
	  
           
        }
    }
    public static void main(String[] args) throws Exception {
      new Serveur().start();
      System.out.println("Serveur demarrer.");
      
    }
    
}
