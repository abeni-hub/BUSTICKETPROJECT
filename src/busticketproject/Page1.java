
package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Page1 {
    public Page1(){
          JFrame f = new JFrame();
        JButton b = new  JButton("USER");
        JButton b2 = new JButton("ADMIN");
        JLabel l5 = new JLabel("WELCOME TO BUS TICKET RESERVATION SYSTEM");
                l5.setForeground(Color.BLACK);
                l5.setFont(new Font("Abenezer", Font.BOLD, 20));
                  l5.setFont(new Font("Abenezer", Font.ITALIC, 20));
              l5.setBounds(40, 20, 700, 200);
  

        b.setBounds(180, 300, 140, 40);
        b2.setBounds(400, 300, 140, 40);
         b.setFont(new Font("Abenezer", Font.BOLD, 22));
        b.setForeground(Color.BLUE);
          b2.setFont(new Font("Abenezer", Font.BOLD, 22));
        b2.setForeground(Color.BLUE);
         f.setBounds(40, 50, 700, 500);
          
       try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Downloads\\Welcomeimg.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
          b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             new Loginpage();
             f.setVisible(false);
            }
            });
          b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
           new AdminPage();
           f.setVisible(false);
            }
            });
          f.add(b);
          f.add(b2);
          f.add(l5);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("Login Page...");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
