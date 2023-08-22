
package busticketproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Booking {
    public Booking(){
        
   JFrame f = new JFrame();
        JDesktopPane d = new JDesktopPane();
        JMenu bt = new JMenu("NEW BOOKING");//book ticket 
        JMenu vh = new JMenu("VIEW HISTORY");//View History
        JMenu lt = new JMenu("LOGOUT");//logout;
        //JMenu et = new JMenu("Exit");//exit
        JMenuBar mb = new JMenuBar();
        JMenuItem m1 = new JMenuItem("Available Bus");//button tickt
        JMenuItem m2 = new JMenuItem("History");//button history
        JMenuItem m3 = new JMenuItem("Ticket Cancellation");//button logout
        JMenuItem m4 = new JMenuItem("Exit");
       // JMenuItem m4 = new JMenuItem("Logout");//button exit
        JButton b2 = new JButton();
        JMenuItem m5 = new JMenuItem("i");//i5
        JPanel p = new JPanel();//panel
        JPanel pt = new JPanel();//Top panel
        JLabel l = new JLabel();
        mb.setBackground(Color.LIGHT_GRAY);
        bt.setBackground(Color.white);
        vh.setBackground(Color.white);
        lt.setBackground(Color.white);
       // et.setBackground(Color.white);
        m1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              new Table();
                f.setVisible(false);
                
            }
            });
        
         m2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
               new History();
                f.setVisible(false);
            }
            });
          m3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new TicketCancellation();
                f.setVisible(false);
            }
            });
          m4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Page1();
                f.setVisible(false);
            }
            });
          
        bt.add(m1);
        vh.add(m2);
        lt.add(m4);
        bt.add(m3);
       
        f.setContentPane(d);
        mb.add(bt);
        mb.add(vh);
        mb.add(lt);
        f.setJMenuBar(mb);
        f.setBounds(40, 50, 600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("BOOKING BUS TICKET...");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
