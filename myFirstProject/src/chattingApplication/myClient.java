package chattingApplication;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class myClient extends JFrame implements ActionListener {
    JPanel p1;
    JTextField t1;
    static JTextArea a1;
    JButton b1;

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    myClient(){
        p1=new JPanel();        //panel for putting img on top
        p1.setLayout(null);     //setting default layout to null
        p1.setBackground(new Color(7, 94, 87));     //setting Background
        p1.setBounds(0,0,300,50);   //setting bounds for above panel
        add(p1);    //adding panel

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/back.jfif"));     //creating img icon
        Image img1=i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);  //setting size of imagr
        ImageIcon i2=new ImageIcon(img1);   //again creating  icon and adding  sizable img
        JLabel l1=new JLabel(i2);   //label for image.img cannot be directly inserted into frame
        l1.setBounds(5,15,15,15);    //setting bounds for label
        p1.add(l1); //adding label

        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("com/company/back.jfif"));     //creating img icon
        Image img2=i3.getImage().getScaledInstance(32,32,Image.SCALE_DEFAULT);  //setting size of imagr
        ImageIcon i4=new ImageIcon(img2);   //again creating  icon and adding  sizable img
        JLabel l2=new JLabel(i4);   //label for image.img cannot be directly inserted into frame
        l2.setBounds(23,15,20,20);    //setting bounds for label
        p1.add(l2); //adding label

        JLabel l3=new JLabel("Gaitonde");
        l3.setBounds(47,20,100,15);
        l3.setFont(new Font("SAN SERIF",Font.BOLD,14));
        l3.setForeground(Color.white);
        p1.add(l3);

        a1=new JTextArea();
        a1.setBounds(3,52,294,407);
        a1.setBackground(new Color(236, 46, 191));
        a1.setFont(new Font("SAN SERIF",Font.PLAIN,14));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);

        t1=new JTextField();
        t1.setBounds(5,460,195,35);
        t1.setFont(new Font("SAN SERIF",Font.PLAIN,14));
        add(t1); //adding label

        b1=new JButton("Send");
        b1.setBounds(205,460,95,35);
        b1.setBackground(new Color(7,94,94));
        b1.setForeground(Color.white);
        b1.setFont(new Font("SAN SERIF",Font.BOLD,14));
        b1.addActionListener(this);
        add(b1);

//        getContentPane().setBackground(Color.red);
        setLayout(null);
        setSize(300,500);
        setLocation(800,180);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String out = t1.getText();
            a1.setText(a1.getText() + "\n\t\t\t\t" + out);
            dout.writeUTF(out);
            t1.setText("");
        }
        catch (Exception ex){}
    }
    public static void main(String[] args) {
        new myClient().setVisible(true);
            String msginput="";
        try {
            s=new Socket("127.0.0.1",5000);
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());

            msginput=din.readUTF();
            a1.setText(a1.getText()+"\n\t\t\t\t"+msginput);


            s.close();
        }
        catch (Exception e){}
    }


}
