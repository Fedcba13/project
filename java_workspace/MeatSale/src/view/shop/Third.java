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
import controller.Goods;
import model.vo.Item;
import view.MainFrame;

public class Third extends JPanel {
	
	ArrayList<Item> itemArr;

	private MainFrame f;

	public Third(MainFrame f, String cate1, String cate2) {
		this(f,cate1,cate2,0);
	}
	
	public Third(MainFrame f, String cate1, String cate2, int pageNum) {
		this.f = f;

		Goods goods = new Goods();

		if (cate2.equals("모두 보기")) {
			itemArr = goods.getItems(cate1);
		} else {
			itemArr = goods.getItems(cate1, cate2);
		}


		f.setSize(450, 350);
		setLayout(null);
		setBackground(Color.white);

		JPanel main = new MyPanel(itemArr.get(0));
		main.setBounds(12, 10, 213, 140);

		JPanel main1 = new MyPanel(itemArr.get(1));
		main1.setBounds(225, 10, 213, 140);

		JPanel main2 = new MyPanel(itemArr.get(2));
		main2.setBounds(12, 150, 213, 140);

		JPanel main3 = new MyPanel(itemArr.get(3));
		main3.setBounds(225, 150, 213, 140);

		add(main);
		add(main1);
		add(main2);
		add(main3);

		setVisible(true);
	}
	
	class MyPanel extends JPanel {

		public MyPanel(Item item) {

			Image scaledImage = new ImageIcon(item.getItemImageUrl()).getImage().getScaledInstance(150, 140, 0);
			JLabel image = new JLabel(new ImageIcon(scaledImage));

			JLabel name = new JLabel(item.getItemName());
			JLabel price = new JLabel(item.getItemPrice() + "");
			add(image);
			add(name);
			add(price);

			class MyMouseListener extends MouseAdapter {
				@Override
				public void mouseClicked(MouseEvent e) {
						MyUtil.changePanel(f, Third.this, new Fourth(f, item));
				}
			}
			addMouseListener(new MyMouseListener());

		}
	}

}