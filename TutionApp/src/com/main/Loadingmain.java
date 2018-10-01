package com.main;

public class Loadingmain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Loading load=new Loading();
		load.setVisible(true);
		try {
			int i ;
			for(i=1;i<=100;i++) {
				Thread.sleep(55);
				load.progressBar.setValue(i);
				
				if(i==100) {
					load.setVisible(false);
					LoginForm form=new LoginForm();
					form.frmTutionApp.setVisible(true);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
