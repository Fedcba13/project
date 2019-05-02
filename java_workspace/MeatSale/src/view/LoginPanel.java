package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.MyUtil;
import controller.Login;
import model.vo.Customer;

public class LoginPanel extends JPanel {

	private MainFrame f;

	public LoginPanel(MainFrame f) {
		// 부모 컴포넌트를 필드로 참조
		this.f = f;

		f.setSize(380, 210);
		f.setLocationRelativeTo(null);
		f.setTitle("로그인");

		setLayout(null);

		JTextField idTextField = new JTextField();
		idTextField.setBounds(119, 33, 116, 21);
		idTextField.setColumns(10);
		add(idTextField);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(35, 36, 40, 15);
		add(idLabel);

		JTextField pwTextField = new JTextField();
		pwTextField.setBounds(119, 92, 116, 21);
		pwTextField.setColumns(10);
		add(pwTextField);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(35, 95, 55, 15);
		add(pwLabel);

		JLabel findIdPw = new JLabel("ID/PW 찾기");
		findIdPw.setBounds(119, 144, 63, 15);
		add(findIdPw);

		JLabel register = new JLabel("회원가입");
		register.setBounds(257, 144, 55, 15);
		add(register);
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyUtil.changePanel(f, LoginPanel.this, new RegisterPanel(f));
			}
		});

		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(257, 32, 96, 81);
		add(loginBtn);

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String pw = pwTextField.getText();

				Login login = new Login();
				login.login(new Customer(id, pw));
				
				MyUtil.changePanel(f, LoginPanel.this, new TestPanel(f));

			}
		});

		System.out.println(MainFrame.user);
	}

}
