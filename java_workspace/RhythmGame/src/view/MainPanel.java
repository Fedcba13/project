package view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */

	MainFrame f;

	public MainPanel(MainFrame f) {
		this.f = f;
		f.setSize(500, 400);
		f.setLocationRelativeTo(null);
		setLayout(null);

		JLabel label1 = new JLabel();
		label1.setBounds(0, 270, 150, 30);
		label1.setBorder(new LineBorder(Color.black));
		label1.setBackground(new Color(0, 0, 255, 60));
		label1.setOpaque(true);
		add(label1);

		JLabel label2 = new JLabel();
		label2.setBounds(150, 270, 150, 30);
		label2.setBorder(new LineBorder(Color.black));
		label2.setBackground(new Color(255, 0, 0, 60));
		label2.setOpaque(true);
		add(label2);

		JLabel label3 = new JLabel();
		label3.setBounds(300, 270, 150, 30);
		label3.setBorder(new LineBorder(Color.black));
		label3.setOpaque(true);
		label3.setBackground(new Color(0, 255, 0, 60));
		add(label3);

		f.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {

				JLabel tempJLabel = null;

				if (e.getKeyChar() == 'a') {
					tempJLabel = label1;
				} else if (e.getKeyChar() == 's') {
					tempJLabel = label2;
				} else if (e.getKeyChar() == 'd') {
					tempJLabel = label3;
				}

				int x = tempJLabel.getX();

				System.out.println(x);

			}

		});

	}

	class MyThread extends Thread {

		@Override
		public void run() {
			JLabel tempJLabel = new JLabel();

			int rnd = (int) Math.random() * 3;

			tempJLabel.setBounds(rnd * 150, 30, 150, 30);

			if (rnd == 0) {
				tempJLabel.setBackground(Color.red);
			} else if (rnd == 1) {
				tempJLabel.setBackground(Color.green);
			} else if (rnd == 1) {
				tempJLabel.setBackground(Color.blue);
			}

		}

	}

}
