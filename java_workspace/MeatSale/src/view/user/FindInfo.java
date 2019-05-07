package view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import common.MyUtil;
import controller.Login;
import model.vo.Customer;
import view.MainFrame;

public class FindInfo extends JPanel {

	private MainFrame f;
	private JPanel curPanel;

	public FindInfo(MainFrame f) {
		this.f = f;
		f.setSize(300, 300);
		f.setLocationRelativeTo(null);
		setLayout(null);

		JRadioButton idRadio = new JRadioButton("ID찾기");
		idRadio.setBounds(8, 6, 121, 23);
		idRadio.setSelected(true);
		add(idRadio);

		JRadioButton pwRadio = new JRadioButton("PW찾기");
		pwRadio.setBounds(150, 6, 121, 23);
		add(pwRadio);

		ButtonGroup bg = new ButtonGroup();
		bg.add(idRadio);
		bg.add(pwRadio);

		// 아이디 찾기 패널
		JPanel findIdPanel = new JPanel();
		findIdPanel.setBounds(8, 35, 268, 194);
		findIdPanel.setLayout(null);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(12, 59, 57, 15);
		findIdPanel.add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(133, 56, 116, 21);
		findIdPanel.add(nameTextField);

		JLabel phoneLabel = new JLabel("핸드폰 번호");
		phoneLabel.setBounds(12, 96, 100, 15);
		findIdPanel.add(phoneLabel);

		JTextField phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(133, 93, 116, 21);
		findIdPanel.add(phoneTextField);

		JButton findIdBtn = new JButton("ID 찾기");
		findIdBtn.setBounds(12, 154, 97, 23);
		findIdPanel.add(findIdBtn);
		
		findIdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				ArrayList<Customer> a = login.getCustomer();
				
				String result = login.findId(nameTextField.getText(), phoneTextField.getText());
				if(result == null) {
					JOptionPane.showMessageDialog(null, "해당하는 아이디가 없습니다");
				}else {
					JOptionPane.showMessageDialog(null, "해당하는 ID는 ' " + result + " '입니다.");
				}
				
			}
		});

		JButton cancleBtn = new JButton("취소");
		cancleBtn.setBounds(152, 154, 97, 23);
		findIdPanel.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new LoginPanel(f));
			}
		});
		
		cancleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new LoginPanel(f));
			}
		});

		// 비밀번호 찾기 패널
		JPanel findPwPanel = new JPanel();
		findPwPanel.setBounds(8, 35, 268, 194);
		findPwPanel.setLayout(null);

		JLabel lblNewLabel2 = new JLabel("아이디");
		lblNewLabel2.setBounds(12, 22, 57, 15);
		findPwPanel.add(lblNewLabel2);

		JTextField idTextField2 = new JTextField();
		idTextField2.setBounds(133, 19, 116, 21);
		findPwPanel.add(idTextField2);
		idTextField2.setColumns(10);

		JLabel nameLabel2 = new JLabel("이름");
		nameLabel2.setBounds(12, 59, 57, 15);
		findPwPanel.add(nameLabel2);

		JTextField nameTextField2 = new JTextField();
		nameTextField2.setColumns(10);
		nameTextField2.setBounds(133, 56, 116, 21);
		findPwPanel.add(nameTextField2);

		JLabel phoneLabel2 = new JLabel("핸드폰 번호");
		phoneLabel2.setBounds(12, 96, 100, 15);
		findPwPanel.add(phoneLabel2);

		JTextField phoneTextField2 = new JTextField();
		phoneTextField2.setColumns(10);
		phoneTextField2.setBounds(133, 93, 116, 21);
		findPwPanel.add(phoneTextField2);

		JButton findPwBtn = new JButton("PW 찾기");
		findPwBtn.setBounds(12, 154, 97, 23);
		findPwPanel.add(findPwBtn);
		
		findPwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				String result = login.findPw(idTextField2.getText(), nameTextField2.getText(), phoneTextField2.getText());
				if(result == null) {
					JOptionPane.showMessageDialog(null, "해당하는 아이디가 없습니다");
				}else {
					JOptionPane.showMessageDialog(null, "해당하는 PW는 ' " + result + " '입니다.");
				}
			}
		});

		JButton canclBtn2 = new JButton("취소");
		canclBtn2.setBounds(152, 154, 97, 23);
		findPwPanel.add(canclBtn2);

		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton radio = (JRadioButton) e.getSource();

				String text = radio.getText();

				if (text.equals("ID찾기")) {
					remove(curPanel);
					add(findIdPanel);
					curPanel=findIdPanel;
					repaint();
				} else if (text.equals("PW찾기")) {
					remove(curPanel);
					add(findPwPanel);
					curPanel=findPwPanel;
					repaint();
				}

			}
		};
		
		//기본값 ID찾기
		add(findIdPanel);
		curPanel=findIdPanel;
		
		idRadio.addActionListener(al);
		pwRadio.addActionListener(al);

	}

}
