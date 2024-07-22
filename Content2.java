import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Content2 extends JFrame implements ActionListener
{
JTextField j1;
JLabel l1;
JPasswordField pf1;
JTextField text1,text2,text4;
JFrame contentPane;

public Content2(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
setTitle("LIBRARY MANAGEMENT SYSTEM");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);

l1=new JLabel();

JLabel title=new JLabel("New Teacher");
title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
contentPane.add(title);
title.setBounds(840,170,450,50);


JLabel label1=new JLabel("Teacher ID");
label1.setBounds(750,250,100,50);
contentPane.add(label1);

text1=new JTextField();
text1.setBounds(850,260,250,30);
contentPane.add(text1);


JLabel label2=new JLabel("Name");
label2.setBounds(750,290,100,50);
contentPane.add(label2);

text2=new JTextField();
text2.setBounds(850,300,250,30);
contentPane.add(text2);


JLabel label4=new JLabel("Department");
label4.setBounds(750,330,100,50);
contentPane.add(label4);

text4=new JTextField();
text4.setBounds(850,340,250,30);
contentPane.add(text4);

JButton b1=new JButton("Save");
b1.addActionListener(this);
b1.setBackground(Color.WHITE);
b1.setBounds(750,450,100,50);
contentPane.add(b1);

JButton b3=new JButton("Delete");
b3.addActionListener(this);
b3.setBackground(Color.WHITE);
b3.setBounds(880,450,100,50);
contentPane.add(b3);

JButton b2=new JButton("Back");
b2.addActionListener(this);
b2.setBackground(Color.WHITE);
b2.setBounds(1010,450,100,50);
contentPane.add(b2);
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
String st="INSERT INTO Teacher VALUES (?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,text1.getText());
ps.setString(2,text2.getText());
ps.setString(3,text4.getText());
ps.executeUpdate();
con.close();
text1.setText("");
text2.setText("");
text4.setText("");
JOptionPane.showMessageDialog(this,"Added successfully");
System.out.println("Added");
}
if(s.equals("Back")){
Home.main(new String[]{});
this.dispose();
}
if(s.equals("Delete")){
String bid;
bid=text1.getText();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String st2="DELETE FROM Teacher where T_ID="+bid;
PreparedStatement ps2=con.prepareStatement(st2);
ps2.executeUpdate();
con.close();
text1.setText("");
JOptionPane.showMessageDialog(this,"Deleted");
System.out.println("Removed");

}
}
catch(Exception e){
}
}
public static void main(String args[]){
Content2 c1=new Content2("Library Management System");
c1.setExtendedState(JFrame.MAXIMIZED_BOTH);
c1.setVisible(true);
}
}
