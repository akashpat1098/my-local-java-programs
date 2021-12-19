import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Client extends JFrame {

    JTextArea msg = new JTextArea();
	JScrollPane mdata = new JScrollPane(msg);
	
	JButton sendB = new JButton();
	
	DefaultListModel<String> clientModel = new DefaultListModel<String>();
	JList<String> clientList = new JList<String>(clientModel);
	JScrollPane data = new JScrollPane(clientList);
	
	// HashMap<String, NewTextArea> textArea = new HashMap<String, NewTextArea>();
	JScrollPane chatPane = new JScrollPane();
	public BufferedReader inBuffer;
	public OutputStream outBuffer;
	public Socket client;
	public int port=1098;
	public String ip="127.0.0.1";
	public String name="Akash";

    public Client(){
        setLocationByPlatform(true);
		setSize(610, 600);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) clientList.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		clientList.setForeground(Color.GREEN.darker());
		clientList.setFont(new Font("NSimSun", 1, 25));
		clientList.setBackground(getContentPane().getBackground());
		clientList.setSelectionBackground(Color.BLACK);
		clientList.setSelectionForeground(Color.GREEN);
		// clientList.addMouseListener(this);
		data.setBounds(0, 0, 250, 500);
		data.setBackground(null);
		data.setBorder(BorderFactory.createLineBorder(getBackground(), 5));
		add(data);
		
		msg.setBackground(Color.WHITE);
		msg.setFont(new Font("NSimSun", 1, 16));
		msg.setForeground(Color.RED);
		msg.setWrapStyleWord(true);
		msg.setLineWrap(true);
		// msg.addKeyListener(this);
		msg.setSelectedTextColor(Color.WHITE);
		msg.setSelectionColor(Color.BLUE);
		mdata.setBounds(1, 500, 525, 73);
		msg.setEnabled(false);
		msg.setBorder(BorderFactory.createBevelBorder(NORMAL));
		add(mdata);
		
		sendB.setBounds(535, 505, 64, 64);
		sendB.setIcon(new ImageIcon("sendIcon.png"));
		// sendB.addActionListener(this);
		sendB.setCursor(new Cursor(12));
		sendB.setEnabled(false);
		sendB.setToolTipText("Press ctrl+Enter to send the message.");
		add(sendB);
		
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		chatPane.setBounds(250, 0, 350, 500);
		chatPane.setVisible(true);
		add(chatPane);
		setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        // name = JOptionPane.showInputDialog("Enter Your Name: ");
        // ip = JOptionPane.showInputDialog("Enter Server IP Address: ");   
        // new Client().run();
        new Client();
    }
// 	private void run() throws IOException {
// 		client = new Socket(ip, port);
// 		setTitle(name+"_"+InetAddress.getLocalHost()+":"+port);
// 		inBuffer =new BufferedReader(new InputStreamReader(client.getInputStream()));
// 		outBuffer = client.getOutputStream();	
// 		outBuffer.write(name.getBytes());
// 	}
// 	public void send(String name) throws IOException
// 	{
// 		outBuffer.flush();
// 		String data = msg.getText();
// 		data = "@"+name+": "+data;
// 		outBuffer.write(data.getBytes());
// 		msg.setText("");
// 	}
//     @Override
// 	public void actionPerformed(ActionEvent e) 
// 	{
// 		if(e.getSource() == sendB && msg.getText().length() != 0)
// 		{
// 			try {
// 				send(clientList.getSelectedValue());
// 			} catch (IOException e1) {}
// 		}
// 	}
// 	@Override
// 	public void keyPressed(KeyEvent e) 
// 	{
// 		if(e.isControlDown() && e.getKeyCode()==10)
// 		{
// 			e.consume();
// 			try {
// 				send(clientList.getSelectedValue());
// 			} catch (IOException e1) {}
// 		}
// 	}
	
// 	@Override
// 	public void mouseClicked(MouseEvent e)
// 	{
// 		if(e.getSource() == clientList)
// 		{
// 			try {
// 				chatPane.getViewport().add(textArea.get(clientList.getSelectedValue()));
// 			}catch(IndexOutOfBoundsException ex) {}
// 		}
// 	}
// 	@Override
// 	public void keyTyped(KeyEvent e) {}
// 	@Override
// 	public void keyReleased(KeyEvent e) {}
// 	@Override
// 	public void mousePressed(MouseEvent e) {}
// 	@Override
// 	public void mouseReleased(MouseEvent e) {}
// 	@Override
// 	public void mouseEntered(MouseEvent e) {}
// 	@Override
// 	public void mouseExited(MouseEvent e) {}
	


}
// class NewTextArea extends JTextPane{
// 	private static final long serialVersionUID = 1L;
// 	StyledDocument doc = getStyledDocument();
//     SimpleAttributeSet left = new SimpleAttributeSet();
//     SimpleAttributeSet right = new SimpleAttributeSet();
    
//     public NewTextArea()
//     {
//     	StyleConstants.setForeground(left, Color.BLUE);
// 	    StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
	    
// 	    StyleConstants.setForeground(right, Color.RED);
// 	    StyleConstants.setAlignment(right, StyleConstants.ALIGN_LEFT);
// 	    setFont(new Font("NSimSun", 1, 15));
// 	    setEditable(false);
// 	    setBackground(getBackground());
//     }
    
//     public void insertLeft(String str)
//     {
// 	    try
// 	    {
// 	        doc.insertString(doc.getLength(), str, left );
// 	        doc.setParagraphAttributes(doc.getLength(), 1, left, false);
// 	    }
// 	    catch(Exception e) { }
//     }
    
//     public void insertRight(String str)
//     {
//     	try {
// 	        doc.insertString(doc.getLength(), str, right );
// 	        doc.setParagraphAttributes(doc.getLength(), 1, right, false);
//     	}catch(Exception e) {}
//     }
// }
