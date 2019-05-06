package view.shop;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.MyUtil;
import view.MainFrame;

public class SecondPork extends JPanel {

	private MainFrame f;

	public SecondPork(MainFrame f) {

		this.f = f;
		
		setLayout(null);
		
		
		JLabel bladeShoulder = new JLabel("목살");
		bladeShoulder.setBounds(146, 115, 57, 15);
		bladeShoulder.addMouseListener(new MyMouseListener());

		JLabel armShoulder = new JLabel("앞다리");
		armShoulder.setBounds(135, 166, 51, 34);
		armShoulder.addMouseListener(new MyMouseListener());


		JLabel loin = new JLabel("등심");
		loin.setBounds(206, 115, 57, 15);
		loin.addMouseListener(new MyMouseListener());
		
		JLabel spareRib = new JLabel("갈비");
		spareRib.setBounds(182, 185, 57, 15);
		spareRib.addMouseListener(new MyMouseListener());
	
		JLabel hock = new JLabel("족발");
		hock.setBounds(195, 275, 57, 15);
		hock.addMouseListener(new MyMouseListener());
		

		JLabel side = new JLabel("삼겹살");
		side.setBounds(206, 202, 57, 15);
		side.addMouseListener(new MyMouseListener());
		

		JLabel leg = new JLabel("뒷다리");
		leg.setBounds(281, 166, 57, 15);
		leg.addMouseListener(new MyMouseListener());
		

		JLabel everything = new JLabel("모두 보기");
		everything.setBounds(82, 105, 104, 34);
		everything.addMouseListener(new MyMouseListener());


		add(bladeShoulder);
		add(armShoulder);
		add(loin);
		add(spareRib);
		add(hock);
		add(side);
		add(leg);
		add(everything);
		

		Image png = new ImageIcon("images/돼지.PNG").getImage()
				.getScaledInstance(450, 350, 0);
		JLabel label = new JLabel(new ImageIcon(png));
		label.setBounds(0, -12, 450, 350);
		add(label);

		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
	    	MyUtil.changePanel(f, SecondPork.this, new Third(f, "돼지", ((JLabel)(e.getSource())).getText()));
	    	
		}

}

}
