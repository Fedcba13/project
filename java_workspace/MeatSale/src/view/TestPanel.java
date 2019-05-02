package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.MyUtil;

public class TestPanel extends JPanel{
	
	MainFrame f;
	
	public TestPanel(MainFrame f) {
		
		this.f = f;
		f.setLocationRelativeTo(null);
		
		setSize(180,300);
		setLayout(null);
		f.setSize(200,400);
		
		JLabel lblNewLabel = new JLabel(MainFrame.user.getName()+"님 환영해요.");
		lblNewLabel.setBounds(10,10,100,50);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.setBounds(10, 80, 100, 50);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, TestPanel.this, new LoginPanel(f));
			}
		});

	}

}
