package view.shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.MyUtil;
import controller.Login;
import controller.Pay;
import model.vo.Item;
import model.vo.Payment;
import view.MainFrame;

public class MyCart extends JPanel {

	private JPanel checkPanel;
	private ArrayList<Item> items = MainFrame.user.getCart();
	private JCheckBox[] checkboxes;
	private JLabel[] pricelabel;
	private JPanel resultPanel;
	private JLabel result;
	private JLabel won;
	private JPanel buttonPanel;
	private JButton buy;
	private JButton delete;
	private ArrayList<Item> check = new ArrayList<Item>(); // 체크한거
	private ArrayList<Item> buylist = new ArrayList<Item>(); // 구매한거
	private ArrayList<Item> deletelist = new ArrayList<Item>(); // 삭제한거

	public MyCart(MainFrame f) {
		f.setSize(500, 500);
		setLayout(null);

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(SystemColor.textHighlight);
		titlePanel.setLayout(null);
		titlePanel.setBounds(0, 0, 500, 40);
		add(titlePanel);

		JLabel lblNewLabel = new JLabel("장바구니");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 10, 73, 18);
		titlePanel.add(lblNewLabel);

		checkPanel = new JPanel();
		checkPanel.setBackground(new Color(250, 128, 114));
		checkPanel.setLayout(null);
		checkPanel.setBounds(0, 40, 500, 290);

		JLabel lblNewLabel_1 = new JLabel("상품 정보");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 264, 40);
		checkPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("수량");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(263, 0, 92, 40);
		checkPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("금액");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(356, 0, 128, 40);
		checkPanel.add(lblNewLabel_3);

		checkboxes = new JCheckBox[items.size()];

		pricelabel = new JLabel[items.size()];
		resultPanel = new JPanel();
		resultPanel.setBackground(new Color(255, 127, 80));
		resultPanel.setLayout(null);
		resultPanel.setBounds(0, 330, 500, 50);

		JLabel label = new JLabel("결제 예정 금액 :");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		label.setBounds(118, 1, 129, 50);
		resultPanel.add(label);

		result = new JLabel("0");
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		result.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		result.setBounds(250, 1, 60, 50);
		won = new JLabel("원");
		won.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		won.setBounds(313, 1, 24, 50);

		resultPanel.add(result);
		resultPanel.add(won);

		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setBounds(0, 380, 500, 50);

		buy = new JButton("주문하기");
		buy.setBounds(70, 10, 90, 23);
		delete = new JButton("삭제하기");
		delete.setBounds(180, 10, 90, 23);

		buy.addActionListener(new ActionListener() {// 주문하기
			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < checkboxes.length; i++) {
					if (checkboxes[i].isSelected()) {
						deletelist.add(items.get(i));
						buylist.add(items.get(i));
					}
				}

				for (int i = 0; i < check.size(); i++) {
					for (int j = 0; j < deletelist.size(); j++) {
						if (check.get(i) == deletelist.get(j)) {
							check.remove(i);
						}
					}
				}

				MainFrame.user.setCart(check);
				Login login = new Login();
				login.setCustomer(MainFrame.user);// 장바구니 저장

				Pay pay = new Pay();
				Date date = new Date();
				for (int i = 0; i < buylist.size(); i++) {
					pay.addPayment(new Payment(MainFrame.user.getId(), buylist.get(i), date));
				}//구매내역 저장
				
				JOptionPane.showMessageDialog(null, "구매 성공");
				
				MyUtil.changePanel(f, MainFrame.currentPanel, new First(f));
				
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < checkboxes.length; i++) {
					if (checkboxes[i].isSelected()) {
						deletelist.add(items.get(i));
						buylist.add(items.get(i));
					}
				}

				for (int i = 0; i < check.size(); i++) {
					for (int j = 0; j < deletelist.size(); j++) {
						if (check.get(i) == deletelist.get(j)) {
							check.remove(i);
						}
					}
				}
				
				MainFrame.user.setCart(check);
				Login login = new Login();
				login.setCustomer(MainFrame.user);// 장바구니 저장
				
				MyUtil.changePanel(f, MainFrame.currentPanel, new MyCart(f));
				
			}
		});
		buttonPanel.setLayout(null);

		buttonPanel.add(buy);
		buttonPanel.add(delete);

		MyCartBuy();

		add(checkPanel);
		add(resultPanel);
		add(buttonPanel);
		
		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new First(f));
			}
		});
		btnNewButton.setBounds(290, 10, 90, 23);
		buttonPanel.add(btnNewButton);

		setVisible(true);
	}

	void MyCartBuy() {
		int x = 54;
		int y = 41;
		int z = 44;

		for (int i = 0; i < checkboxes.length; i++) {
			checkboxes[i] = new JCheckBox(items.get(i).getItemName());
			pricelabel[i] = new JLabel((items.get(i).getItemPrice()*items.get(i).getItemAmount()) + "원");
			check.add(items.get(i));

			checkboxes[i].setBackground(new Color(255, 99, 71));
			checkboxes[i].setBounds(0, y, 264, 40);

			pricelabel[i].setBounds(391, x, 58, 19);
			pricelabel[i].setHorizontalAlignment(SwingConstants.CENTER);

			JLabel amount = new JLabel(items.get(i).getItemAmount() + "");
			amount.setBounds(300, z, 53, 35);
			checkPanel.add(amount);

			x += 42;
			y += 42;
			z += 42;
		}

		for (int i = 0; i < checkboxes.length; i++) {
			checkPanel.add(checkboxes[i]);
			checkPanel.add(pricelabel[i]);
		}

		for (int i = 0; i < checkboxes.length; i++) {
			checkboxes[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String s = "";

					int sum = 0;

					for (int i = 0; i < checkboxes.length; i++) {
						if (checkboxes[i].isSelected()) {
							s = checkboxes[i].getText();
							if (s == items.get(i).getItemName()) {
								sum += (items.get(i).getItemPrice()*items.get(i).getItemAmount());
							}
						}
					}
					result.setText(sum + "");
				}
			});
		}
	}
}
