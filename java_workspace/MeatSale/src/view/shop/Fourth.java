package view.shop;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.vo.Item;
import view.MainFrame;

public class Fourth extends JPanel {
	
	private MainFrame f;
	
	public Fourth(MainFrame f, Item item) {
		this.f = f;
	
		setLayout(null);
		Image scaledImage = new ImageIcon(item.getItemImageUrl()).getImage().getScaledInstance(150, 140, 0);
		JLabel img = new JLabel(new ImageIcon(scaledImage));
		JLabel name = new JLabel(item.getItemName()+"");
		JLabel price = new JLabel(item.getItemPrice()+"");
		
		img.setBounds(15,23,199,149);
		name.setBounds(226,30,199,10);
		price.setBounds(236,56,91,30);
		
		add(img);
		add(name);
		add(price);
		
		setVisible(true);
		
		
	}
}