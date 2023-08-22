
package busticketproject;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Table implements ActionListener{
        JFrame f;//creating object of first JFrame
    JLabel nameLabel;//creating object of JLabel
    JLabel l2 ;
    JTextField nameTextField;//creating object of JTextfield
    JTextField t2;
    JButton fetchButton;//creating object of JButton
    JButton resetButton;//creating object of JButton
    
    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class
    int flag=0;
    public Table(){
   f= new JFrame();
        f.setTitle("Search Database");//setting the title of first JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation
        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints
        f.setSize(500, 300);//setting the size of first JFrame
        f.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
 
        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
 
      //Setting the property of JLabel and adding it to the first JFrame
        nameLabel = new JLabel("FROM");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        f.add(nameLabel, bagConstraints);
        
        l2 = new JLabel("TO");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        f.add(l2, bagConstraints);
        
       //Setting the property of JTextfield and adding it to the first JFrame
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        f.add(nameTextField, bagConstraints);
 
         t2 = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        f.add(t2, bagConstraints);
      //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        bagConstraints.ipadx = 60;
        f.add(fetchButton, bagConstraints);
 
      //Setting the property of JButton(Reset Data) and adding it to the second JFrame
        resetButton = new JButton("New Registeration");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 2;
        f.add(resetButton, bagConstraints);
 
        //adding ActionListener to both buttons
        fetchButton.addActionListener(this);
        resetButton.addActionListener(this);
         f.setVisible(true);//Setting the visibility of First JFrame
        f.validate();//Performing relayout of the First JFrame
      
        }
        
        
       public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fetchButton) {

            String Source = nameTextField.getText().toString();//getting text of username text field and storing it in a String variable
            String Destination = t2.getText().toString();
            frameSecond(Source ,Destination);//passing the text value to frameSecond method
            f.setVisible(true);

        }
        if (e.getSource() == resetButton) {
            nameTextField.setText("");//resetting the value of username text field
            new AddBook();
            f.setVisible(false);
        }

 }

 
       public  void frameSecond(String Source , String Destination){
           frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setBounds(160 , 200 ,600, 600 );
        frame2.setSize(700, 600);
        f.setBounds(100, 150, 700, 00);

        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Bus_ID");
        defaultTableModel.addColumn("Source");
        defaultTableModel.addColumn("Destination");
        defaultTableModel.addColumn("Time");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Total Seat");
try {
        	
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsystem?zeroDateTimeBehavior=convertToNull", "root", "");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from fetchdata where Source= '" + Source +"'and Destination='" +Destination + "'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
//'"+USERNAME+"' and password = '"+PASSWORD+"'"

            while (resultSet.next()) {

            	//Retrieving details from the database and storing it in the String variables
                String bus_no = resultSet.getString("Busid");
                String source = resultSet.getString("Source");
                String destination = resultSet.getString("Destination");
                String time = resultSet.getString("Time");
                String price = resultSet.getString("Price");
                String seat = resultSet.getString("TotalSeat");
                if (Source.equalsIgnoreCase(source) && Destination.equalsIgnoreCase(destination)) {
                    flag = 1;
               //JOptionPane.showMessageDialog(null, "The data is fetching successfully");//When invalid username is entered

                    defaultTableModel.addRow(new Object[]{bus_no,source,destination , time , price , seat});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();
                    break;
                  
                }
                
            }

            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such Bus is Found");//When invalid username is entered
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, throwables.getMessage());
        }

       } 

}
