package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public static JPanel currentPanel;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setResizable(false);
		
		add(new MainPanel(this));
		setVisible(true);

	}

}
