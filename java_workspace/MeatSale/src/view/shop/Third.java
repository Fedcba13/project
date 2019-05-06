package view.shop;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import common.MyUtil;
import controller.Goods;
import model.vo.Item;
import view.MainFrame;

public class Third extends JPanel {

	ArrayList<Item> itemArr;

	private MainFrame f;

	public Third(MainFrame f, String cate1, String cate2) {
		this(f, cate1, cate2, 1);
	}

	public Third(MainFrame f, String cate1, String cate2, int pageNum) {
		this.f = f;

		Goods goods = new Goods();

		if (cate2.equals("모두 보기")) {
			itemArr = goods.getItems(cate1);
		} else {
			itemArr = goods.getItems(cate1, cate2);
		}

		int num1 = (pageNum * 4) - 4;
		int num2 = (pageNum * 4) - 3;
		int num3 = (pageNum * 4) - 2;
		int num4 = (pageNum * 4) - 1;

		f.setSize(550, 350);
		setLayout(null);
		setBackground(Color.white);

		JPanel item1;
		if (num1 < itemArr.size()) {
			item1 = new MyPanel(itemArr.get(num1));
		} else {
			item1 = new JPanel();
		}
		item1.setBackground(Color.WHITE);
		item1.setBounds(50, 10, 200, 150);

		JPanel item2;
		if (num2 < itemArr.size()) {
			item2 = new MyPanel(itemArr.get(num2));
		} else {
			item2 = new JPanel();
		}
		item2.setBackground(Color.WHITE);
		item2.setBounds(275, 10, 200, 150);

		JPanel item3;
		if (num3 < itemArr.size()) {
			item3 = new MyPanel(itemArr.get(num3));
		} else {
			item3 = new JPanel();
		}
		item3.setBackground(Color.WHITE);
		item3.setBounds(50, 150, 200, 150);

		JPanel item4;
		if (num4 < itemArr.size()) {
			item4 = new MyPanel(itemArr.get(num4));
		} else {
			item4 = new JPanel();
		}
		item4.setBackground(Color.WHITE);
		item4.setBounds(275, 150, 200, 150);

		add(item1);
		add(item2);
		add(item3);
		add(item4);

		Image left = new ImageIcon("images/left.png").getImage().getScaledInstance(50, 100, 0);
		JLabel leftLabel = new JLabel(new ImageIcon(left));
		leftLabel.setBounds(0,90,50,100);

		Image right = new ImageIcon("images/right.png").getImage().getScaledInstance(50, 100, 0);
		JLabel rightLabel = new JLabel(new ImageIcon(right));
		rightLabel.setBounds(475,90,50,100);

		leftLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pageNum == 1) {
					JOptionPane.showMessageDialog(null, "첫번째 페이지입니다.");
				} else {
					MyUtil.changePanel(f, Third.this, new Third(f, cate1, cate2, pageNum - 1));
				}
			}
		});

		rightLabel.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				System.out.println(itemArr.size());
				if (itemArr.size() - 1 > num4) {
					MyUtil.changePanel(f, Third.this, new Third(f, cate1, cate2, pageNum + 1));
				} else {
					JOptionPane.showMessageDialog(null, "마지막 페이지입니다.");
				}
			}
		});

		add(leftLabel);
		add(rightLabel);

		setVisible(true);

	}

	class MyPanel extends JPanel {

		public MyPanel(Item item) {

			setSize(200, 150);

			Image scaledImage = new ImageIcon(item.getItemImageUrl()).getImage().getScaledInstance(150, 100, 0);
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