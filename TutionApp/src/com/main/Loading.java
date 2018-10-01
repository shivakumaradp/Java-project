package com.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.util.Timer;

import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.SplashScreen;

import javax.swing.border.LineBorder;
import javax.swing.plaf.ProgressBarUI;

import java.awt.Color;
import java.awt.Component;

public class Loading extends JFrame {

	
	private JPanel contentPane;
	private JPanel panel;
	public JProgressBar progressBar;
	public JLabel lblPleaseWait;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Loading() throws InterruptedException {
		setUndecorated(true);
		setFont(new Font("Dialog", Font.BOLD, 11));
		setTitle("Loading......");
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 643, 424);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 617, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 35, 597, 288);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("E:\\JavaGUI\\TutionApp\\imgs\\loader.gif"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(68, 334, 487, 17);
		panel.add(progressBar);
		
		lblPleaseWait = new JLabel("Please wait....");
		lblPleaseWait.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWait.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseWait.setBounds(259, 362, 115, 14);
		panel.add(lblPleaseWait);
		
		JLabel lblTutionApp = new JLabel("Student Management System");
		lblTutionApp.setForeground(Color.RED);
		lblTutionApp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTutionApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTutionApp.setBounds(142, 0, 320, 24);
		panel.add(lblTutionApp);
	}
	
	
}
