package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.MyUtil;

public class TestPanel extends JPanel {

	private MainFrame f;

	public TestPanel(MainFrame f) {

		this.f = f;

		f.setSize(400, 240);
		f.setLocationRelativeTo(null);
		setLayout(null);

		if (MainFrame.user == null) {

		} else {
			JLabel lblNewLabel = new JLabel(MainFrame.user.getName() + "님 환영해요.");
			lblNewLabel.setBounds(10, 10, 150, 50);
			add(lblNewLabel);

			JButton btnNewButton = new JButton("로그아웃");
			btnNewButton.setBounds(10, 80, 100, 50);
			add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.user = null;
					MyUtil.changePanel(f, TestPanel.this, new LoginPanel(f));
				}
			});

		}

	}

}
