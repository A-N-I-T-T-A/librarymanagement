import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class Statistics extends JFrame implements ActionListener
{
JTextField jtf1;
JLabel jl5;
JFrame contentPane;
JPanel p;
public Statistics(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
setTitle("LIBRARY MANAGEMENT SYSTEM");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);


JLabel j11=new JLabel("STATISTICS");
j11.setFont(new Font("Times New Roman", Font.PLAIN, 32));
j11.setBounds(860,150,450,100);
contentPane.add(j11);

JButton jb1=new JButton("Issued Books");
jb1.addActionListener(this);
jb1.setBackground(Color.WHITE);
jb1.setBounds(855,250,200,50);
contentPane.add(jb1);

JButton jb2=new JButton("Returned Books");
jb2.addActionListener(this);
jb2.setBackground(Color.WHITE);
jb2.setBounds(855,350,200,50);
contentPane.add(jb2);

JButton jb3=new JButton("Back");
jb3.addActionListener(this);
jb3.setBackground(Color.WHITE);
jb3.setBounds(855,450,200,50);
contentPane.add(jb3);
contentPane.setVisible(true);
setLayout(new BorderLayout());
    JLabel jl4=new JLabel(new ImageIcon("D:\\BCA/Code/fix.jpg"));
    jl4.setBounds(0,0,900,900);
    contentPane.add(jl4);
    jl4.setLayout(new FlowLayout());
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
Vector colname=new Vector();
Vector data=new Vector();
try
{
if(s.equals("Issued Books"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String sql="SELECT * FROM Issue_Book";
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
ResultSetMetaData md=rs.getMetaData();

int col=md.getColumnCount();
for(int i=1;i<=col;i++)
{
colname.addElement(md.getColumnName(i));
}
while(rs.next())
{
Vector row=new Vector(col);
for(int i=1;i<=col;i++)
{
row.addElement(rs.getObject(i));
}
data.addElement(row);
}
JTable table=new JTable(data,colname);
JScrollPane sp=new JScrollPane(table);
p=new JPanel();
JFrame jf=new JFrame("Issued Books");
jf.setContentPane(p);
jf.setLayout(new BorderLayout());
jf.add(sp);
jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
jf.setVisible(true);
jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

}
catch(Exception e)
{
System.out.println(e);
}
}
else if(s.equals("Returned Books"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String sql="SELECT * FROM Return_Book ";
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
ResultSetMetaData md=rs.getMetaData();

int col=md.getColumnCount();
for(int i=1;i<=col;i++)
{
colname.addElement(md.getColumnName(i));
}
while(rs.next())
{
Vector row=new Vector(col);
for(int i=1;i<=col;i++)
{
row.addElement(rs.getObject(i));
}
data.addElement(row);
}
JTable table=new JTable(data,colname);
JScrollPane sp=new JScrollPane(table);
p=new JPanel();
JFrame jf=new JFrame("Returned Books");
jf.setContentPane(p);
jf.setLayout(new BorderLayout());
jf.add(sp);
jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
jf.setVisible(true);
jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

}
catch(Exception e)
{
System.out.println(e);
}
}
else if(s.equals("Back")){
Home.main(new String[]{});
this.dispose();
}
}
catch(Exception e)
{
//System.out.println("Error"+e);
}
}
public static void main(String args[]) throws Exception
{
Statistics a=new Statistics(" ");
a.setExtendedState(JFrame.MAXIMIZED_BOTH);
a.setVisible(true);
}
}

