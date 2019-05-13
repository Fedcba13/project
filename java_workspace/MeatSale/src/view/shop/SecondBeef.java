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





public class SecondBeef extends JPanel {
	private MainFrame f;
	
	public SecondBeef(MainFrame f) {
		
		this.f = f;
		
		f.setLocationRelativeTo(null);
		f.setSize(450,400);
		f.setTitle("소 부위 선택 화면");
		setBackground(Color.white);
		setLayout(null);
		
		
		
		// "C:\\Workspaces\\java_workspace\\15_GUI\\images\\소.PNG"
		Image png = new ImageIcon("images/소.PNG").getImage().getScaledInstance(450, 350, 0);
		
		JLabel chunk = new JLabel("등심");
		chunk.setBounds(128, 97, 57, 15);
		chunk.addMouseListener(new MyMouseListener());
		
		JLabel rib = new JLabel("립");
		rib.setBounds(197, 97, 57, 15);
		rib.addMouseListener(new MyMouseListener());
		
		JLabel shortloin = new JLabel("채끝살");
		shortloin.setBounds(265, 73, 57, 15);
		shortloin.addMouseListener(new MyMouseListener());
		
		JLabel brisket = new JLabel("양지");
		brisket.setBounds(136, 183, 57, 15);
		brisket.addMouseListener(new MyMouseListener());
		
		JLabel shank = new JLabel("사태");
		shank.setBounds(157, 222, 57, 15);
		shank.addMouseListener(new MyMouseListener());
		
		JLabel sirloin = new JLabel("안심");
		sirloin.setBounds(323, 61, 57, 15);
		sirloin.addMouseListener(new MyMouseListener());
		
		
		JLabel round = new JLabel("우둔살");
		round.setBounds(368, 112, 57, 15);
		round.addMouseListener(new MyMouseListener());
		
		
		JLabel everything = new JLabel("모두 보기");
		everything.setForeground(Color.WHITE);
		everything.setBounds(48,60,95,40);
		everything.addMouseListener(new MyMouseListener());
	
		
		
		
		
		add(chunk);
		add(rib);
		add(shortloin);
		add(brisket);
		add(shank);
		add(sirloin);
		add(round);
		add(everything);
		
		JLabel label = new JLabel(new ImageIcon(png));
		label.setBounds(0,0,450,350);
		add(label);
		
		
		
		setVisible(true);
		
		
	}
	
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
	    	MyUtil.changePanel(f, SecondBeef.this, new Third(f, "소", ((JLabel)(e.getSource())).getText()));
	    	
		}
	}
	
}
