package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updateuser {
    Connection co;
    Statement st;
    ResultSet rs;
    public updateuser(){
        JFrame f = new JFrame();
        JButton b = new JButton("Update");
        JButton b1 = new JButton("Back");
        JButton b3 = new JButton();
        JTextField t1 = new JTextField("");
        JTextField t2 = new JTextField("");
        JTextField t3 = new JTextField("");
        JTextField t4 = new JTextField("");
        //JTextField t5 = new JTextField("");

        JLabel l1 = new JLabel("From:");
        JLabel l2 = new JLabel("To:");
        JLabel l3 = new JLabel("CName:");
        JLabel l4 = new JLabel("Seat no");
        //JLabel l5 = new JLabel("Price");
        JLabel l6 = new JLabel("");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Abenezer", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setFont(new Font("Abenezer", Font.BOLD, 16));
        l3.setForeground(Color.white);
        l3.setFont(new Font("Abenezer", Font.BOLD, 16));
        l4.setForeground(Color.white);
        l4.setFont(new Font("Abenezer", Font.BOLD, 16));
      //l5.setForeground(Color.white);
       // l5.setFont(new Font("Abenezer", Font.BOLD, 16));
       try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\upd2.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        t1.setBounds(140, 110, 130, 40);
        t2.setBounds(140, 160, 130, 30);
        t3.setBounds(140, 200, 130, 40);
        t4.setBounds(140, 260, 130, 40);
        //t5.setBounds(140, 310, 130, 40);

        l1.setBounds(30, 80, 100, 100);
        l2.setBounds(30, 130, 100, 100);
        l3.setBounds(30, 180, 100, 100);
        l4.setBounds(30, 230, 100, 100);
       // l5.setBounds(30, 280, 100, 100);
        l6.setBounds(30, 500, 100, 100);
        b.setBounds(250, 310, 100, 40);
        b1.setBounds(400, 310, 100, 40);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Stored the data to store in the database 
                       try {

                    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  String s = "update book set From= '" + t1.getText() + "',To ='"+ t2.getText() + "',Cname='" + t3.getText()+ "where seatno = " + t4.getText() + "'";
         
  co =DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?", "root","");

                    st = co.createStatement();
                   if(st.executeUpdate(s) == 1){
                        JOptionPane.showMessageDialog(null, "Updated Successfully ");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "NO such Bus is found ");
                    }
                   
                  
                } catch (Exception ex) {
                    t1.setText(ex.getMessage());
                }
            }
        });
      b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AddminBook();
                f.setVisible(false);
                
            }
            });
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
      ///  f.add(l5);
        f.add(t1);
        f.add(l4);
        f.add(t2);
       f.add(b1);
        f.add(t4);
        f.add(t3);
        f.add(b);
        //  b.setBounds(200, 410, 150, 30);
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.blue);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 16));
         b1.setBackground(Color.LIGHT_GRAY);
        b1.setForeground(Color.black);
        b1.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        f.add(b);
        f.setBounds(40, 50, 600, 400);
        //  f.setLayout(new GridLayout(1, 2));
        f.setTitle("BOOKING TICKETS");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    
    }
}
