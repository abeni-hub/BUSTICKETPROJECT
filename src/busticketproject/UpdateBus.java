package busticketproject;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateBus {

    Connection co;
    Statement st;
    ResultSet rs;

    public UpdateBus() {
        JFrame f = new JFrame();
        JLabel l1, l2, l3, l4, l5 ,l6;
        JTextField t1, t2, t3, t4, t5 , t6;
        JButton b1, b2;
        l1 = new JLabel("BUS_ID");
        l2 = new JLabel("SOURCE");
        l3 = new JLabel("DESTINATION");
        l4 = new JLabel("TIME");
        l5 = new JLabel("PRICE");//for id
        l6 = new JLabel("TOTAL SEAT");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        b1= new JButton("Back");
        b2 = new JButton("Update Bus");
       // b1 = new JButton("BACK");
        l1.setBounds(20, 100, 100, 30);
        l2.setBounds(20, 140, 100, 30);
        l3.setBounds(20, 180, 100, 30);
        l4.setBounds(20, 220, 100, 30);
        l5.setBounds(20, 260, 100, 30);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
         l6.setBounds(20, 300, 100, 30);
        t1.setBounds(140, 100, 100, 30);
        t2.setBounds(140, 140, 100, 30);
        t3.setBounds(140, 180, 100, 30);
        t4.setBounds(140, 220, 100, 30);
       
        t5.setBounds(140, 260, 100, 30);
        t6.setBounds(140 , 300 , 100 , 30);
         b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AddminBook();
                f.setVisible(false);
                
            }
            });
      /*      
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HP\\Downloads\\update.jfif")))));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
        b1.setBounds(250, 400, 100, 40);
        b2.setBounds(200, 350, 100, 40);
        f.add(l1);
        f.add(l5);
        f.add(l4);
        f.add(t4);
        f.add(l2);
        f.add(l3);
        f.add(l6);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(b1);
        f.add(b2);
        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(40, 50, 700, 500);
        f.setTitle("Update Bus page...");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String s = "update fetchdata set Source= '" + t2.getText() + "',Destination ='"+ t3.getText() + "',Time='" + t4.getText()+ "',Price ='"+ t5.getText() + "',TotalSeat= '" + t6.getText()+ "'where Busid = '" + t1.getText() + "'";
         
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
     
    }
}

