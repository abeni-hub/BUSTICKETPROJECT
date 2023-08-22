/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class BOOKINGFORM {
    Connection co = null;
    Statement st = null;
    ResultSet rs = null;
    public BOOKINGFORM(){
         
     JFrame f = new JFrame();
        JButton b = new JButton("CHECK");
        JButton b1 = new JButton();
        JButton b3 = new JButton();
          JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");
        
        
        JLabel l1 = new JLabel("FROM:");
        JLabel l2 = new JLabel("TO:");
          l1.setForeground(Color.WHITE);
                l1.setFont(new Font("Abenezer", Font.BOLD, 24));
                  l2.setForeground(Color.WHITE);
                l2.setFont(new Font("Abenezer", Font.BOLD, 24));
        JLabel l4 = new JLabel();

        t1.setBounds(140, 110, 120, 40);
        t2.setBounds(140, 160, 120, 40);
       

        l1.setBounds(30, 70, 100, 100);
        l2.setBounds(30, 120, 100, 100);
        l4.setBounds(50, 350, 300, 50);    
        b.setBounds(280, 320, 80, 60);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Stored the data to store in the database 
                 try {
             co=DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?","root","");
         st=co.createStatement();
         String s1=t1.getText();
         String s2=t2.getText();
         st.executeUpdate("insert into new1 values('"+ s1 +"','" + s2 +"')");
          l4.setText("the data is successfuly sumbitted");
         t1.setText("");
         t2.setText("");
         } catch (Exception ex) {
             l4.setText(ex.getMessage());
                     

         }
     }});
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\abstract1.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
             new Booking();
             f.setVisible(false);
            }
            });
      
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(l4);
        f.add(t2);
        f.add(b);
        b.setBounds(200, 300, 150, 30);
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.blue);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        f.add(b);
        f.setBounds(40 ,50 ,600, 600);
      //  f.setLayout(new GridLayout(1, 2));
        f.setTitle("BOOKING TICKETS");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
