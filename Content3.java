import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Content3 extends JFrame implements ActionListener
{
JTextField j1;
JLabel l1;
JPasswordField pf1;
JTextField text1,text2,text3,text4,text5;
JFrame contentPane;
public Content3(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
setTitle("LIBRARY MANAGEMENT SYSTEM");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);

l1=new JLabel();

JLabel title=new JLabel("New Book");
title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
contentPane.add(title);
title.setBounds(860,120,450,50);

JLabel label1=new JLabel("Book ID");
label1.setBounds(750,180,100,50);
contentPane.add(label1);

text1=new JTextField();
text1.setBounds(850,190,250,30);
contentPane.add(text1);

JLabel label2=new JLabel("Book Name");
label2.setBounds(750,220,100,50);
contentPane.add(label2);

text2=new JTextField();
text2.setBounds(850,230,250,30);
contentPane.add(text2);

JLabel label3=new JLabel("Author");
label3.setBounds(750,260,100,50);
contentPane.add(label3);

 text3=new JTextField();
text3.setBounds(850,270,250,30);
contentPane.add(text3);

JLabel label4=new JLabel("Year");
label4.setBounds(750,300,100,50);
contentPane.add(label4);

text4=new JTextField();
text4.setBounds(850,310,250,30);
contentPane.add(text4);

JLabel label5=new JLabel("No.of Books");
label5.setBounds(750,340,100,50);
contentPane.add(label5);

text5=new JTextField();
text5.setBounds(850,350,250,30);
contentPane.add(text5);

JButton b1=new JButton("Save");
b1.addActionListener(this);
b1.setBackground(Color.WHITE);
b1.setBounds(700,460,100,50);
contentPane.add(b1);

JButton b3=new JButton("Delete");
b3.addActionListener(this);
b3.setBackground(Color.WHITE);
b3.setBounds(830,460,100,50);
contentPane.add(b3);

JButton b4=new JButton("Update");
b4.addActionListener(this);
b4.setBackground(Color.WHITE);
b4.setBounds(960,460,100,50);
contentPane.add(b4);

JButton b2=new JButton("Back");
b2.addActionListener(this);
b2.setBackground(Color.WHITE);
b2.setBounds(1090,460,100,50);
contentPane.add(b2);
contentPane.setVisible(true);
setLayout(new BorderLayout());
    JLabel jl3=new JLabel(new ImageIcon("D:\\BCA/Code/fix.jpg"));
    jl3.setBounds(0,0,1920,1080);
    contentPane.add(jl3);
    jl3.setLayout(new FlowLayout());
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
try
{
if(s.equals("Save"))
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String st="INSERT INTO View_Books VALUES (?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,text1.getText());
ps.setString(2,text2.getText());
ps.setString(3,text3.getText());
ps.setString(4,text4.getText());
ps.setString(5,text5.getText());
ps.executeUpdate();
con.close();
text1.setText("");
text2.setText("");
text3.setText("");
text4.setText("");
text5.setText("");

JOptionPane.showMessageDialog(this,"Added successfully");
System.out.println("Added");
}
else if(s.equals("Back")){
Home.main(new String[]{});
this.dispose();
}
else if(s.equals("Delete")){
String bid;
bid=text1.getText();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String st2="DELETE FROM View_Books where Book_ID="+bid;
PreparedStatement ps2=con.prepareStatement(st2);
ps2.executeUpdate();
con.close();
text1.setText("");
JOptionPane.showMessageDialog(this,"Deleted");
System.out.println("Removed");
}
else if(s.equals("Update")){
String bid,c;
bid=text1.getText();
c=text5.getText();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String st2="UPDATE View_Books set Count=? where Book_ID="+bid;
PreparedStatement ps2=con.prepareStatement(st2);
ps2.setString(1,c);
ps2.executeUpdate();
con.close();
text1.setText("");
text5.setText("");
JOptionPane.showMessageDialog(this,"Updated");
System.out.println("Updated");
}
}
catch(Exception e){
}
}
public static void main(String args[]){
Content3 c1=new Content3("Library Management System");
c1.setExtendedState(JFrame.MAXIMIZED_BOTH);
c1.setVisible(true);
}
}
