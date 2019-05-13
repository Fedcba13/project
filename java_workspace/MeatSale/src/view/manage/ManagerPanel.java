package view.manage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.MyUtil;
import view.MainFrame;

public class ManagerPanel extends JPanel{
	
	MainFrame f;
	
	public ManagerPanel(MainFrame f) {
		this.f = f;
		
		
		f.setTitle("관리자 메인 화면");
		setBackground(Color.white);
		f.setLocationRelativeTo(null);
		
		setLayout(null);
		f.setSize(360,400);

		JButton userBtn = new JButton("회원 관리");
		userBtn.setBounds(115, 30, 130, 60);
		add(userBtn);
		userBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, ManagerPanel.this, new UserManagePanel(f));
			}
			
		});

		JButton itemBtn = new JButton("상품 관리");
		itemBtn.setBounds(115, 120, 130, 60);
		add(itemBtn);
		
		itemBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, ManagerPanel.this, new ItemManagePanel(f));
			}
		});
		
		JButton deliverBtn = new JButton("배송 관리");
		deliverBtn.setBounds(115, 210, 130, 60);
		add(deliverBtn);

		deliverBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new DeliverManagePanel(f));
			}
		});
		

	}

}
