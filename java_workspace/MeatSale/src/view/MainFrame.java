package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.vo.Customer;
import view.shop.First;
import view.user.LoginPanel;

public class MainFrame extends JFrame {

	public static Customer user;
	public static JPanel currentPanel;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);

		add(new Menu(this));
		setBackground(Color.white);

		setResizable(false);
		
		// 패널1
		JPanel first = new First(this);
		add(first);
		currentPanel = first;

		setVisible(true);
	}

}
