
package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User {
    Connection co = null;
    Statement st = null;
    ResultSet rs = null;
    public User(){
        
   JFrame f = new JFrame();
        
        JTextField t1 = new JTextField("");
        JPasswordField p1 = new JPasswordField("");
        JButton b = new JButton("SIGNUP");
        JButton b1 = new JButton("Back");
        
        JLabel l1 = new JLabel("User name:");
        JLabel l2 = new JLabel("Password:");
        JLabel l4 = new JLabel("Message here");

        t1.setBounds(160, 110, 120, 40);
        p1.setBounds(160, 160, 120, 40);
       

        l1.setBounds(50, 70, 100, 100);
        l2.setBounds(50, 120, 100, 100);
        l4.setBounds(50, 350, 300, 50);    
        b.setBounds(280, 320, 80, 60);
         b1.setBounds(250, 350, 130, 30);
         b1.setBackground(Color.LIGHT_GRAY);
        b1.setForeground(Color.gray);
        b1.setFont(new Font(Font.SERIF, Font.BOLD, 18));
         b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Loginpage();
                f.setVisible(false);
                
            }
            });
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Stored the data to store in the database 
                 try {
             co=DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?zeroDateTimeBehavior=convertToNull [root on Default schema]","root","");
         st=co.createStatement();
         String s1=t1.getText();
         String s2=p1.getText();
         st.executeUpdate("insert into login values('"+ s1 +"','" + s2 +"')");
          l4.setText("the data is successfuly sumbitted");
         t1.setText("");
         p1.setText("");
         } catch (Exception ex) {
             l4.setText(ex.getMessage());
             //The condition for that when we intered the right data program excutes uou data is successfully 
             //submitted and for the other the data is incorrect data
              f.setVisible(false);
         }
     }});
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\futu.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(l4);
        f.add(p1);
       
        f.add(b);
        f.add(b1);
        b.setBounds(200, 300, 150, 30);
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.blue);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        f.add(b);
        f.setBounds(40 ,50 , 700, 467);
        f.setLayout(new GridLayout(1, 2));
        f.setTitle("Welcome to Page");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
}
}
