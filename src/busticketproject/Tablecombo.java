
package busticketproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tablecombo {
      JFrame f ;
    JLabel l ;
    JTextField t1 , t2;
    JButton b;
    JComboBox cb , cb2;
    Statement st;
     JTable tb ;
     JScrollPane sp ;
        JPanel p ;
    public Tablecombo(){
         f = new JFrame();
         l = new JLabel("Select option you want ");
        t1 = new JTextField();
        t2 = new JTextField();
         b = new JButton("Search");
       // JButton b1 = new JButton("New Booking");
        String lang[] = {"      ", "Addis Abeba" , " Dilla" , "Hawassa", "BuleHoraa"};
         String snd[] = {"      " ,"Addis Abeba" ,  " Dilla" , "Hawassa", "BuleHoraa"};
        
        cb = new JComboBox(lang);
       cb2 = new JComboBox(snd);
        l.setBounds(100 , 20 , 400 , 30);
        cb.setBounds(50 , 100 , 110  , 20);
        cb2.setBounds(250 , 100 ,110 , 20);
       // t1.setBounds();
       // t2.setBounds();
         b.setBounds(190, 50, 150, 30);
        b.setBackground(Color.LIGHT_GRAY);
        b.setForeground(Color.black);
        b.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        f.add(l);
        f.add(cb);
        f.add(cb2);
        f.add(t1);
        f.add(t2);
        f.add(b);
         tb = new JTable();
         sp = new JScrollPane(tb);
        tb.setBounds(60, 150, 400, 400);
        f.add(sp);
        f.setBounds(100,30 , 900, 700);
        f.setTitle("Welcome to Page");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    b.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
       
              String driver = ("com.mysql.jdbc.Driver");
              String source= String.valueOf(cb.getSelectedItem());
              String destination = String.valueOf(cb2.getSelectedItem());
              // Here is something left 
              try{
                  Connection co;
                  Statement st;
                  
                      co =DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?", "root","");
                     st = co.createStatement();
                     String query = "select *from fetchdata where Source= '" + source + "'and Destination='" + destination + "'";
                     ResultSet rs = st.executeQuery(query);
                     ResultSetMetaData rsdm = rs.getMetaData();
                     DefaultTableModel model = (DefaultTableModel)tb.getModel();
                     tb = new JTable();
                     int col = rsdm.getColumnCount();
                     String[] colname = new String[col];
                     for(int i = 0 ; i < col ; i++){
                        colname[i] = rsdm.getColumnName(i+1);
                         model.setColumnIdentifiers(colname);
                            while(rs.next()){
                                String Busid = rs.getString(1);
                                String Source = rs.getString(2);
                                String Destination = rs.getString(3);
                                String Time = rs.getString(4);
                                String Price = rs.getString(5);
                                String TotalSeat = rs.getString(6);
                               String[] row = {Busid, Source , Destination , Time , Price , TotalSeat};
                              model.addRow(row);
                            }
                         
                     }
                  } catch (SQLException ex) {
                      Logger.getLogger(Tablecombo.class.getName()).log(Level.SEVERE, null, ex);
                 
                  

          }
            }
            });
   
      }
      
    
}
