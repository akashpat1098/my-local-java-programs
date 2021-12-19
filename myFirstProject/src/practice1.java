import javax.swing.*;
import java.awt.event.*;
public class practice1 {
    practice1(){
        JFrame f=new JFrame();
        JButton b=new JButton();
        b.setBounds(50,50,100,30);
        f.add(b);
        f.setSize(200,200);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(
            new ActionListner(){
                public void actionPerformed(ActionEvent e){
                    b.setText("hi");
                }
            }
        );
    }
}
