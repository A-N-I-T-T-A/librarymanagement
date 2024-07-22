import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class Content4 extends JFrame implements ActionListener, ItemListener
{
JTextField j1;
JLabel l1;
JComboBox c1,c2,c3;
JFrame contentPane;
Connection con;
ResultSet rs,rs1,rs2;
Statement st,st1,st2;
String ids,ids1,ids2;
JTextField text3,text4,text5;
public Content4(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
setTitle("LIBRARY MANAGEMENT SYSTEM");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);

l1=new JLabel();

JLabel title=new JLabel("Issue Book");
title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
contentPane.add(title);
title.setBounds(860,120,450,50);


JLabel label1=new JLabel("Book ID");
label1.setBounds(750,180,150,50);
contentPane.add(label1);

try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
Connection con = DriverManager.getConnection("jdbc:odbc:LMS","","");
            st = con.createStatement();
            rs = st.executeQuery("select Book_ID from View_Books");
            Vector v = new Vector();
            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }
            c1 = new JComboBox(v);
            c1.setBounds(870, 190, 250, 30);
            add(c1);
            c1.setSelectedIndex(-1);
             c1.addItemListener(this);
            st.close();
            rs.close();
        } catch (Exception e) {
        }

JLabel label2=new JLabel("Student/Teacher ID");
label2.setBounds(750,220,150,50);
contentPane.add(label2);

try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
Connection con = DriverManager.getConnection("jdbc:odbc:LMS","","");
            st2 = con.createStatement();
            rs2 = st2.executeQuery("select ID from New_Student UNION select T_ID from Teacher");
            Vector v = new Vector();
            while (rs2.next()) {
                ids2 = rs2.getString(1);
                v.add(ids2);
            }
            c3 = new JComboBox(v);
            c3.setBounds(870, 230, 250, 30);
            add(c3);
            c3.setSelectedIndex(-1);
             
            st2.close();
            rs2.close();
        } catch (Exception e) {
        }
JLabel label3=new JLabel("Book Name");
label3.setBounds(750,260,150,50);
contentPane.add(label3);

text3=new JTextField();
text3.setBounds(870, 270, 250, 30);
contentPane.add(text3);

JLabel label4=new JLabel("Issue Date");
label4.setBounds(750,300,150,50);
contentPane.add(label4);

 text4=new JTextField();
text4.setBounds(870,310,250,30);
contentPane.add(text4);

JLabel label5=new JLabel("Due Date");
label5.setBounds(750,340,150,50);
contentPane.add(label5);

 text5=new JTextField();
text5.setBounds(870,350,250,30);
contentPane.add(text5);

JButton b1=new JButton("Issue");
b1.addActionListener(this);
b1.setBackground(Color.WHITE);
b1.setBounds(770,460,100,50);
contentPane.add(b1);


JButton b2=new JButton("Back");
b2.addActionListener(this);
b2.setBackground(Color.WHITE);
b2.setBounds(990,460,100,50);
contentPane.add(b2);
contentPane.setVisible(true);
setLayout(new BorderLayout());
    JLabel jl3=new JLabel(new ImageIcon("D:\\BCA/Code/fix.jpg"));
    jl3.setBounds(0,0,1920,1080);
    contentPane.add(jl3);
    jl3.setLayout(new FlowLayout());
}
public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==c1){
try{
String bid;
bid=c1.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
Connection con = DriverManager.getConnection("jdbc:odbc:LMS","","");
            st = con.createStatement();
            rs = st.executeQuery("select B_name from View_Books WHERE Book_ID="+bid);
            while(rs.next()) {
  		text3.setText(rs.getString("B_name"));
	}
		st.close();
            rs.close();
        } catch (Exception e) {
        }
}
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
try
{
if(s.equals("Issue"))
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String st="INSERT INTO Issue_Book VALUES (?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
String bid,id,name;
bid=c1.getSelectedItem().toString();
id=c3.getSelectedItem().toString();
String st1="UPDATE View_Books set Count=Count-1 WHERE Book_ID="+bid;
PreparedStatement ps1=con.prepareStatement(st1);

ps.setString(1, bid);
ps.setString(2, id);
ps.setString(3,text3.getText());
ps.setString(4,text4.getText());
ps.setString(5,text5.getText());

ps.executeUpdate();
c1.setSelectedItem("");
c3.setSelectedItem("");
text3.setText("");
text4.setText("");
text5.setText("");
JOptionPane.showMessageDialog(this,"Issued");
ps1.executeUpdate();

con.close();

System.out.println("Added");


}
if(s.equals("Back")){
Home.main(new String[]{});
this.dispose();
}
}
catch(Exception e){
}
}
public static void main(String args[]){
Content4 c1=new Content4("Library Management System");
c1.setExtendedState(JFrame.MAXIMIZED_BOTH);
c1.setVisible(true);
}
}