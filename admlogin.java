import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class admlogin extends JFrame implements ActionListener
{

JTextField jtf1;
JLabel jl5;
JPasswordField jtf2;
JFrame contentPane;
public admlogin(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
setTitle("LIBRARY MANAGEMENT SYSTEM");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);


JLabel jl1=new JLabel("Library Management System");
jl1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,35));
jl1.setForeground(Color.BLACK);
jl1.setBounds(750,120,500,100);
contentPane.add(jl1);
JLabel jl2=new JLabel("Username");
jl2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
jl2.setForeground(Color.BLACK);
jl2.setBounds(780,240,100,50);
contentPane.add(jl2);
jtf1=new JTextField(15);
jtf1.setBounds(880,250,250,30);
contentPane.add(jtf1);
JLabel jl3=new JLabel("Password");
jl3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,19));
jl3.setBounds(780,300,100,50);
contentPane.add(jl3);
jtf2=new JPasswordField(15);
jtf2.setBounds(880,310,250,30);
contentPane.add(jtf2);
JButton jb1=new JButton("Login");
jb1.setBackground(Color.WHITE);
jb1.addActionListener(this);
jb1.setBounds(770,400,120,50);
contentPane.add(jb1);
JButton jb2=new JButton("Cancel");
jb2.setBackground(Color.WHITE);
jb2.addActionListener(this);
jb2.setBounds(990,400,120,50);
contentPane.add(jb2);
setLayout(new BorderLayout());
    JLabel jl4=new JLabel(new ImageIcon("D:\\BCA/Code/fix.jpg"));
    jl4.setBounds(0,0,1920,1080);
    contentPane.add(jl4);
    jl4.setLayout(new FlowLayout());

}

public void actionPerformed(ActionEvent ae)
{
String ul=" ",pl=" ";
String s=ae.getActionCommand();
String u=jtf1.getText();
String p=jtf2.getText();
if(s.equals("Cancel")){
homepage a=new homepage("Welcome");
a.setExtendedState(JFrame.MAXIMIZED_BOTH);
a.setSize(1920,1080);
a.setVisible(true);
this.dispose();
}
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS"," "," ");
String st="Select*from Login where Username=?";
PreparedStatement ps=con.prepareStatement(st);  
ps.setString(1,u);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
ul=rs.getString("Username");
pl=rs.getString("Password");
if(ul.equals(u) &&pl.equals(p))
{
JOptionPane.showMessageDialog(this,"Login Successfully");
if(s.equals("Login"))
{
Home.main(new String[]{});
this.dispose();
}
}
else
{
JOptionPane.showMessageDialog(this,"Wrong password");
}
}
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
public static void main(String args[]){
admlogin a=new admlogin("Login");
//a.setExtendedState(JFrame.MAXIMIZED_BOTH);
a.setVisible(true);
}
}



