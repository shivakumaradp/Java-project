package com.main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TutionHomePage extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JTextField fname;
	public JTextField lname;
	public JTextField mothername;
	public JTextField fathername;
	public JTextField sclass;
	public JTextField address;
	public JTextField fno;
	public JTextField mno;
	JPanel panel;
	JPanel panel_2 ;
	JButton btnNewButton;
	JLabel lblpic;
	JButton btnAddPhoto;
	JRadioButton rdbtnm;
	JRadioButton rdbtnf;
	JRadioButton rdbtnMale;
	JRadioButton rdbtnFemale;
	JLabel Elblpic;
	
	JButton btnSave;
	JButton btnReset;
	
	String filename=null;
	byte[] pic=null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
		
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TutionHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TutionHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TutionHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TutionHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutionHomePage frame = new TutionHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	Connection conn=null;
	private JTextField Efname;
	private JTextField Elname;
	private JTextField Emothername;
	private JTextField Efathername;
	private JTextField Esclass;
	private JTextField Eaddress;
	private JTextField Efno;
	private JTextField Emno;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	
	public void resetdata() {
		
		fname.setText("");
		lname.setText("");
		fathername.setText("");
		mothername.setText("");
		fno.setText("");
		mno.setText("");
		address.setText("");
		sclass.setText("");
		lblpic.setIcon(null);
		buttonGroup_1.clearSelection();
		
		// for second Tab
		

		Efname.setText("");
		Elname.setText("");
		Efathername.setText("");
		Emothername.setText("");
		Efno.setText("");
		Emno.setText("");
		Eaddress.setText("");
		Esclass.setText("");
		//lblpic.setIcon(null);
		buttonGroup.clearSelection();
		
	}
	
	public void ShowTable() {
		
		try {
			
			String query="Select FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass,StudentImage from Student";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
		
	}
	
	public void SaveData() {
		try {
			
			String gender = null;
			
			String query="insert into Student (FirstName,LastName,Gender,FatherName,MotherName,FatherPhoneNo,MotherPhoneNo,Address,StudentClass,StudentImage) values (?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,fname.getText() );
			pst.setString(2, lname.getText());
			if(rdbtnm.isSelected()) {
				gender="Male";
			}
			if(rdbtnf.isSelected()) {
				gender="Female";
			}
			
			pst.setString(3, gender);
			pst.setString(4, fathername.getText());
			pst.setString(5, mothername.getText());
			pst.setString(6, fno.getText());
			pst.setString(7, mno.getText());
			pst.setString(8, address.getText());
			pst.setInt(9, (Integer.parseInt(sclass.getText())));
			pst.setBytes(10, pic);

			pst.execute();

			JOptionPane.showMessageDialog(null, "Data Saved");
			
			ShowTable();

			resetdata();
			
			pst.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void getSelectedData() {
		int i=table.getSelectedRow();
		TableModel model = table.getModel();
			Efname.setText(model.getValueAt(i, 0).toString());
			Elname.setText(model.getValueAt(i, 1).toString());
			String gender=model.getValueAt(i, 2).toString();
			if(gender.equalsIgnoreCase("male")) {
				rdbtnMale.setSelected(true);
			}
			else {
				rdbtnFemale.setSelected(true);
			}
			
			Efathername.setText(model.getValueAt(i, 3).toString());
			Emothername.setText(model.getValueAt(i, 4).toString());
			Efno.setText(model.getValueAt(i, 5).toString());
			Emno.setText(model.getValueAt(i, 6).toString());
			Eaddress.setText(model.getValueAt(i, 7).toString());
			Esclass.setText(model.getValueAt(i, 8).toString());
			
			try {
				String query="select StudentImage from Student where FirstName='"+Efname.getText()+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()) {
					byte[] imagedata = rs.getBytes("StudentImage");
					ImageIcon f = new ImageIcon(imagedata);
					Elblpic.setIcon(f);
				}
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No Image found");
			}
			
	}
	
	
	
	public void deleteData() {
		try {
			String name=Efname.getText();
			String query="delete from Student where FirstName=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.execute();
			
			ShowTable();
			resetdata();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void updateData() {
		try {
			
			
			String query="Update Student set FirstName='"+Efname.getText()+"',LastName='"+Elname.getText()+"',FatherName='"+Efathername.getText()+"',MotherName='"+Emothername.getText()+"',FatherPhoneNo='"+Efno.getText()+"',MotherPhoneNo='"+Emno.getText()+"',Address='"+Eaddress.getText()+"',StudentClass='"+Esclass.getText()+"' where FirstName='"+Efname.getText()+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Data Updated");
			
			ShowTable();
			
			pst.close();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
	}
	
	public TutionHomePage() {
		
		conn=SqliteConnection.dbconnector();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 10, 1368, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 1337, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPoojaClasses = new JLabel("POOJA CLASSES");
		lblPoojaClasses.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\teacher.png"));
		lblPoojaClasses.setBorder(new LineBorder(Color.GREEN, 2, true));
		lblPoojaClasses.setBounds(10, 11, 1312, 46);
		lblPoojaClasses.setBackground(Color.WHITE);
		lblPoojaClasses.setForeground(Color.RED);
		lblPoojaClasses.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPoojaClasses.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPoojaClasses);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(643, 95, 679, 515);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getSelectedData();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Sumedh", "Jahagirdar", "Male", "Santhosh", "Archana", new Long(9527097889L), new Long(9623970439L), "Purnanagar", "6", null},
				{"Swaroop", "Padennavar", "Male", "Shreeshail", "Poornima", new Long(9561733686L), new Long(7350253986L), "Purnanagar", "2", null},
				{"Ajay", "Shetty", "Male", "Mallu", "Laxmi", new Long(6565656565L), new Long(8585858585L), "Gulbarga", "11", null},
				{"rani", "kjlhkj", "Female", "jhk", "ljkhjkl", new Integer(645456), new Integer(64654), "hjg", "5", null},
			},
			new String[] {
				"FirstName", "LastName", "Gender", "FatherName", "MotherName", "FatherPhoneNo", "MotherPhoneNo", "Address", "StudentClass", "Image"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblStudentDatabase = new JLabel("Student Database");
		lblStudentDatabase.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStudentDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDatabase.setBounds(902, 62, 228, 33);
		panel.add(lblStudentDatabase);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(Color.GREEN);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnLogout.setBackground(Color.RED);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setBounds(1187, 649, 135, 33);
		panel.add(btnLogout);
		
		btnNewButton = new JButton("Show Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ShowTable();
			}
		});
		btnNewButton.setBounds(643, 613, 116, 33);
		panel.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 68, 616, 542);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GREEN, 2, true));
		tabbedPane.addTab("Add Student Info", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(20, 22, 135, 25);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(20, 72, 135, 25);
		panel_1.add(lblLastName);
		
		JLabel lblMotherName = new JLabel("Mother Name");
		lblMotherName.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblMotherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMotherName.setBounds(20, 221, 135, 25);
		panel_1.add(lblMotherName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblFatherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFatherName.setBounds(20, 171, 135, 25);
		panel_1.add(lblFatherName);
		
		JLabel lblStudentClass = new JLabel("Student Class");
		lblStudentClass.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblStudentClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentClass.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentClass.setBounds(20, 417, 135, 25);
		panel_1.add(lblStudentClass);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(20, 366, 135, 25);
		panel_1.add(lblAddress);
		
		JLabel lblMotherPhno = new JLabel("Mother Ph.no.");
		lblMotherPhno.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblMotherPhno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotherPhno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMotherPhno.setBounds(20, 319, 135, 25);
		panel_1.add(lblMotherPhno);
		
		JLabel lblFatherPhno = new JLabel("Father Ph.no.");
		lblFatherPhno.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblFatherPhno.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherPhno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFatherPhno.setBounds(20, 271, 135, 25);
		panel_1.add(lblFatherPhno);
		
		fname = new JTextField();
		fname.setBounds(208, 22, 135, 23);
		panel_1.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(208, 72, 135, 23);
		panel_1.add(lname);
		
		mothername = new JTextField();
		mothername.setColumns(10);
		mothername.setBounds(208, 221, 135, 23);
		panel_1.add(mothername);
		
		fathername = new JTextField();
		fathername.setColumns(10);
		fathername.setBounds(208, 171, 135, 23);
		panel_1.add(fathername);
		
		sclass = new JTextField();
		sclass.setColumns(10);
		sclass.setBounds(208, 419, 135, 23);
		panel_1.add(sclass);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(208, 369, 135, 23);
		panel_1.add(address);
		
		fno = new JTextField();
		fno.setColumns(10);
		fno.setBounds(208, 271, 135, 23);
		panel_1.add(fno);
		
		mno = new JTextField();
		mno.setColumns(10);
		mno.setBounds(208, 321, 135, 23);
		panel_1.add(mno);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				SaveData();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(144, 472, 106, 31);
		panel_1.add(btnSave);
		
		lblpic = new JLabel("");
		lblpic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblpic.setBounds(432, 22, 141, 167);
		panel_1.add(lblpic);
		
		btnAddPhoto = new JButton("Add Photo");
		btnAddPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnAddPhoto.setBackground(Color.BLACK);
		btnAddPhoto.setForeground(Color.CYAN);
		btnAddPhoto.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnAddPhoto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAddPhoto.setBounds(459, 211, 89, 23);
		panel_1.add(btnAddPhoto);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				resetdata();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(432, 472, 106, 31);
		panel_1.add(btnReset);
		
		JLabel label_9 = new JLabel("Gender");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_9.setBounds(20, 122, 135, 25);
		panel_1.add(label_9);
		
		rdbtnm = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnm);
		rdbtnm.setBounds(208, 124, 61, 23);
		panel_1.add(rdbtnm);
		
		rdbtnf = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnf);
		rdbtnf.setBounds(284, 124, 76, 23);
		panel_1.add(rdbtnf);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.CYAN, 2, true));
		tabbedPane.addTab("Edit Student Info", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setBounds(21, 27, 135, 25);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_1.setBounds(21, 77, 135, 25);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Mother Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_2.setBounds(21, 221, 135, 25);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Father Name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_3.setBounds(21, 171, 135, 25);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Student Class");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_4.setBounds(21, 417, 135, 25);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Address");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_5.setBounds(21, 366, 135, 25);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Mother Ph.no.");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_6.setBounds(21, 319, 135, 25);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Father Ph.no.");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_7.setBounds(21, 271, 135, 25);
		panel_2.add(label_7);
		
		Efname = new JTextField();
		Efname.setColumns(10);
		Efname.setBounds(209, 27, 135, 23);
		panel_2.add(Efname);
		
		Elname = new JTextField();
		Elname.setColumns(10);
		Elname.setBounds(209, 77, 135, 23);
		panel_2.add(Elname);
		
		Emothername = new JTextField();
		Emothername.setColumns(10);
		Emothername.setBounds(209, 221, 135, 23);
		panel_2.add(Emothername);
		
		Efathername = new JTextField();
		Efathername.setColumns(10);
		Efathername.setBounds(209, 171, 135, 23);
		panel_2.add(Efathername);
		
		Esclass = new JTextField();
		Esclass.setColumns(10);
		Esclass.setBounds(209, 419, 135, 23);
		panel_2.add(Esclass);
		
		Eaddress = new JTextField();
		Eaddress.setColumns(10);
		Eaddress.setBounds(209, 369, 135, 23);
		panel_2.add(Eaddress);
		
		Efno = new JTextField();
		Efno.setColumns(10);
		Efno.setBounds(209, 271, 135, 23);
		panel_2.add(Efno);
		
		Emno = new JTextField();
		Emno.setColumns(10);
		Emno.setBounds(209, 321, 135, 23);
		panel_2.add(Emno);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					
					
					String query="Update Student set FirstName='"+Efname.getText()+"',LastName='"+Elname.getText()+"',FatherName='"+Efathername.getText()+"',MotherName='"+Emothername.getText()+"',FatherPhoneNo='"+Efno.getText()+"',MotherPhoneNo='"+Emno.getText()+"',Address='"+Eaddress.getText()+"',StudentClass='"+Esclass.getText()+"' where FirstName='"+Efname.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ShowTable();
					
					pst.close();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}*/
				
				updateData();
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(128, 460, 106, 31);
		panel_2.add(btnUpdate);
		
		Elblpic = new JLabel("");
		Elblpic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Elblpic.setBounds(433, 33, 141, 167);
		panel_2.add(Elblpic);
		
		JButton Ebtnpic = new JButton("Add Photo");
		Ebtnpic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		Ebtnpic.setForeground(Color.CYAN);
		Ebtnpic.setFont(new Font("Tahoma", Font.ITALIC, 13));
		Ebtnpic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Ebtnpic.setBackground(Color.BLACK);
		Ebtnpic.setBounds(460, 211, 89, 23);
		panel_2.add(Ebtnpic);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(433, 460, 106, 31);
		panel_2.add(btnDelete);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(21, 124, 135, 25);
		panel_2.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(209, 126, 61, 23);
		panel_2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(285, 126, 76, 23);
		panel_2.add(rdbtnFemale);
		
		ShowTable();
				
	}
}
