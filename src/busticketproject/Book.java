
package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Book {
    public Book(){
    JFrame f = new JFrame();
        JButton b = new JButton("Book here");
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
             f.setVisible(false);
                new Page1();
            }
        });
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\new.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        b.setBounds(10, 320, 150, 30);
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.black);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        f.add(b);
        f.setBounds(40 ,50 , 600, 400);
        f.setTitle("Welcome to Page");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
