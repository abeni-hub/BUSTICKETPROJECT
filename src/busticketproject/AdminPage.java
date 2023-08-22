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

public class AdminPage {
    Connection co; 
    Statement st ; 
    ResultSet rs;
    public AdminPage(){
        JFrame f = new JFrame();
        
        JTextField t1 = new JTextField("");
        JPasswordField p1 = new JPasswordField("");
        JButton b = new JButton("LOGIN");
        
        
        JLabel l1 = new JLabel("Admin:");
        JLabel l2 = new JLabel("Security No:");;
        JLabel l4 = new JLabel("");

        t1.setBounds(160, 110, 120, 40);
        p1.setBounds(160, 160, 120, 40);
        l1.setBackground(Color.LIGHT_GRAY);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
 l2.setBackground(Color.LIGHT_GRAY);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        l1.setBounds(50, 70, 100, 100);
        l2.setBounds(50, 120, 100, 100);
        l4.setBounds(50, 350, 300, 50);    
        b.setBounds(280, 320, 80, 60);
   // JButton b1 = new JButton("signup");
   try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Downloads\\ad3.jpg ")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
   /*  b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new User();
                f.setVisible(false);
                
            }
            });
        */
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      try{
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     //con=DriverManager.getConnection("jdbc:sqlserver://ABA//SQLEXPRESS; databaseName=dbo.camo");
     co=DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?", "root","");
     st=co.createStatement();
     String USERNAME=t1.getText();
     String PASSWORD=p1.getText();
     rs=st.executeQuery("select * from admin where username ='"+USERNAME+"' and securityno = '"+PASSWORD+"'");
     while(rs.next()){
     
      new AddminBook();
       f.setVisible(false);
     }
 }
 catch(Exception ex){t1.setText(ex.getMessage());
 }
  }});
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(l4);
        f.add(p1);
      //  f.add(b1);
        f.add(b);
       /* b1.setBounds(250, 350, 130, 30);
         b1.setBackground(Color.LIGHT_GRAY);
        b1.setForeground(Color.gray);
        b1.setFont(new Font(Font.SERIF, Font.BOLD, 18));*/
        b.setBounds(200, 300, 150, 30);
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.black);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        f.add(b);
        f.setBounds(40 ,50 , 600, 400);
        f.setLayout(new GridLayout(1, 2));
        f.setTitle("Welcome to Page");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
