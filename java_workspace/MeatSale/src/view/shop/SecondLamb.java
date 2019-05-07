package view.shop;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.MyUtil;
import view.MainFrame;

public class SecondLamb extends JPanel {

	private MainFrame f;

	public SecondLamb(MainFrame f) {
		this.f = f;
		setLayout(null);
		f.setLocationRelativeTo(null);
		f.setSize(450,400);

		Image png = new ImageIcon("images/양.PNG").getImage()
				.getScaledInstance(450, 320, 0);

		JLabel shoulderRack = new JLabel("양갈비");
		shoulderRack.setBounds(128, 98, 57, 15);
		shoulderRack.addMouseListener(new MyMouseListener());
		
		JLabel shoulder = new JLabel("어깨");
		shoulder.setBounds(157, 146, 57, 15);
		shoulder.addMouseListener(new MyMouseListener());
				
		JLabel frenchrack = new JLabel("갈비");
		frenchrack.setBounds(197, 87, 57, 15);
		frenchrack.addMouseListener(new MyMouseListener());
		

		JLabel backstrap = new JLabel("등심");
		backstrap.setBounds(241, 59, 57, 15);
		backstrap.addMouseListener(new MyMouseListener());

		JLabel breast = new JLabel("가슴살");
		breast.setBounds(263, 146, 57, 15);
		breast.addMouseListener(new MyMouseListener());

		JLabel leg = new JLabel("다리");
		leg.setBounds(337, 98, 57, 15);
		leg.addMouseListener(new MyMouseListener());

		JLabel everything = new JLabel("모두 보기");
		everything.setForeground(Color.WHITE);
		everything.setBounds(60, 34, 57, 15);
		everything.addMouseListener(new MyMouseListener());

		JLabel label = new JLabel(new ImageIcon(png));
		label.setBounds(0, -56, 450, 413);
		

		add(shoulderRack);
		add(shoulder);
		add(frenchrack);
		add(backstrap);
		add(breast);
		add(leg);
		add(everything);
		add(label);

		setVisible(true);

	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MyUtil.changePanel(f, SecondLamb.this, new Third(f, "양", ((JLabel) (e.getSource())).getText()));

		}

	}

}
