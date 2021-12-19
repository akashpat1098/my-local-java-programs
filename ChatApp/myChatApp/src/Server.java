import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame{
	int port=1098;

    JTextArea serverInfo = new JTextArea();
	JScrollPane data = new JScrollPane(serverInfo);
	JTextArea clientInfo = new JTextArea();
	JScrollPane mdata = new JScrollPane(clientInfo);
	List<String> clientList = new ArrayList<String>();
	Vector<clientHandler> users = new Vector<clientHandler>();


	public Socket clientSocket;
	public ServerSocket serverSocket;
	public String serverinfo;
	public int clientCount = 0;

    
    public Server(){
        super("Server:");
        
        setSize(890, 590);
        setLocationByPlatform(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
		setResizable(false);
        
        serverInfo.setBackground(Color.WHITE);
		serverInfo.setFont(new Font("NSimSun", 1, 16));
		serverInfo.setForeground(Color.BLUE);
		serverInfo.setWrapStyleWord(true);
		serverInfo.setLineWrap(true);
		serverInfo.setEditable(false);
		serverInfo.setSelectedTextColor(Color.WHITE);
		serverInfo.setSelectionColor(Color.BLUE);
		data.setBounds(0, 0, 435, 555);
		data.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		add(data);
		
		clientInfo.setBackground(Color.WHITE);
		clientInfo.setFont(new Font("NSimSun", 1, 16));
		clientInfo.setForeground(Color.BLUE);
		clientInfo.setWrapStyleWord(true);
		clientInfo.setLineWrap(true);
		clientInfo.setEditable(false);
		clientInfo.setSelectedTextColor(Color.WHITE);
		clientInfo.setSelectionColor(Color.BLUE);
		mdata.setBounds(435, 0, 435, 555);
		mdata.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		add(mdata);

        
        setVisible(true);

    }
    public void startServer() throws IOException{
		serverSocket=new ServerSocket(port);
		serverinfo = "Server Established at:\nport = "+port+"\nIP = "+InetAddress.getLocalHost();
		serverInfo.setText(serverinfo);

		while (true) {
			clientCount++;
			clientSocket=serverSocket.accept();
			clientHandler thread=new clientHandler(clientSocket);
			thread.start();
			users.add(thread);
		}
	}
	public static void main(String[] args) throws IOException {
        try {
			new Server().startServer();
		}catch(BindException e) {
			JOptionPane.showMessageDialog(null, "Server Already Bind with this port and IP.");
			System.exit(ABORT);
		}
        
		
		
    }
	class clientHandler extends Thread{

		public Socket clientSocket;
		private BufferedReader inBuffer;
		private OutputStream outBuffer;
		private String name;
	
		public clientHandler(Socket clientSocket) throws IOException {
			this.clientSocket=clientSocket;
	
			inBuffer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outBuffer=clientSocket.getOutputStream();
			name = inBuffer.readLine();
			clientList.add(name);
			serverinfo = "New Client "+name +" Connected.";
			serverInfo.append("\n"+serverinfo);
	}
	
	}
	public void run() {
	}
}

