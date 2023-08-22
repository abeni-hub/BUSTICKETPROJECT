
package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteBus {
    Connection co ;
    Statement st ;
    ResultSet rs;
    public DeleteBus(){
        JFrame f = new JFrame("Delete Bus Page");
      JButton b = new JButton("Delete");
      JButton b1 = new JButton("Back");
      JLabel l1 = new JLabel("Bus_id");//for id
      JTextField t= new JTextField();
      l1.setBounds(20, 20, 100, 30);
        t.setBounds(140, 20, 100, 30);
        b.setBounds(80, 60, 80, 40);
        b1.setBounds(100, 160, 80, 40);
         f.add(t);
        f.add(l1);
        f.add(b);
        f.add(b1);
         b.setBackground(Color.white);
        b.setForeground(Color.BLACK);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 10));
         b1.setBackground(Color.blue);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
         b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                  
                    String s = "delete from fetchdata where Busid = '"+ t.getText() +"' ";
                    co =DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?", "root","");
                    st = co.createStatement();
                    if(st.executeUpdate(s) == 1){
                        JOptionPane.showMessageDialog(null, "Deleted Successfully ");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, " No such Bus is founded ");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteBus.class.getName()).log(Level.SEVERE, null, ex);
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
         
        f.setLayout(null);
        f.setVisible(true);
         f.setBounds(40 ,50 , 700, 467);
        f.setTitle("Delete bus page...");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }}
