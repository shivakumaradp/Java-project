package com.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginForm {

	public JFrame frmTutionApp;
	public JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            //here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmTutionApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	ImageIcon ok = new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\ok.png");
	ImageIcon clear = new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\Clear.png");
	private JPasswordField password;
	/**
	 * Create the application.
	 */
	
	Connection conn=null;
	
	public LoginForm() {
		initialize();
		conn = SqliteConnection.dbconnector();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTutionApp = new JFrame();
		frmTutionApp.setResizable(false);
		frmTutionApp.setTitle("TUTION APP");
		frmTutionApp.setBounds(100, 100, 565, 321);
		frmTutionApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTutionApp.getContentPane().setLayout(null);
		
		
		frmTutionApp.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(329, 42, 100, 33);
		frmTutionApp.getContentPane().add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.GREEN);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(231, 93, 115, 26);
		frmTutionApp.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 255, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(231, 130, 115, 26);
		frmTutionApp.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(371, 93, 145, 26);
		frmTutionApp.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("Login",ok);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query = "select * from Login where Username=? and Password=?";
					
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, username.getText());
					pst.setString(2, password.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count=0;
					
					while(rs.next()) {
						count++;
						
						String uname=rs.getString(1);
						
						String pass=rs.getString(2);
						
						
							if(uname.equalsIgnoreCase("pooja") && pass.equalsIgnoreCase("shetty")) {
								//TutionHomePage load = new TutionHomePage();
								HomePage load=new HomePage();
								load.setVisible(true);
								uname=username.getText();
								String fname = uname.toUpperCase();
								load.u=fname;
								load.display();
								load.currentdatetime();
								frmTutionApp.dispose();
							}
							
					}
					if(count!=1) {
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password !!!!");
					}
					
					pst.close();
					rs.close();
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(231, 194, 130, 38);
		frmTutionApp.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("Clear",clear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username.setText("");
				password.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(386, 194, 130, 38);
		frmTutionApp.getContentPane().add(btnClear);
		
		JLabel lbllogin = new JLabel("");
		lbllogin.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\login.png"));
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setBounds(31, 52, 171, 180);
		frmTutionApp.getContentPane().add(lbllogin);
		
		password = new JPasswordField();
		password.setBounds(371, 130, 145, 26);
		frmTutionApp.getContentPane().add(password);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\bg.png"));
		lblNewLabel_1.setBounds(0, 0, 559, 295);
		frmTutionApp.getContentPane().add(lblNewLabel_1);
	}
}
