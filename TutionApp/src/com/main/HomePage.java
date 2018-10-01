package com.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;
import com.main.Calc;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.print.*;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField fathername;
	private JTextField fatherno;
	private JTextField mothername;
	private JTextField address;
	private JTextField motherno;
	private JTextField sclass;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textsearch;
	JLabel lbldate ;
	JLabel lblname;
	JRadioButton rdbtnMale;
	JRadioButton rdbtnFemale;
	JLabel lblpic;
	public String u="";
	//String uname="";
	
	String filename = null;
	byte[] pic = null;
	
	Connection conn;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void currentdatetime() {
		Thread th = new Thread() {
			public void run() {
				for(;;) {
					Calendar cal=new GregorianCalendar();
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int h = cal.get(Calendar.HOUR);
					int m = cal.get(Calendar.MINUTE);
					int s = cal.get(Calendar.SECOND);
					
										
					lbldate.setText("Date - "+day+"/"+(month+1)+"/"+year+"  Time - "+h+":"+m+":"+s);
					lbldate.setVisible(true);
					
					try {
						sleep(1000);
					} catch (Exception e) {
					Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	};
	th.start();
}
			
	public void display() {
		this.lblname.setText("WELCOME "+u);
		lblname.setVisible(true);
	}
	
	public void resetData() {
		fname.setText("");
		lname.setText("");
		fathername.setText("");
		mothername.setText("");
		fatherno.setText("");
		motherno.setText("");
		sclass.setText("");
		address.setText("");
		buttonGroup.clearSelection();
		lblpic.setIcon(null);
		
	}
	
	public void advanceSearch() {
		
		String s=textsearch.getText();
		try {
			String query="select FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass from Student where StudentID =?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, s);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				fname.setText(rs.getString("FirstName"));
				lname.setText(rs.getString("LastName"));
				String gender=rs.getString("Gender");
				if(gender.equalsIgnoreCase("male")) {
					rdbtnMale.setSelected(true);
				}
				else if(gender.equalsIgnoreCase("female")) {
					rdbtnFemale.setSelected(true);
				}
				fathername.setText(rs.getString("FatherName"));
				mothername.setText(rs.getString("MotherName"));
				fatherno.setText(rs.getString("FatherPhoneNo"));
				motherno.setText(rs.getString("MotherPhoneNo"));
				address.setText(rs.getString("Address"));
				sclass.setText(rs.getString("StudentClass"));
				textsearch.setText("");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		try {
			String query="select FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass from Student where FirstName =?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, s);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				fname.setText(rs.getString("FirstName"));
				lname.setText(rs.getString("LastName"));
				String gender=rs.getString("Gender");
				if(gender.equalsIgnoreCase("male")) {
					rdbtnMale.setSelected(true);
				}
				else if(gender.equalsIgnoreCase("female")) {
					rdbtnFemale.setSelected(true);
				}
				fathername.setText(rs.getString("FatherName"));
				mothername.setText(rs.getString("MotherName"));
				fatherno.setText(rs.getString("FatherPhoneNo"));
				motherno.setText(rs.getString("MotherPhoneNo"));
				address.setText(rs.getString("Address"));
				sclass.setText(rs.getString("StudentClass"));
				textsearch.setText("");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		try {
			String query="select FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass from Student where LastName =?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, s);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				fname.setText(rs.getString("FirstName"));
				lname.setText(rs.getString("LastName"));
				String gender=rs.getString("Gender");
				if(gender.equalsIgnoreCase("male")) {
					rdbtnMale.setSelected(true);
				}
				else if(gender.equalsIgnoreCase("female")) {
					rdbtnFemale.setSelected(true);
				}
				fathername.setText(rs.getString("FatherName"));
				mothername.setText(rs.getString("MotherName"));
				fatherno.setText(rs.getString("FatherPhoneNo"));
				motherno.setText(rs.getString("MotherPhoneNo"));
				address.setText(rs.getString("Address"));
				sclass.setText(rs.getString("StudentClass"));
				
				textsearch.setText("");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void getPrint() {
		MessageFormat header = new MessageFormat("Student Table");
		MessageFormat footer=new MessageFormat("Page{1,number,integer}");
		
		try {
			
			table.print(JTable.PrintMode.NORMAL, header, footer);
			
			
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n", e.getMessage());
		}
	}
	
	public void getPic() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		filename=f.getAbsolutePath();
		ImageIcon imgicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblpic.getWidth(), lblpic.getHeight(), Image.SCALE_SMOOTH));
		lblpic.setIcon(imgicon);
		
		try {
			
			File image = new File(filename);
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			
			byte[] buf = new byte[1024];
			
			for(int readnum;(readnum=fis.read(buf))!=-1;) {
				bao.write(buf, 0, readnum);
				
			}
			pic=bao.toByteArray();
			
			fis.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void logout() {
		LoginForm f = new LoginForm();
		f.frmTutionApp.setVisible(true);
		dispose();
	}
	
	public void showTable() {
		try {

			String query = "Select StudentID,FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass from Student";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}

	}

	public void getSelectedData() {
		int i=table.getSelectedRow();
		TableModel model = table.getModel();
			fname.setText(model.getValueAt(i, 1).toString());
			lname.setText(model.getValueAt(i, 2).toString());
			String gender=model.getValueAt(i, 3).toString();
			if(gender.equalsIgnoreCase("male")) {
				rdbtnMale.setSelected(true);
			}
			else {
				rdbtnFemale.setSelected(true);
			}
			
			fathername.setText(model.getValueAt(i, 4).toString());
			mothername.setText(model.getValueAt(i, 5).toString());
			fatherno.setText(model.getValueAt(i, 6).toString());
			motherno.setText(model.getValueAt(i, 7).toString());
			address.setText(model.getValueAt(i, 8).toString());
			sclass.setText(model.getValueAt(i, 9).toString());
			
			try {
				String query="select StudentImage from Student where FirstName='"+fname.getText()+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()) {
					byte[] imagedata = rs.getBytes("StudentImage");
					ImageIcon f = new ImageIcon(imagedata);
					lblpic.setIcon(f);
				}
							
				
			} catch (Exception e) {
				lblpic.setIcon(null);
			}
			
	}
	
	public void deleteData() {
		
		int i=JOptionPane.showConfirmDialog(null, "Do you want to delete the data ?","Delete",JOptionPane.YES_NO_OPTION);
		if(i==0) {
		try {
			String name=fname.getText();
			String query="delete from Student where FirstName=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.execute();
			
			showTable();
			resetData();
			JOptionPane.showMessageDialog(null, "Data Deleted!!!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
	
	public void saveData() {
		try {
			
			String gender = null;
			
			String query="insert into Student (FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass,StudentImage) values (?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,fname.getText() );
			pst.setString(2, lname.getText());
			if(rdbtnMale.isSelected()) {
				gender="Male";
			}
			if(rdbtnFemale.isSelected()) {
				gender="Female";
			}
			
			pst.setString(3, gender);
			pst.setString(4, fathername.getText());
			pst.setString(5, mothername.getText());
			pst.setString(6, fatherno.getText());
			pst.setString(7, motherno.getText());
			pst.setString(8, address.getText());
			pst.setInt(9, (Integer.parseInt(sclass.getText())));
			pst.setBytes(10, pic);

			pst.execute();

			JOptionPane.showMessageDialog(null, "Data Saved");
			
			showTable();

			resetData();
			
			pst.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void updateData() {
		try {
			
			
			String query="Update Student set FirstName='"+fname.getText()+"',LastName='"+lname.getText()+"',FatherName='"+fathername.getText()+"',MotherName='"+mothername.getText()+"',FatherPhoneNo='"+fatherno.getText()+"',MotherPhoneNo='"+motherno.getText()+"',Address='"+address.getText()+"',StudentClass='"+sclass.getText()+"' where FirstName='"+fname.getText()+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Data Updated");
			
			showTable();
			
			pst.close();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public HomePage() {
		conn=SqliteConnection.dbconnector();
		setTitle("Student Management System - Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 10, 1368, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 1332, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\pc1.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(529, 11, 401, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\teacher.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(472, 11, 60, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\createdbyvinay.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(1077, 638, 265, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\sms.png"));
		lblNewLabel_3.setBounds(10, 638, 547, 27);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(699, 181, 631, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getSelectedData();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1","Sumedh", "Jahagirdar", "Male", "Santhosh", "Archana", new Long(9527097889L), new Long(9623970439L), "Purnanagar", "6"},
				{"2","Swaroop", "Padennavar", "Male", "Shreeshail", "Poornima", new Long(9561733686L), new Long(7350253986L), "Purnanagar", "2"},
				{"3","Ajay", "Shetty", "Male", "Mallu", "Laxmi", new Long(6565656565L), new Long(8585858585L), "Gulbarga", "11"},
				{"4","rani", "kjlhkj", "Female", "jhk", "ljkhjkl", new Integer(645456), new Integer(64654), "hjg", "5"},
			},
			new String[] {
				"Student ID","FirstName", "LastName", "Gender", "FatherName", "MotherName", "FatherPhoneNo", "MotherPhoneNo", "Address", "StudentClass"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblStudentTable = new JLabel("Student Table");
		lblStudentTable.setForeground(new Color(138, 43, 226));
		lblStudentTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentTable.setBounds(961, 141, 142, 41);
		contentPane.add(lblStudentTable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 220));
		panel_1.setBorder(new TitledBorder(null, "STUDENT INFO", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(16, 175, 529, 427);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(20, 27, 119, 27);
		panel_1.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		fname = new JTextField();
		fname.setBounds(149, 28, 142, 27);
		panel_1.add(fname);
		fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(20, 76, 119, 27);
		panel_1.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lname = new JTextField();
		lname.setBounds(149, 77, 142, 27);
		panel_1.add(lname);
		lname.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(19, 119, 119, 27);
		panel_1.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		fathername = new JTextField();
		fathername.setBounds(149, 163, 142, 27);
		panel_1.add(fathername);
		fathername.setColumns(10);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(20, 162, 119, 27);
		panel_1.add(lblFatherName);
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMotherName = new JLabel("Mother Name");
		lblMotherName.setBounds(20, 209, 119, 27);
		panel_1.add(lblMotherName);
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		fatherno = new JTextField();
		fatherno.setBounds(149, 260, 142, 27);
		panel_1.add(fatherno);
		fatherno.setColumns(10);
		
		mothername = new JTextField();
		mothername.setBounds(149, 210, 142, 27);
		panel_1.add(mothername);
		mothername.setColumns(10);
		
		JLabel lblFatherPhno = new JLabel("Father Phno");
		lblFatherPhno.setBounds(20, 259, 119, 27);
		panel_1.add(lblFatherPhno);
		lblFatherPhno.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMotherPhno = new JLabel("Mother Phno");
		lblMotherPhno.setBounds(20, 303, 119, 27);
		panel_1.add(lblMotherPhno);
		lblMotherPhno.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		address = new JTextField();
		address.setBounds(149, 348, 142, 27);
		panel_1.add(address);
		address.setColumns(10);
		
		motherno = new JTextField();
		motherno.setBounds(149, 304, 142, 27);
		panel_1.add(motherno);
		motherno.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(20, 347, 119, 27);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblStudentClass = new JLabel("Student Class");
		lblStudentClass.setBounds(20, 386, 119, 27);
		panel_1.add(lblStudentClass);
		lblStudentClass.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		sclass = new JTextField();
		sclass.setBounds(149, 387, 142, 27);
		panel_1.add(sclass);
		sclass.setColumns(10);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(149, 123, 89, 23);
		panel_1.add(rdbtnMale);
		buttonGroup.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(240, 123, 89, 23);
		panel_1.add(rdbtnFemale);
		buttonGroup.add(rdbtnFemale);
		
		lblpic = new JLabel("");
		lblpic.setToolTipText("Add Photo");
		lblpic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblpic.setBounds(368, 34, 142, 156);
		panel_1.add(lblpic);
		
		JButton btnpic = new JButton("Photo");
		btnpic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getPic();
			}
		});
		btnpic.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\attachpic.png"));
		btnpic.setBounds(378, 206, 119, 35);
		panel_1.add(btnpic);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 239, 213));
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Operations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBounds(555, 209, 130, 297);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveData();
			}
		});
		btnsave.setBounds(6, 28, 118, 41);
		panel_2.add(btnsave);
		btnsave.setForeground(new Color(0, 100, 0));
		btnsave.setBackground(new Color(175, 238, 238));
		btnsave.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\save.png"));
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteData();
			}
		});
		btndelete.setBounds(6, 132, 118, 41);
		panel_2.add(btndelete);
		btndelete.setBackground(new Color(238, 232, 170));
		btndelete.setForeground(new Color(255, 0, 0));
		btndelete.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\delete.png"));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		btnUpdate.setBounds(6, 80, 118, 41);
		panel_2.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\update.png"));
		btnUpdate.setForeground(new Color(255, 0, 255));
		btnUpdate.setBackground(new Color(192, 192, 192));
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetData();
			}
		});
		btnClear.setBounds(6, 184, 118, 41);
		panel_2.add(btnClear);
		btnClear.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\Clear.png"));
		btnClear.setForeground(new Color(248, 248, 255));
		btnClear.setBackground(new Color(102, 205, 170));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getPrint();
			}
		});
		btnPrint.setBounds(6, 236, 118, 41);
		panel_2.add(btnPrint);
		btnPrint.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\print.png"));
		btnPrint.setForeground(new Color(0, 0, 128));
		btnPrint.setBackground(Color.WHITE);
		
		textsearch = new JTextField();
		textsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				advanceSearch();
			}
		});
		textsearch.setBounds(16, 133, 218, 31);
		contentPane.add(textsearch);
		textsearch.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Search by Student ID, First Name, Last Name");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));
		lblNewLabel_5.setBackground(new Color(255, 228, 196));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(244, 133, 301, 31);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 255, 255));
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(6, 128, 1336, 488);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 250, 205));
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(6, 627, 1346, 38);
		contentPane.add(panel_4);
		
		lbldate = new JLabel("");
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldate.setBounds(20, 88, 376, 21);
		contentPane.add(lbldate);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				logout();
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(255, 99, 71));
		btnNewButton_2.setToolTipText("Log Out");
		btnNewButton_2.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\out.png"));
		btnNewButton_2.setBounds(1188, 88, 70, 41);
		contentPane.add(btnNewButton_2);
		
		lblname = new JLabel("");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblname.setBounds(961, 96, 199, 21);
		contentPane.add(lblname);
		
		JButton button = new JButton("");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		button.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\close.png"));
		button.setToolTipText("Close the system");
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(1272, 88, 70, 41);
		contentPane.add(button);
		
		showTable();
		currentdatetime();
	}
}
