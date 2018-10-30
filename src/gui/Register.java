/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


/*FOURTH - SIGNUP PAGE*/

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.*;

public class Register extends JFrame implements ActionListener
{
	
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JPasswordField p1,p2,p3,p4;
	JTextField t1,t2,t3,t4,t5;
	TextArea ta1;
	JRadioButton r1;
	JComboBox cb1;
	JCheckBox ch1;
	JButton b1,b2,b3,b4;
   JPanel jp1,jp2,jp3;
	Container g;
	Cursor cur;
	Connection cn;
	Statement st;
	ResultSet rs;
	
	public Register()
	{
		this.setLayout(null);
	    this.setVisible(true);
	    this.setTitle("Register");
	    this.setResizable(false);
	    this.setBounds(10,10,1010,600);
	    
	    Font f1 = new Font("Arial Rounded MT Bold",30,30);
	    Font f2 = new Font("Arial",Font.PLAIN,30);   
	    Font f3 = new Font("Arial",20,20);           //TextArea
	    Font f4 = new Font("Arial",Font.BOLD,20);    
       Font f5 = new Font("Arial",Font.BOLD,22);   //Buttons
	    cur = new Cursor(Cursor.HAND_CURSOR);
       Border br1 = BorderFactory.createLineBorder(new Color(0,100,0),3);
	    
	    g = getContentPane();
	    g.setBackground(new Color(217,255,230));
	    
	    l0= new JLabel("New User - SignUp");
	    l0.setBounds(365,20,280,40);
       l0.setForeground(Color.WHITE);
	    l0.setFont(f1);
	    add(l0);
	    
	    l1 = new JLabel("Name");
	    l1.setBounds(100,120,100,35);
	    l1.setFont(f2);
	    add(l1);
	    
	    t1 = new JTextField();
	    t1.setBounds(265,120,220,35);
	    t1.setFont(f2);
       t1.setBorder(br1);
	    add(t1);
	    
	    l2 = new JLabel("Email");
	    l2.setBounds(540,120,100,35);
	    l2.setFont(f2);
	    add(l2);
	    
	    t2 = new JTextField();
	    t2.setBounds(750,120,220,35);
       t2.setBorder(br1);
	    t2.setFont(f2);
	    add(t2);
	    
	    
	    l3 = new JLabel("Password");
	    l3.setBounds(100,180,150,35);
	    l3.setFont(f2);
	    add(l3);
	    
	    p1 = new JPasswordField();
	    p1.setBounds(265,180,220,35);
	    p1.setFont(f2);
       p1.setBorder(br1);
	    add(p1);
	    
	    l4 = new JLabel("Re Password");
	    l4.setBounds(540,180,200,35);
	    l4.setFont(f2);
	    add(l4);
	    
	    p2 = new JPasswordField();
	    p2.setBounds(750,180,220,35);
	    p2.setFont(f2);
       p2.setBorder(br1);
	    add(p2);
	    
	    l5 = new JLabel("Mobile No.");
	    l5.setBounds(100,240,200,35);
	    l5.setFont(f2);
	    add(l5);
	    
	    t3 = new JTextField();
	    t3.setBounds(265,240,220,35);
	    t3.setFont(f2);
       t3.setBorder(br1);
	    add(t3);
	    
	    l6 = new JLabel("State");
	    l6.setBounds(540,240,200,35);
	    l6.setFont(f2);
	    add(l6);
	    
	    t4 = new JTextField("Punjab");
	    t4.setBounds(750,240,220,35);
	    t4.setEditable(false);
	    t4.setFont(f2);
       t4.setBorder(br1);
	    add(t4);
       
	    
	    l7 = new JLabel("City");
	    l7.setBounds(100,300,100,35);
	    l7.setFont(f2);
	    add(l7);
	    
	    cb1 = new JComboBox();
	    cb1.setBounds(265,300,220,35);
	    cb1.setFont(f2);
       cb1.setBorder(br1);
	    cb1.addItem("Select");
	    cb1.addItem("Amritsar");
	    cb1.addItem("Jalandhar");
	    cb1.addItem("Ludhiana");
	    add(cb1);
	    
	    l8 = new JLabel("Address");
	    l8.setBounds(540,300,150,35);
	    l8.setFont(f2);
	    add(l8);
	   
	    ta1 = new TextArea();
	    ta1.setBounds(753,303,214,89);
	    ta1.setFont(f3);
	    add(ta1);
       
       jp3 = new JPanel();                  //Address Panel - Border
       jp3.setBounds(750,300,220,95);
       jp3.setBackground(new Color(0,100,0));
       add(jp3);
	    
	    l9 = new JLabel("Pin Code");
	    l9.setBounds(100,360,150,35);
	    l9.setFont(f2);
	    add(l9);
	    
	    t5 = new JTextField();
	    t5.setBounds(265,360,220,35);
	    t5.setFont(f2);
       t5.setBorder(br1);
	    add(t5);

	    
	    ch1 = new JCheckBox("I Agree To All The");
	    ch1.setBounds(350,440,200,35);
	    ch1.setOpaque(false);
	    ch1.setFont(f4);
	    add(ch1);
	    
	    l10 = new JLabel("Terms & Conditions");
	    l10.setBounds(550,440,200,35);
	    l10.setForeground(Color.RED);
	    l10.setCursor(cur);
	    l10.setFont(f4);
	    add(l10);
	     
       b1 = new JButton("Back");               //Back
	    b1.setBounds(180,500,200,50);
	    b1.setCursor(cur);
	    b1.setFont(f5);
       b1.setBorder(br1);
	    add(b1);
	   
	    b2 = new JButton("Clear");             //Clear
	    b2.setBounds(445,500,200,50);
	    b2.setCursor(cur);
	    b2.setFont(f5);
       b2.setBorder(br1);
	    add(b2);
	     
	    b3 = new JButton("Create Account");    //Create Account
	    b3.setBounds(710,500,200,50);
	    b3.setCursor(cur);
	    b3.setFont(f5);
       b3.setBorder(br1);
	    add(b3);
       
       jp1 = new JPanel();                 //Vertical Left Panel
       jp1.setBounds(0,0,80,730);
       jp1.setBackground(new Color(0,100,0));
       add(jp1);
	    
       jp2 = new JPanel();                 //Horizontal Top Panel
       jp2.setBounds(0,0,1010,80);
       jp2.setBackground(new Color(0,100,0));
       add(jp2);
       
       
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    
	    
	  //Database Connectivity
		 
		try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 cn=DriverManager.getConnection("jdbc:mysql://localhost/college","root","root");
			 
			 st = cn.createStatement();
		 }
		 
