/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import org.opencv.core.Core;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class LoginNew extends JFrame implements ActionListener, FocusListener
{

	JLabel l0,l1,l2,l3,l4,l5;   //l0 - for image
	JTextField t1; 
	JPasswordField p1;
	JButton b6,b7,b8;
	JPanel jp1;
	Cursor cr;
   ImageIcon img0,img1,img2,img3,img4;
   JLabel li1,li2;
   char ch;
	Connection cn;
	Statement st;
	ResultSet rs;
        
        JLabel lname;
  
  
	Font f1 = new Font("Arial Rounded MT Bold",25,25);  //Label
	Font f2 = new Font("Arial Rounded MT Bold",Font.PLAIN,20); //TextField
        Font fname = new Font("Algerian",Font.BOLD,30);
	
	Border br1 = BorderFactory.createLineBorder(Color.BLUE,4);
	Border br2 = BorderFactory.createLineBorder(Color.BLACK,1);
	Border br3 = BorderFactory.createLineBorder(Color.WHITE,2);
        Border br4 = BorderFactory.createLineBorder(Color.RED,2);  //Hidden Fields

	
	public LoginNew()
	{
		 this.setLayout(null);
		 this.setVisible(true);
	    this.setTitle("Login Page");
	    //this.setResizable(false);
	    this.setBounds(10,10,910,630);
	    
	    cr = new Cursor(Cursor.HAND_CURSOR); 
            
            lname = new JLabel("Face Detection");
            lname.setBounds(35, 30, 300, 40);
            lname.setFont(fname);
            lname.setForeground(Color.WHITE);
            add(lname);
            
        b6 =new JButton("LOGIN PANEL");  //Login Panel - Name
	b6.setBounds(80,180,200,40);
	b6.setBackground(Color.CYAN);
	b6.setFont(f1);
	b6.setBorder(br1);
	add(b6);
       
      
      t1 = new JTextField("Email");     //Email
      t1.setBounds(80,250,230,40);  //previous 410
      t1.setOpaque(false);
      t1.setForeground(Color.WHITE);
      t1.setFont(f2);
      t1.setBorder(br3);
      add(t1);
      
      li1 = new JLabel();             //UserName Icon
      img1 = new ImageIcon("C:\\Users\\my pc\\Desktop\\Face Detection\\Pics Used\\username.jpg");
      li1.setBounds(40,250,40,40);
      li1.setIcon(img1);
      add(li1);
      
      p1 = new JPasswordField("Password");   //Password
      p1.setBounds(80,310,230,40);
      p1.setForeground(new Color(150,150,150));
      p1.setOpaque(false);
      ch = p1.getEchoChar();
      p1.setEchoChar((char) 0);
      p1.setForeground(Color.WHITE);
      p1.setBorder(br3);
      p1.setFont(f2);
      add(p1);
      
      li2 = new JLabel();               //Password Icon
      img2 = new ImageIcon("C:\\Users\\my pc\\Desktop\\Face Detection\\Pics Used\\password icon.jpg");
      li2.setBounds(40,310,40,40);
      li2.setIcon(img2);
      add(li2);
      
      
      img3 = new ImageIcon("C:\\Users\\my pc\\Desktop\\Face Detection\\Pics Used\\login now.jpg");
      b7 = new JButton(img3);                //LogIn
      b7.setBounds(100,385,154,40); 
		b7.setFocusPainted(false);
      b7.setOpaque(false);
		b7.setContentAreaFilled(false); 
      b7.setCursor(cr);
	   add(b7);
      
      img4 = new ImageIcon("C:\\Users\\my pc\\Desktop\\Face Detection\\Pics Used\\signup.jpg");
      b8 = new JButton(img4);               // Sign Up
      b8.setBounds(70,450,209,40);  
		b8.setFocusPainted(false);
		b8.setContentAreaFilled(false); 
      b8.setCursor(cr);
	   add(b8);
		
		
		 jp1 = new JPanel();                        //PANEL
		 jp1.setBounds(25,120,300,420);  
		 jp1.setBackground(new Color(255,119,119));
		 //jp1.setBackground(new Color(255,0,102));
       //jp1.setOpaque(false);
       jp1.setBackground(null);
       //jp1.setFocusPainted(false);
       //jp1.setContentAreaFilled(false);
       jp1.setOpaque(false);
		 jp1.setBorder(br3);
		 add(jp1);
       
       
        img0 = new ImageIcon("C:\\Users\\my pc\\Desktop\\Face Detection\\Pics Used\\face.jpg");  //Background Image
       l0 = new JLabel();
       l0.setBounds(0,0,900,590);
       l0.setIcon(img0);
       add(l0);
      
       
       
		//Database Connectivity
		 
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 cn=DriverManager.getConnection("jdbc:mysql://localhost/college","root","");
			 
			 st = cn.createStatement();
		 }
		 
		 catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(null, ex.getMessage());
		 }
		 
		 b7.addActionListener(this);
		 b8.addActionListener(this);
		 t1.addFocusListener(this);
		 p1.addFocusListener(this);
		 
		
	}

	public static void main(String[] args)
	{
		new LoginNew();
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

	}
	
	public void actionPerformed(ActionEvent ar)
	{

			
		if(ar.getSource()==b7)         //b7 - LogIn
		{

			  try
			  {
			  rs = st.executeQuery("select * from signup where Email = '"+t1.getText()+"' and Password = '"+p1.getText()+"'");
			
			if(rs.next())
			{
				String email1=t1.getText();
				String password = p1.getText();
                                new faceDet(email1).setVisible(true);
				this.hide();
                               // new initComponents();
                                
                                //this.hide();
			}
			
			else
			{
			 JOptionPane.showMessageDialog(null,"Invalid Email Id Or Password");
			}
			}
			
			catch(Exception ex)
			{
			 JOptionPane.showMessageDialog(null,"ex.getMessage()");
			}
			 
		
		}
		
		if(ar.getSource()==b8)          //b8 - SignUp
		{
			this.hide();
			new Register();
		}

      
	}

	public void focusGained(FocusEvent ar) 
	{
		if(ar.getSource()==t1)                       //Email Field
		{
        if(t1.getText().equals ("Email"))
      {
      t1.setText("");				
       }
			
			t1.setForeground(Color.WHITE);
		}
		
		if(ar.getSource()==p1)                      //Password Field
		{
      if(p1.getText().equals ("Password"))
      {
			p1.setText("");		
       }
        p1.setForeground(Color.WHITE);
		p1.setEchoChar(ch);
		}
	}
   
   public void focusLost(FocusEvent ar)
   {
   }
}

