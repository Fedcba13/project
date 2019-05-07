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

public class SecondChicken extends JPanel {

	private MainFrame f;
	public SecondChicken(MainFrame f) {
		this.f = f;
		setLayout(null);
		
		f.setLocationRelativeTo(null);
		f.setSize(450,400);
		
		JLabel tender = new JLabel("닭가슴살");
		tender.setBounds(100, 137, 57, 15);
		tender.addMouseListener(new MyMouseListener());
		
		JLabel drummette = new JLabel("날개/ 윙");
		drummette.setBounds(184, 137, 76, 15);
		drummette.addMouseListener(new MyMouseListener());
		
		JLabel drumstick = new JLabel("닭다리");
		drumstick.setBounds(188, 218, 57, 15);
		drumstick.addMouseListener(new MyMouseListener());
		
		JLabel back = new JLabel("닭봉");
		back.setBounds(261, 106, 57, 15);
		back.addMouseListener(new MyMouseListener());
		
		JLabel everything = new JLabel("모두 보기");
		everything.setForeground(Color.WHITE);
		everything.setBounds(89, 52, 57, 15);
		everything.addMouseListener(new MyMouseListener());
	
		
				
		
		
		add(tender);
		add(drummette);
		add(drumstick);
		add(everything);
		add(back);
		
		Image png = new ImageIcon("images/닭.PNG").getImage()
				.getScaledInstance(450, 320, 0);
		
	
		JLabel label = new JLabel(new ImageIcon(png));
		label.setBounds(0, -33, 450, 350);
		add(label);

		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
	    	MyUtil.changePanel(f, SecondChicken.this, new Third(f, "닭",  ((JLabel)(e.getSource())).getText()));
	    	
		}

}

}