		 catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(null, ex.getMessage());
		 }
		 
	    
	}
	public static void main(String[] args)
	{
		
		new Register();
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
   
         if(e.getSource() == b1)         //Back
			 {
          
          int a = JOptionPane.showConfirmDialog(null,"You Are Not Successfully Registered \nYour Data Will Be Lost \nAre You Sure You Want To Go Back","Back",JOptionPane.YES_NO_OPTION);
          
          if(a==0)
          {
				 this.hide();
				 new LoginNew();
             }
			 }
          
          
		 if(e.getSource() == b2)      //Clear
		 {
       int b = JOptionPane.showConfirmDialog(null,"Your Details Will Be Cleared \nAre You Sure You Want To Clear","Clear",JOptionPane.YES_NO_OPTION);
          
          if(b==0)
          {
			 t1.setText("");
			 t2.setText("");
			 p1.setText("");
			 p2.setText("");
			 t3.setText("");
			 ta1.setText("");
			 t5.setText("");
			 cb1.setSelectedIndex(0);
			 ch1.setSelected(false);
          }
		 }
		 
		 if(e.getSource() == b3)     //Create Account
		 {
       String email = t2.getText();    // Checks @ in Email
       int no = email.indexOf("@");
       
			 if(t1.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Your Name");
				
			 }
			 
			 else if(t2.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Your Email ID");
				
			 }
			 
  
			 else if(no == -1)
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Valid Email ID");
				
			 }
			 
			 else if(p1.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Your Password");	
			 }
			 
			 else if(p2.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Retype Password");	
			 }
			 
			 else if(t3.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Your Mobile No.");	
			 }
			 
			 else if(cb1.getSelectedIndex() == 0)
			 {
				 JOptionPane.showMessageDialog(null,"Please Choose City");	
			 }
			 
			 else if(ta1.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Your Address");	
			 }
			 
			 else if(t5.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Please Enter Your PinCode");	
			 }
			 
			 else if(ch1.isSelected() == false)
			 {
				 JOptionPane.showMessageDialog(null,"Please Agree To Terms & Conditions");	
			 }
			
			 
			 else 
			 {
				 if(p1.getText().equals (p2.getText()))
				 {
				 try
				 {
					 st.executeUpdate("insert into signup values ('"+t1.getText()+"','"+t2.getText()+"','"+p1.getText()+"','"+t3.getText()+"','"+cb1.getSelectedItem()+"','"+ta1.getText()+"','"+t5.getText()+"')");
					 JOptionPane.showMessageDialog(null,"Successfully Registered. Please Login To Continue");
					 this.hide();
					 new LoginNew();
				 }
				 
				 catch(Exception ex)
				 {
					 JOptionPane.showMessageDialog(null,"Email Id Alredy Exists" + e);
				 }
				 }
				 
				 else
				 {
					 JOptionPane.showMessageDialog(null,"Retype Password Does Not Match");
				 }
			 }
		 }
			 
			 
		 }
		
		
	}



