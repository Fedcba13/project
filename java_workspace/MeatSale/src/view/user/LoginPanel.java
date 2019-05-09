package view.user;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.MyUtil;
import controller.Login;
import model.vo.Customer;
import view.MainFrame;
import view.manage.ManagerPanel;
import view.shop.First;

public class LoginPanel extends JPanel {

	private MainFrame f;

	public LoginPanel(MainFrame f) {
		// 부모 컴포넌트를 필드로 참조
		this.f = f;

		f.setSize(380, 240);
		f.setLocationRelativeTo(null);
		f.setTitle("로그인");
		
		setBackground(Color.white);
		setLayout(null);

		JTextField idTextField = new JTextField();
		idTextField.setBounds(119, 33, 116, 21);
		idTextField.setColumns(10);
		add(idTextField);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(35, 36, 40, 15);
		add(idLabel);

		
		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setBounds(119, 92, 116, 21);
		pwTextField.setColumns(10);
		add(pwTextField);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(35, 95, 55, 15);
		add(pwLabel);

		JLabel findIdPw = new JLabel("ID/PW 찾기");
		findIdPw.setBounds(119, 144, 63, 15);
		add(findIdPw);
		findIdPw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new FindInfo(f));
			}
		});

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

				if (!MyUtil.valid("아이디", idTextField)) {
				} else if (!MyUtil.valid("비밀번호", pwTextField)) {
				} else if (id.equals("admin") && pw.equals("admin")) {
					MainFrame.user = new Customer("admin", "admin");
					MyUtil.changePanel(f, LoginPanel.this, new ManagerPanel(f));
				} else {
					Login login = new Login();
					int result = login.login(new Customer(id, pw));
					if(result == 1) {
						MyUtil.changePanel(f, LoginPanel.this, new First(f));						
					}else if(result == 0) {
						MyUtil.focusMsg("아이디가 존재하지 않습니다.", idTextField);
					}else {
						MyUtil.focusMsg("비밀번호가 올바르지 않습니다.", pwTextField);						
					}
				}

			}
		});
		
		//포커스 강제 지정
		idTextField.setFocusTraversalKeysEnabled(false);
		idTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_TAB) {
					 pwTextField.requestFocus();
				 }
				
			 }

		});
		
		pwTextField.setFocusTraversalKeysEnabled(false);
		pwTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_TAB) {
					 loginBtn.requestFocus();
				 }
				 
				 if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					 loginBtn.doClick();
				 }
				
			 }

		});
		
		loginBtn.setFocusTraversalKeysEnabled(false);
		loginBtn.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_TAB) {
					 idTextField.requestFocus();
				 }
				
			 }

		});
		
	}

}
