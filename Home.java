import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Home extends JFrame implements ActionListener
{
JPanel p;
JTextField jtf1;
JLabel j15;
JPasswordField jtf2;
JButton New_studentBtn;
JButton New_teacherBtn;
JButton New_bookBtn;
JButton View_bookBtn;
JButton Issue_bookBtn;
JButton Return_bookBtn;
JButton StatisticsBtn;
JButton LogoutBtn;
JFrame contentPane;
public Home(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
setTitle("LIBRARY MANAGEMENT SYSTEM");
setExtendedState(JFrame.MAXIMIZED_BOTH);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setVisible(true);

JLabel jl1=new JLabel("LIBRARY MANAGEMENT SYSTEM");
jl1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,25));
jl1.setBounds(700,130,500,50);
contentPane.add(jl1);

New_studentBtn=new JButton("NEW STUDENT");
New_studentBtn.setBackground(Color.WHITE);
New_studentBtn.addActionListener(this);
New_studentBtn.setBounds(800,210,150,50);
contentPane.add(New_studentBtn);

New_teacherBtn=new JButton("NEW TEACHER");
New_teacherBtn.setBackground(Color.WHITE);
New_teacherBtn.addActionListener(this);
New_teacherBtn.setBounds(800,270,150,50);
contentPane.add(New_teacherBtn);

New_bookBtn=new JButton("NEW BOOK");
New_bookBtn.setBackground(Color.WHITE);
New_bookBtn.addActionListener(this);
New_bookBtn.setBounds(800,330,150,50);
contentPane.add(New_bookBtn);

View_bookBtn=new JButton("VIEW BOOK");
View_bookBtn.setBackground(Color.WHITE);
View_bookBtn.addActionListener(this);
View_bookBtn.setBounds(800,390,150,50);
contentPane.add(View_bookBtn);

Issue_bookBtn=new JButton("ISSUE BOOK");
Issue_bookBtn.setBackground(Color.WHITE);
Issue_bookBtn.addActionListener(this);
Issue_bookBtn.setBounds(800,450,150,50);
contentPane.add(Issue_bookBtn);

Return_bookBtn=new JButton("RETURN BOOK");
Return_bookBtn.setBackground(Color.WHITE);
Return_bookBtn.addActionListener(this);
Return_bookBtn.setBounds(800,510,150,50);
contentPane.add(Return_bookBtn);

StatisticsBtn=new JButton("STATISTICS");
StatisticsBtn.setBackground(Color.WHITE);
StatisticsBtn.addActionListener(this);
StatisticsBtn.setBounds(800,570,150,50);
contentPane.add(StatisticsBtn);

LogoutBtn=new JButton("LOGOUT");
LogoutBtn.setBackground(Color.WHITE);
LogoutBtn.addActionListener(this);
LogoutBtn.setBounds(800,630,150,50);
contentPane.add(LogoutBtn);
this.setExtendedState(JFrame.MAXIMIZED_BOTH);
contentPane.setVisible(true);

setLayout(new BorderLayout());
    JLabel jl3=new JLabel(new ImageIcon("D:\\BCA/Code/fix.jpg"));
    jl3.setBounds(0,0,900,900);
    contentPane.add(jl3);
    jl3.setLayout(new FlowLayout());
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
Vector colname=new Vector();
Vector data=new Vector();
try
{
if(s.equals("NEW STUDENT"))
{
Content1.main(new String[]{});
this.dispose();
}
else if(s.equals("NEW TEACHER"))
{
Content2.main(new String[]{});
this.dispose();
}
else if(s.equals("NEW BOOK"))
{
Content3.main(new String[]{});
this.dispose();
}
else if(s.equals("VIEW BOOK"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:LMS","","");
String sql="SELECT * FROM View_Books ";
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
JFrame jf=new JFrame("View Books");
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
else if(s.equals("ISSUE BOOK"))
{
Content4.main(new String[]{});
this.dispose();
}
else if(s.equals("RETURN BOOK"))
{
Content5.main(new String[]{});
this.dispose();
}

else if(s.equals("STATISTICS"))
{
Statistics.main(new String[]{});
this.dispose();
}
else if(s.equals("LOGOUT"))
{
admlogin.main(new String[]{});
this.dispose();
}
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
public static void main(String args[]){
Home a=new Home("Home");
a.setExtendedState(JFrame.MAXIMIZED_BOTH);
a.setVisible(true);
}
}
