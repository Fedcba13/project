package view.shop;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import check.MyCart;
import common.MyUtil;
import controller.Goods;
import controller.Login;
import model.vo.Item;
import view.MainFrame;

public class Fourth extends JPanel {
	private MainFrame f;
	private Item item;
	private String total;

	public Fourth(MainFrame f, Item item) {
		this.f = f;
		this.item = item;

		f.setSize(450, 400);
		f.setLocationRelativeTo(null);
		setLayout(null);

		Image scaledImage = new ImageIcon(item.getItemImageUrl()).getImage().getScaledInstance(150, 140, 0);
		JLabel name = new JLabel(item.getItemName() + "");
		JLabel price = new JLabel(item.getItemPrice() + "원");
		name.setBounds(214, 47, 133, 16);
		price.setBounds(214, 91, 73, 22);
		add(name);
		add(price);
		JLabel img = new JLabel(new ImageIcon(scaledImage));

		img.setBounds(12, 21, 199, 149);

		add(img);

		JLabel origin = new JLabel("원산지 : " + item.getItemOrigin());
		origin.setBounds(340, 91, 101, 22);
		add(origin);

		JLabel category = new JLabel(item.getItemCategory() + " > " + item.getItemCategory2());
		category.setBounds(340, 34, 89, 16);
		add(category);

		JLabel amount = new JLabel("남은 수량 : " + item.getItemAmount());
		amount.setBounds(340, 60, 79, 22);
		add(amount);

		JButton cart = new JButton("장바구니");
		cart.setBounds(77, 260, 95, 30);
		add(cart);

		JButton back = new JButton("처음으로");
		back.setBounds(200, 260, 109, 30);
		add(back);
		back.addMouseListener(new MyMouseListener());

		JSpinner spinner = new JSpinner();
		spinner.setBounds(184, 180, 79, 22);
		add(spinner);
		

		JLabel totalprice;

		if (item.getItemAmount() == 0) {
			spinner.setValue(0);
			totalprice = new JLabel("재고 없음");
			totalprice.setForeground(Color.red);
		} else {
			spinner.setValue(1);
			totalprice = new JLabel("총 가격 : " + item.getItemPrice() + "원");
		}

		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				int num = (int) spinner.getValue();
				
				if (item.getItemAmount() == 0 && num == 0) {

				} else if (item.getItemAmount() == 0) {
					JOptionPane.showMessageDialog(null, "재고가 없어서 구매가 불가능합니다.");
					num = 0;
					spinner.setValue(num);
				} else if (num > item.getItemAmount()) {
					JOptionPane.showMessageDialog(null, "남은 수량을 초과하였습니다.");
					num = item.getItemAmount();
					spinner.setValue(num);
				} else if (num < 1) {
					JOptionPane.showMessageDialog(null, "1개이상 선택해 주세요.");
					num = 1;
					spinner.setValue(num);
				}

				if (num == 0) {
					totalprice.setText("재고 없음");
				} else {
					totalprice.setText("총 가격 : " + (num * item.getItemPrice()) + "원");
				}

			}
		});
		totalprice.setBounds(130, 206, 120, 29);
		add(totalprice);

		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, item.getDeliver());
		Date day = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일");
		JLabel delivery = new JLabel(sdf.format(day) + "배송예정");
		delivery.setBounds(214, 142, 145, 16);
		add(delivery);

		JLabel lblNewLabel = new JLabel("수량 : ");
		lblNewLabel.setBounds(136, 183, 36, 15);
		add(lblNewLabel);

		cart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(MainFrame.user == null) {
					JOptionPane.showMessageDialog(null, "로그인 부터 해주세요.");
					return;
				}

				if (Integer.parseInt(spinner.getValue().toString()) == 0) {
					JOptionPane.showMessageDialog(null, "재고가 없어서 구매가 불가능합니다.");
					return;
				}

				ArrayList<Item> arr = MainFrame.user.getCart();
				if (arr == null) {
					arr = new ArrayList<Item>();
				}
				Item buyItem = new Item(item);
				int buyCnt = Integer.parseInt(spinner.getValue().toString());
				System.out.println("buycnt : " + buyCnt);
				buyItem.setItemAmount(buyCnt);
				arr.add(buyItem);

				item.setItemAmount(item.getItemAmount() - buyCnt);
				MainFrame.user.setCart(arr);

				Goods goods = new Goods();
				goods.setItem(item);

				Login login = new Login();
				login.setCustomer(MainFrame.user);

				int result = JOptionPane.showConfirmDialog(null, "장바구니로 이동하시겠습니까?\n취소시 메인화면 ", "장바구니 이동",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {// 확인
					MyUtil.changePanel(f, MainFrame.currentPanel, new MyCart(f));
				} else {// 취소시 메인화면
					MyUtil.changePanel(f, MainFrame.currentPanel, new First(f));
				}

			}
		});

		setVisible(true);

	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MyUtil.changePanel(f, Fourth.this, new First(f));

		}

	}
}