package com.main;

import java.util.*;
import java.sql.*;
import com.sqlite.SqliteClass;

public class BankingSystem {
	
	private static Connection conn=null;
	private static PreparedStatement pst=null;
	private static ResultSet rs = null;

	public static void main(String[] args) {
		
		System.out.println("\n");
		System.out.println("********** WELCOME TO SHETTY BANK ********** ");
		System.out.println("\n");
		System.out.println("Please Login");
		System.out.println("**********************************************");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username");
		String username=sc.nextLine();
		System.out.println("Please enter password");
		String password=sc.nextLine();
		System.out.println("********************************************");
	
		login(username,password);
		
	}
	
	public static void adminPage(int id, String username) {
		
		System.out.println("******** WELCOME "+username+"*********");
		int option;
		char s = 'y';
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("\n");
			System.out.println("1 : View Profile");
			System.out.println("2 : View Customers");
			System.out.println("3 : Create Customers");
			System.out.println("4 : Delete Customer");
			System.out.println("5 : View Balance");
			System.out.println("6 : Deposit Money");
			System.out.println("7 : Withdraw Money");
			System.out.println("************************************");
			System.out.println("Please select Option ");
			System.out.println("*********************************");
			option = sc.nextInt();
			
			switch(option) {
			
			case 1 :
				viewProfile(id);
				break;
				
			case 2 :
				viewUsers();
				break;
				
			case 3 :
				boolean value = createUser();
				if(value) {
					System.out.println("Data Saved....");
				}
				else {
					System.out.println("Data not Saved!!!!!");
				}
				break;
							
			case 4:
				System.out.println("Enter UserID to be deleted..");
				int uid = sc.nextInt();
				deleteUser(uid);
				break;
				
			case 5 :
				viewBal(id);
				break;
				
			case 6 : 
				depositMoney(id);
				break;
				
			case 7 :
				withdrawamount(id);
				break;
				
			
			default :
				System.out.println("Please enter correct option!");
				break;
			}
				
				System.out.println("Do you want to continue...Y/N");
				s=sc.next().charAt(0);
			
			
		}while(s=='y'||s=='Y');
		
		
		sc.close();
		System.out.println("Thank you");
		
		
		
	}
	
	public static void userPage(int id, String username) {

		System.out.println("******** WELCOME "+username+"*********");
		int option;
		Scanner sc = new Scanner(System.in);
		char s ='y';
		
		
		do {
			
			System.out.println("\n");
			System.out.println("1 : View Profile");
			System.out.println("2 : View Balance");
			System.out.println("3 : Deposit Money");
			System.out.println("4 : Withdraw Money");
			System.out.println("************************************");
			System.out.println("Please select Option ");
			System.out.println("*********************************");
			option = sc.nextInt();
			
			switch(option) {
			
			case 1 :
				viewProfile(id);
				break;
							
			case 2 :
				viewBal(id);
				break;
				
			case 3 : 
				depositMoney(id);
				break;
				
			case 4 :
				withdrawamount(id);
				break;
				
						
			default :
				System.out.println("Please enter correct option!");
				break;
			}
				
				System.out.println("DO you want to continue...Y/N");
				s=sc.next().charAt(0);
			
			
			
		}while(s=='y'||s=='Y');
		
		sc.close();
		
		System.out.println("Thank you");
		
		
		
		
		
	}
	
	public static void viewProfile(int id) {
		try {
			
			String query="select * from LoginTable where loginid=?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs =pst.executeQuery();
			while(rs.next()) {
				
				System.out.println("Username is :"+rs.getString("username"));
				System.out.println("Account no is :"+rs.getInt("accno"));
				System.out.println("Current balance is :"+rs.getString("totalamount"));
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		
	}

	public static void viewUsers() {

		try {
			String query="select * from LoginTable where logintype=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, "user");
			rs =pst.executeQuery();
			while(rs.next()) {
				System.out.println("Username is :"+rs.getString("username"));
				System.out.println("Account no is :"+rs.getInt("accno"));
				System.out.println("-------------------------------------");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
	}

	public static boolean createUser() {
		try {
			
			Scanner sc = new Scanner(System.in);
			String query="insert into LoginTable (username,password,name,city,phno,accno,totalamount,depositamount,withdrawamount,logintype) values (?,?,?,?,?,?,?,?,?,?)";
			System.out.println("Enter Username : ");
			String username = sc.nextLine();
			System.out.println("Enter password : ");
			String password = sc.nextLine();
			System.out.println("Enter Name : ");
			String name = sc.nextLine();
			System.out.println("Enter City : ");
			String city = sc.nextLine();
			System.out.println("Enter Phone No : ");
			String phno = sc.nextLine();
			System.out.println("Enter Intial amount : ");
			String totalamount = sc.nextLine();
			System.out.println("Enter Login Type : ");
			String logintype = sc.nextLine();
			System.out.println("Enter Account No : ");
			int accno = sc.nextInt();
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, name);
			pst.setString(4, city);
			pst.setString(5, phno);
			pst.setInt(6, accno);
			pst.setString(7, totalamount);
			pst.setString(8, "0");
			pst.setString(9, "0");
			pst.setString(10, logintype);
			pst.execute();
			
			
			
			sc.close();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
	}

	public static void viewBal(int id) {
		
		try {
			
			String query="select * from LoginTable where loginid=?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs =pst.executeQuery();
			while(rs.next()) {
				System.out.println("Current Balance is : "+rs.getInt("totalamount"));
				System.out.println("-------------------------------------");
				
			}
		
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		
		
	}

	public static void deleteUser(int id) {
		try {
			
			String query="delete from LoginTable where loginid=?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Account deleted.....");
			
			pst.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
	}
	
	public static void depositMoney(int id) {
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter amount to be deposited");
			String amount = sc.nextLine();
			String query="update LoginTable set depositamount = depositamount+'"+amount+"',totalamount = totalamount+'"+amount+"' where loginid=?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Amount deposited.....");
			
			
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
	}
	
	public static void withdrawamount(int id) {
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter amount to be Withdraw");
			String amount = sc.nextLine();
			String query="update LoginTable set withdrawamount = withdrawamount+'"+amount+"',totalamount = totalamount-'"+amount+"' where loginid=?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Amount Withdraw Rs."+amount);
			
			
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				pst.close();
				rs.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
	}

	public static void login(String username, String password) {
		conn = SqliteClass.dbconnector(); // calling the database connector
		try {
			int count = 0;
			String query = "select * from LoginTable where username=? and password=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				count++;
				int id = rs.getInt("loginid");
				String ltype = rs.getString("logintype");
				
				if(ltype.equalsIgnoreCase("admin")) {
										
					
					adminPage(id,username);
					
				
					
				}
				else if(ltype.equalsIgnoreCase("user")) {
				
					userPage(id,username);
					
				}
			
				
			}
			
			if(count==0) {
				
				System.out.println("Incorrect Login details Please try again!!!!!");
				
			}
		
			
			
		} catch (Exception e) {
			System.out.println("in main error");
		}
		
		finally {
			try {
				pst.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		System.out.println("Bye Bye!!!!!");
		
		
		
	
	}


}
