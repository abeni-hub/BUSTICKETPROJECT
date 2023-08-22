
package busticketproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bushistory {
    Connection co;
    public Bushistory(){
     try {
           JFrame frame1 = new JFrame();
           JTable tb1 = null;
           DefaultTableModel dtm = null;
           JScrollPane scrol = null;
           ResultSetMetaData rsm = null;
           PreparedStatement stm = null;
           ResultSet rs = null;
           
           
           tb1 = new JTable();
           scrol = new JScrollPane(tb1);
           frame1.add(scrol);
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           try {
               String sql = "select * from fetchdata";
               
               co = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                        stm = co.prepareStatement(sql);
                        rs = stm.executeQuery();
                        rsm = rs.getMetaData();
                        dtm = (DefaultTableModel) tb1.getModel();
                        int col = rsm.getColumnCount();
                        String[] colname = new String[col];
                        for(int i = 0 ; i <col ; i++){
                            colname[i] = rsm.getColumnClassName(i+1);
                            dtm.setColumnIdentifiers(colname);
                            
                        
                        String Busid, Source , Destination , Time , Price , TotalSeat;
                        while(rs.next()){
                            Busid = rs.getString(1);
                             Source = rs.getString(2);
                            Destination= rs.getString(3);
                            Time= rs.getString(4);
                            Price = rs.getString(5);
                             TotalSeat = rs.getString(6);
                            
                            
                            String [] row = {Busid , Source , Destination , Time , Price , TotalSeat };
                            dtm.addRow(row);
                        }
                        }
           } catch (SQLException ex) {
               Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
           }
  
           
           
           frame1.setVisible(true);
           frame1.setSize(400, 300);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    }

