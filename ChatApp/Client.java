
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Client extends JFrame {
    Socket socket;

    BufferedReader in;
    PrintWriter out;

    JLabel heading=new JLabel("Client Area");
    JTextArea messageArea=new JTextArea();
    JTextField messageInput=new JTextField();
    Font font=new Font("Roboto",Font.PLAIN,20);

    public Client(){
        try{
            System.out.println("Sending Request to Server");
            socket=new Socket("127.0.0.1",7777);
            System.out.println("Connection Established");

            // createGUI();
            // handleEvents();
            startReading();
            startWriting();
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleEvents() {
        Runnable r0=()->{
        messageInput.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    out=new PrintWriter(socket.getOutputStream());
                    if (e.getKeyCode()==10) {
                        String msgToSend=messageInput.getText();
                        messageArea.append("Me:"+msgToSend+"\n");
                        out.println(msgToSend);
                        out.flush();
                        messageInput.setText("");
                        if (msgToSend.equals("exit")) {
                            System.exit(0);
                        }
                        messageInput.requestFocus();
                    }
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
            
        });
    };
    new Thread(r0).start();
    }
    public void createGUI(){

        this.setTitle("Client Messager");
        this.setSize(600,650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        heading.setFont(font);
        messageArea.setFont(font);
        messageInput.setFont(font);
        
        heading.setIcon(new ImageIcon("sendIcon.png"));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        messageArea.setEditable(false);
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new BorderLayout());
        this.add(heading,BorderLayout.NORTH);
        JScrollPane scrollPane=new JScrollPane(messageArea);
        this.add(scrollPane,BorderLayout.CENTER);
        this.add(messageInput,BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void startReading() {
        Runnable r1=()->{
            try {
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                while ((msg=in.readLine())!=null) {
                        
                        if (msg.equals("exit")) {
                            System.out.println("Server terminated the Chat");
                            JOptionPane.showMessageDialog(this, "Server terminated the Chat");
                            socket.close();
                            System.exit(0);
                            break;
                        }
                        System.out.println("Server:" + msg);
                    }   // messageArea.append("Server:" + msg+"\n");
            }catch (IOException e) {
                e.printStackTrace();
            }
                   
        };
        new Thread(r1).start();
    }
    public void startWriting(){
        Runnable r2=()->{
            while (true) {
                try {
                        BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                        String content=br1.readLine();
                        out=new PrintWriter(socket.getOutputStream());
                        out.println(content);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
        };
        new Thread(r2).start();

    }
    public static void main(String[] args) {
        new Client();

    }
}
 