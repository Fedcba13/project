package view;

import java.awt.Color;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import common.MyUtil;
import view.manage.DeliverManagePanel;
import view.manage.ManagerPanel;
import view.shop.First;
import view.shop.MyCart;
import view.user.LoginPanel;
import view.user.PaymentHistory;
import view.user.UserInfoPanel;

public class Menu extends JMenu {

	MainFrame f;

	public Menu(MainFrame f) {
		this.f = f;

		
		JMenuBar menuBar = new JMenuBar();

		menuBar.setBackground(Color.white);
		
		JMenu mainMenu = new JMenu("메인화면");
		mainMenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (MainFrame.user != null && MainFrame.user.getId().equals("admin")) {
					MyUtil.changePanel(f, MainFrame.currentPanel, new ManagerPanel(f));
				} else {
					MyUtil.changePanel(f, MainFrame.currentPanel, new First(f));
				}
			}
		});

		JMenu cartMenu = new JMenu("장바구니");
		cartMenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (MainFrame.user == null) {
					JOptionPane.showMessageDialog(null, "로그인 부터 하세요.");
				} else {
					MyUtil.changePanel(f, MainFrame.currentPanel, new MyCart(f));
				}
			}
		});

		JMenu deliverMenu = new JMenu("마이페이지");// 회원정보 수정. 배송조회 . 결제 내역

		JMenu loginMenu = new JMenu("로그인");
		loginMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new LoginPanel(f));
			}
		});

		JMenu logoutMenu = new JMenu("로그아웃");

		logoutMenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.user = null;
				MyUtil.changePanel(f, MainFrame.currentPanel, new First(f));
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
			}
		});

		JMenuItem modifyMenuItem = new JMenuItem("회원정보 수정");
		modifyMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.user == null) {
					JOptionPane.showMessageDialog(null, "로그인 부터 하세요.");
				} else {
					MyUtil.changePanel(f, MainFrame.currentPanel, new UserInfoPanel(f));
				}
			}
		});

		JMenuItem payMenuItem = new JMenuItem("결제 내역");

		payMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.user == null) {
					JOptionPane.showMessageDialog(null, "로그인 부터 하세요.");
				} else {
					MyUtil.changePanel(f, MainFrame.currentPanel, new PaymentHistory(f, MainFrame.user.getId()));
				}
			}
		});

		deliverMenu.add(modifyMenuItem);
		deliverMenu.add(payMenuItem);

		if (MainFrame.user == null) {
			menuBar.add(mainMenu);
			menuBar.add(cartMenu);
			menuBar.add(deliverMenu);
			menuBar.add(loginMenu);
		} else if (MainFrame.user.getId().equals("admin")) {
			menuBar.add(mainMenu);
			menuBar.add(logoutMenu);
		} else {
			menuBar.add(mainMenu);
			menuBar.add(cartMenu);
			menuBar.add(deliverMenu);
			menuBar.add(logoutMenu);
		}

		f.setJMenuBar(menuBar);

		setVisible(true);
	}
}
