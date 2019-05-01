package view;

import javax.swing.JFrame;

import model.vo.Customer;

public class MainFrame extends JFrame{
	
	public static Customer user;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		//패널1
		add(new LoginPanel(this));
		
		
		setVisible(true);
	}
	
}
