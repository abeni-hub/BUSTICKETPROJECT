/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticketproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Addbus{
   
    Connection co ;
    Statement st ;
    ResultSet rs;
    public Addbus(){
       JFrame f = new JFrame();
        JLabel l1, l2, l3, l4, l5, l6;
        JTextField t1, t2, t3, t4, t5, t6;
        JButton b1  , b;
        l1 = new JLabel("Bus_Id ");
        l2 = new JLabel("Source");
        l3 = new JLabel(" Destination ");
        l4 = new JLabel("Time");
        l5 = new JLabel("Price");
        l6 = new JLabel("Total Seats");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        b = new JButton("Back");
        b1 = new JButton("Add Bus");
        l1.setBounds(20, 20, 100, 30);
        l2.setBounds(20, 60, 100, 30);
        l3.setBounds(20, 100, 100, 30);
        l4.setBounds(20, 140, 100, 30);
        l5.setBounds(20, 180, 100, 30);
        l6.setBounds(20, 220, 100, 30);
        t1.setBounds(140, 20, 100, 30);
        t2.setBounds(140, 60, 100, 30);
        t3.setBounds(140, 100, 100, 30);
          t4.setBounds(140, 140, 100, 30);
          t5.setBounds(140, 180, 100, 30);
          t6.setBounds(140, 220, 100, 30);
        b1.setBounds(80, 300, 120, 30);
         b.setBounds(100, 350, 120, 30);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(b1);
        f.add(b);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AddminBook();
                f.setVisible(false);
                
            }
            });
        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(40, 50, 700, 467);
        f.setTitle("Add Bus page...");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Stored the data to store in the database 
                try {
                    co = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?", "root", "");
                    st = co.createStatement();
                    String s1 = t1.getText();
                    String s2 = t2.getText();
                    String s3 = t3.getText();
                    String s4 = t4.getText();
                    String s5 = t5.getText();
                    String s6 = t6.getText();
                String query = "select *from fetchdata where Busid= '"+t1.getText()+"'";
                       st = co.createStatement();
                  rs = st.executeQuery(query);
                       if(rs.next()==true){
                           JOptionPane.showMessageDialog(null,"The Bus is already exist!");
                           return ;
                       }
                        
                    if ((st.executeUpdate("insert into fetchdata values('" + s1+ "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "')")) == 1) {
                        JOptionPane.showMessageDialog(null, "The Bus is added successfully");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "some Error");

                    }
                } catch (Exception ex) {
                    l4.setText(ex.getMessage());

                    f.setVisible(false);
                }
            }
        });
    }
             }


    

