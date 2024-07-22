import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class homepage extends JFrame implements ActionListener
{
public homepage(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);
//setTitle("LIBRARY MANAGEMENT SYSTEM");
setDefaultCloseOperation(EXIT_ON_CLOSE);
//setVisible(true);

JLabel j11=new JLabel("Library Management System ");
j11.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,35));
j11.setForeground(Color.BLACK);
j11.setBounds(750,170,500,100);
contentPane.add(j11);

JButton jb1=new JButton("Login");
jb1.addActionListener(this);
jb1.setBackground(Color.WHITE);
jb1.setBounds(880,300,150,70);
contentPane.add(jb1);
setLayout(new BorderLayout());
    JLabel jl3=new JLabel(new ImageIcon("D:\\BCA/Code/fix.jpg"));
    jl3.setBounds(0,0,900,900);
    contentPane.add(jl3);
    jl3.setLayout(new FlowLayout());
contentPane.setSize(1920,1080);
contentPane.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
try
{
if(s.equals("Login"))
{
admlogin b=new admlogin("next");
b.setExtendedState(JFrame.MAXIMIZED_BOTH);
b.setVisible(true);
this.dispose();
}
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
public static void main(String args[])
{
homepage a=new homepage("Welcome");
a.setTitle("LIBRARY MANAGEMENT SYSTEM");
//a.setExtendedState(JFrame.MAXIMIZED_BOTH);
//a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
a.setSize(800,800);
a.setVisible(true);
}
}









