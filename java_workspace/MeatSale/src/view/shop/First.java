package view.shop;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.MyUtil;
import controller.Pay;
import model.vo.Payment;
import view.MainFrame;

public class First extends JPanel {

	private MainFrame f;
	private JPanel beefPanel;
	private JPanel porkPanel;
	private JPanel chickenPanel;
	private JPanel lambPanel;

	public First(MainFrame f) {
		this.f = f;

		f.setTitle("MeatSale");
		f.setSize(450, 400);
		setLayout(null);
		f.setLocationRelativeTo(null);

		beefPanel = new FirstPanel(f, "Images/beef.gif");
		beefPanel.setBounds(12, 10, 213, 140);
		beefPanel.setBackground(Color.white);

		porkPanel = new FirstPanel(f, "Images/pork.gif");
		porkPanel.setBounds(225, 10, 213, 140);
		porkPanel.setBackground(Color.white);

		chickenPanel = new FirstPanel(f, "Images/chicken.gif");
		chickenPanel.setBounds(12, 150, 213, 140);
		chickenPanel.setBackground(Color.white);

		lambPanel = new FirstPanel(f, "Images/lamb.gif");
		lambPanel.setBounds(225, 150, 213, 140);
		lambPanel.setBackground(Color.white);

		setBackground(Color.white);

		add(beefPanel);
		add(porkPanel);
		add(chickenPanel);
		add(lambPanel);

		setVisible(true);

	}

	class FirstPanel extends JPanel {
		private MainFrame f;

		public FirstPanel(MainFrame f, String meat) {
			this.f = f;
			Image animal = new ImageIcon(meat).getImage().getScaledInstance(150, 140, 0);
			JLabel main = new JLabel(new ImageIcon(animal));
			add(main);

			class MyMouseListener extends MouseAdapter {
				@Override
				public void mouseClicked(MouseEvent e) {

					JPanel panel = (JPanel) e.getSource();

					if (panel == beefPanel) {
						MyUtil.changePanel(f, First.this, new SecondBeef(f));
					} else if (panel == porkPanel) {
						MyUtil.changePanel(f, First.this, new SecondPork(f));
					} else if (panel == chickenPanel) {
						MyUtil.changePanel(f, First.this, new SecondChicken(f));
					} else if (panel == lambPanel) {
						MyUtil.changePanel(f, First.this, new SecondLamb(f));
					}
					//

				}
			}

			addMouseListener(new MyMouseListener());
		}

	}
}
