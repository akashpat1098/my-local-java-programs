
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class myServer extends Thread{
    //port
	private int Serverport;

    public ArrayList<serverWorker> workerList=new ArrayList<>();
    //constructor
    public myServer(int Serverport) {
       this.Serverport=Serverport;
	}
    public List<serverWorker> getWorkerList(){
        return workerList;
    }
    //thread method run
    @Override
    public void run() {
        try {
            ServerSocket server=new ServerSocket(Serverport);
            
            while (true) {
                System.out.println("Server Started.About to accept Client...");
                Socket socket= server.accept();
                System.out.println("Accepted connection from"+ socket);

                serverWorker worker=new serverWorker(this,socket);
                workerList.add(worker);
                worker.start();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
}
