// import javax.swing.*;
// import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class createWindow {
    public void window() {
        JFrame frame = new JFrame("Simple GUI");// crete the empty frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// this close program with exit
        frame.setSize(500,500);

        // JMenuBar mb = new JMenuBar();
        // JMenu m1 = new JMenu("FILE");
        // JMenu m2 = new JMenu("Help");
        // mb.add(m1);
        // mb.add(m2);
        // JMenuItem m11 = new JMenuItem("Open");
        // JMenuItem m22 = new JMenuItem("Save as");
        // m1.add(m11);
        // m1.add(m22);
        
        JPanel panel = new JPanel();
        JLabel textLabel = new JLabel("Enter Text");
        JTextField textField=new JTextField(20);
        JButton Send = new JButton("Send");
        JButton Cancel = new JButton("Cancel");
        
        
        // panel.add(textLabel);
        // panel.add(textField);
        // panel.add(Send);
        // panel.add(Cancel);
        
        // frame.getContentPane().add(BorderLayout.CENTER, textLabel);
        // frame.getContentPane().add(BorderLayout.SOUTH, button1);
        // frame.getContentPane().add(BorderLayout.EAST, button2);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);

        // frame.pack();// pack the component on frame
        frame.setLocationRelativeTo(null);// set location
        frame.setVisible(true);// make visible the window

        Cancel.addActionListener(
            new ActionListner(){
                
                public void actionPerformed(Actionevent e){
                    System.exit(0);
                }
            }
        );

      
    }
    public static void main(String[] args) {
        
    }
}

