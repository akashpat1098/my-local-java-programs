import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class serverWorker extends Thread {

    private Socket socket;
    private String login=null;
    private myServer server;
    private OutputStream out;

    public serverWorker(myServer myServer, Socket socket) {
        this.socket=socket;
        this.server=myServer;

    }
    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   
    private  void handleClientSocket() throws IOException, InterruptedException {
        InputStream in =socket.getInputStream();
         this.out=socket.getOutputStream();

        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line=reader.readLine())!=null) {
            String[] tokens=StringUtils.split(line);
            if (tokens!=null && tokens.length>0) {
                String cmd=tokens[0];
                if ("quit".equalsIgnoreCase(cmd)) {
                    break;
                }
                else if ("login".equalsIgnoreCase(cmd)) {
                    handleLogin(out,tokens);
                }
                else{
                    String msg="unknown " + cmd+"\n";
                    out.write(msg.getBytes());
                }
            }
        }
        
        socket.close();
    }
   public String getLogin() {
       return login;
   }
    private void handleLogin(OutputStream out, String[] tokens) throws IOException {
        if (tokens.length==3){
            String login=tokens[1];
            String password=tokens[2];

            if (login.equals("guest") && password.equals("guest") || login.equals("jim") && password.equals("jim")  ) {
                out.write(("OK Login\n").getBytes());
                this.login=login;
                System.out.println("User logged in  successfully " + login);
                
                String onlineStatus="Online "+ login +"\n";
                List<serverWorker>  workerList= server.getWorkerList();
                for (serverWorker worker : workerList) {
                    worker.send(onlineStatus);
                }
            }
            else{
                out.write(("Error Login\n").getBytes());
            }

        }
    }
    private void send(String onlineStatus) throws IOException {
        out.write(onlineStatus.getBytes());
    }
}
