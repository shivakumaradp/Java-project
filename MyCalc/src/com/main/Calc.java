package com.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Calc {

	private JFrame frmCalculator;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textview;
	private JLabel lblops;

	private JRadioButton btnon;
	private JRadioButton btnoff;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btnadd;
	private JButton btnsub;
	private JButton btnmulti;
	private JButton btndiv;
	private JButton btndot;
	private JButton btnans;
	private JButton back;
	private JButton btnac;
	
	int ops;
	double answer,number;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            //here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
		btnon.setEnabled(false);
		
		lblops = new JLabel("");
		lblops.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblops.setForeground(new Color(255, 0, 0));
		lblops.setHorizontalAlignment(SwingConstants.RIGHT);
		lblops.setBounds(138, 11, 101, 23);
		frmCalculator.getContentPane().add(lblops);
	}
	
	public void operations() {
		switch(ops) {
		
		case 1 :
			answer = number + Double.parseDouble(textview.getText());
			textview.setText(Double.toString(answer));
			break;
		
		case 2 :
			answer = number - Double.parseDouble(textview.getText());
			textview.setText(Double.toString(answer));
			break;
			
		case 3 :
			answer = number * Double.parseDouble(textview.getText());
			textview.setText(Double.toString(answer));
			break;
			
		case 4 :
			answer = number / Double.parseDouble(textview.getText());
			textview.setText(Double.toString(answer));
			break;
		
		
		}
		
	}

	public void disableView() {

		btnon.setEnabled(true);
		btnoff.setEnabled(false);

		textview.setEnabled(false);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
		btn0.setEnabled(false);
		btnadd.setEnabled(false);
		btnsub.setEnabled(false);
		btnmulti.setEnabled(false);
		btndiv.setEnabled(false);
		btnans.setEnabled(false);
		btnac.setEnabled(false);
		back.setEnabled(false);
		btndot.setEnabled(false);

	}

	public void enableView() {

		btnon.setEnabled(false);
		btnoff.setEnabled(true);

		textview.setEnabled(true);
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
		btn0.setEnabled(true);
		btnadd.setEnabled(true);
		btnsub.setEnabled(true);
		btnmulti.setEnabled(true);
		btndiv.setEnabled(true);
		btnans.setEnabled(true);
		btnac.setEnabled(true);
		back.setEnabled(true);
		btndot.setEnabled(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setType(Type.UTILITY);
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator - Vinay Shetty");
		frmCalculator.setBounds(100, 100, 256, 355);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		frmCalculator.setLocationRelativeTo(null);

		textview = new JTextField();
		textview.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		textview.setFont(new Font("Tahoma", Font.BOLD, 12));
		textview.setBackground(Color.WHITE);
		textview.setHorizontalAlignment(SwingConstants.RIGHT);
		textview.setBounds(10, 40, 230, 30);
		frmCalculator.getContentPane().add(textview);
		textview.setColumns(10);

		btnon = new JRadioButton("ON");
		btnon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableView();
			}
		});
		buttonGroup.add(btnon);
		btnon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnon.setBounds(10, 77, 51, 23);
		frmCalculator.getContentPane().add(btnon);

		btnoff = new JRadioButton("OFF");
		btnoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableView();
			}
		});
		buttonGroup.add(btnoff);
		btnoff.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnoff.setBounds(10, 103, 51, 23);
		frmCalculator.getContentPane().add(btnoff);

		back = new JButton("<--");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int length = textview.getText().length();
				int number = textview.getText().length() - 1;
				String remainingnumber;

				if (length > 0) {
					StringBuilder b = new StringBuilder(textview.getText());
					b.deleteCharAt(number);
					remainingnumber = b.toString();
					textview.setText(remainingnumber);
				}

			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 10));
		back.setBounds(67, 91, 51, 35);
		frmCalculator.getContentPane().add(back);

		btnac = new JButton("AC");
		btnac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText("");
			}
		});
		btnac.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnac.setBounds(128, 91, 51, 35);
		frmCalculator.getContentPane().add(btnac);

		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textview.setText(textview.getText() + "1");
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn1.setBounds(10, 142, 51, 35);
		frmCalculator.getContentPane().add(btn1);

		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "2");
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn2.setBounds(67, 142, 51, 35);
		frmCalculator.getContentPane().add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "3");
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn3.setBounds(128, 142, 51, 35);
		frmCalculator.getContentPane().add(btn3);

		btnadd = new JButton("+");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(textview.getText());
				ops = 1;
				textview.setText("");
				lblops.setText(number + "+");
			}
		});
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnadd.setBounds(189, 91, 51, 35);
		frmCalculator.getContentPane().add(btnadd);

		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "4");
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn4.setBounds(10, 188, 51, 35);
		frmCalculator.getContentPane().add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "5");
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn5.setBounds(67, 188, 51, 35);
		frmCalculator.getContentPane().add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "6");
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn6.setBounds(128, 188, 51, 35);
		frmCalculator.getContentPane().add(btn6);

		btnsub = new JButton("-");
		btnsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(textview.getText());
				ops = 2;
				textview.setText("");
				lblops.setText(number + "-");
			}
		});
		btnsub.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsub.setBounds(188, 142, 51, 35);
		frmCalculator.getContentPane().add(btnsub);

		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "7");
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn7.setBounds(10, 234, 51, 35);
		frmCalculator.getContentPane().add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "8");
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn8.setBounds(67, 234, 51, 35);
		frmCalculator.getContentPane().add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "9");
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn9.setBounds(128, 234, 51, 35);
		frmCalculator.getContentPane().add(btn9);

		btndiv = new JButton("/");
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(textview.getText());
				ops = 4;
				textview.setText("");
				lblops.setText(number + "/");
			}
		});
		btndiv.setFont(new Font("Tahoma", Font.BOLD, 13));
		btndiv.setBounds(188, 188, 51, 35);
		frmCalculator.getContentPane().add(btndiv);

		btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + ".");
			}
		});
		btndot.setFont(new Font("Tahoma", Font.BOLD, 13));
		btndot.setBounds(10, 280, 51, 35);
		frmCalculator.getContentPane().add(btndot);

		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textview.setText(textview.getText() + "0");
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn0.setBounds(67, 280, 51, 35);
		frmCalculator.getContentPane().add(btn0);

		btnans = new JButton("=");
		btnans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operations();
				lblops.setText("");
			}
		});
		btnans.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnans.setBounds(128, 280, 111, 35);
		frmCalculator.getContentPane().add(btnans);

		btnmulti = new JButton("*");
		btnmulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(textview.getText());
				ops = 3;
				textview.setText("");
				lblops.setText(number + "*");
			}
		});
		btnmulti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmulti.setBounds(188, 234, 51, 35);
		frmCalculator.getContentPane().add(btnmulti);
	}
}
