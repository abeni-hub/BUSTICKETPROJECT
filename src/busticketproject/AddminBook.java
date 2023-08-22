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

public class AddminBook {
    public AddminBook(){
          
           
        JFrame f = new JFrame();
        JDesktopPane d = new JDesktopPane();
        JMenu bt = new JMenu("ADD BUS");//book ticket 
        JMenu vh = new JMenu("UPDATE BUS");//View History
        JMenu lt = new JMenu("DELETE BUS");//logout;
        JMenu et = new JMenu("VIEW HISTORY");//exit
        JMenu tt = new JMenu("EXIT");
        JMenuBar mb = new JMenuBar();
        JMenuItem m1 = new JMenuItem("Add Bus");//button tickt
        JMenuItem m2 = new JMenuItem("Update Bus");//button history
        JMenuItem m3 = new JMenuItem("Delete Bus");//button logout
        JMenuItem m4 = new JMenuItem("Bus History");//button exit
        JMenuItem m5 = new JMenuItem("User History");
          JMenuItem m7= new JMenuItem("Update User");
            JMenuItem m8 = new JMenuItem("Delete User");
      JMenuItem m6 = new JMenuItem("Logout");
        JButton b2 = new JButton();
        JPanel p = new JPanel();//panel
        JPanel pt = new JPanel();//Top panel
        JLabel l = new JLabel();
        mb.setBackground(Color.LIGHT_GRAY);
        bt.setBackground(Color.white);
        vh.setBackground(Color.white);
        lt.setBackground(Color.white);
        et.setBackground(Color.white);
        m1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Addbus();
                f.setVisible(false);
                
            }
            });
        
         m2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                //
                new UpdateBus();
                f.setVisible(false);
            }
            });
          m3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DeleteBus();
                f.setVisible(false);
            }
            });
            m4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Bushistory();
                f.setVisible(false);
            }
            });
              m5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new History();
                f.setVisible(false);
            }
            });
        
           m6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Page1();
                f.setVisible(false);
            }
            });
            m7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new updateuser();
                f.setVisible(false);
            }
            });
             m8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Deleteuser();
                f.setVisible(false);
            }
            });
        bt.add(m1);
        vh.add(m2);
        vh.add(m7);
        lt.add(m8);
        lt.add(m3);
        et.add(m4);
        et.add(m5);
        tt.add(m6);
        f.setContentPane(d);
        mb.add(bt);
        mb.add(vh);
        mb.add(lt);
        mb.add(et);
        mb.add(tt);
        f.setJMenuBar(mb);
        f.setBounds(40, 50, 600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("Addmin Task");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
