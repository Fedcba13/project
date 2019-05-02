package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import common.MyUtil;

public class Menu extends JMenu {

	MainFrame f;

	public Menu(MainFrame f) {
		this.f = f;

		JMenuBar menuBar = new JMenuBar();

		JMenu mainMenu = new JMenu("메인화면");
		mainMenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new TestPanel(f));
			}
		});

		JMenu cartMenu = new JMenu("장바구니");
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
				MyUtil.changePanel(f, MainFrame.currentPanel, new TestPanel(f));
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

		JMenuItem deliverMenuItem = new JMenuItem("배송조회");
		JMenuItem payMenuItem = new JMenuItem("결제 내역");

		deliverMenu.add(modifyMenuItem);
		deliverMenu.add(deliverMenuItem);
		deliverMenu.add(payMenuItem);

		menuBar.add(mainMenu);
		menuBar.add(cartMenu);
		menuBar.add(deliverMenu);

		if (MainFrame.user == null) {
			menuBar.add(loginMenu);
		} else {
			menuBar.add(logoutMenu);
		}

		f.setJMenuBar(menuBar);

		setVisible(true);
	}
}
