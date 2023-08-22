/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticketproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Bus id must be specified and Cancel of the user using his name of his seat no 
 */
public class History {
Connection co ;
 public History(){
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
               String sql = "select * from book";
               
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
                            
                        
                        String From , To , Cname , Seatno , Busid;
                        while(rs.next()){
                            From = rs.getString(1);
                            To = rs.getString(2);
                            Cname = rs.getString(3);
                            Seatno = rs.getString(4);
                            Busid = rs.getString(5);
                            
                            String [] row = {From , To , Cname , Seatno , Busid };
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
    
