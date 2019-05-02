package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.MyUtil;
import controller.Login;
import model.vo.Customer;

public class RegisterPanel extends JPanel {

	boolean idCheck = false; // 중복확인여부

	private MainFrame f;

	public RegisterPanel(MainFrame f) {
		this.f = f;

		Login register = new Login();

		setLayout(null);
		f.setTitle("회원가입");
		f.setSize(420, 420);
		f.setLocationRelativeTo(null);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(12, 21, 77, 15);
		add(idLabel);

		JTextField idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setBounds(101, 18, 145, 21);
		add(idTextField);

		// idTextField가 수정될때마다 중복확인값을 false로 지정
		idTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				idCheck = false;
			}
		});

		JButton sameIdCheck = new JButton("중복확인");
		sameIdCheck.setBounds(280, 17, 97, 23);
		add(sameIdCheck);

		// 중복확인을 누르고 중복된 값이 없으면 sameIdcheck를 true로 지정
		sameIdCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				if (!MyUtil.valid("아이디", idTextField)) {// id가 빈값인지 확인
					return;
				} else {
					idCheck = register.sameIdCheck(id);// 중복값이 없으면 true 반환
					if (idCheck) {
						JOptionPane.showMessageDialog(null, "사용하실 수 있는 아이디 입니다.");
					} else {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
					}
				}
			}
		});

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(12, 57, 77, 15);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(101, 54, 145, 21);
		add(nameTextField);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(12, 93, 77, 15);
		add(pwLabel);

		JTextField pwTextField = new JTextField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(101, 90, 145, 21);
		add(pwTextField);

		JLabel repwLabel = new JLabel("비밀번호확인");
		repwLabel.setBounds(12, 129, 88, 15);
		add(repwLabel);

		JTextField repwTextField = new JTextField();
		repwTextField.setColumns(10);
		repwTextField.setBounds(101, 126, 145, 21);
		add(repwTextField);

		JLabel samePwCheck = new JLabel("비밀번호를 입력 해 주세요");
		samePwCheck.setBounds(101, 165, 234, 15);
		add(samePwCheck);

		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (pwTextField.getText().equals("")) {
					samePwCheck.setText("비밀번호를 입력 해 주세요.");
					samePwCheck.setForeground(Color.red);
				} else if (repwTextField.getText().equals("")) {
					samePwCheck.setText("비밀번호확인을 입력 해 주세요.");
					samePwCheck.setForeground(Color.red);
				} else if (pwTextField.getText().equals(repwTextField.getText())) {
					samePwCheck.setText("비밀번호가 일치합니다");
					samePwCheck.setForeground(Color.blue);
				} else {
					samePwCheck.setText("비밀번호가 일치하지 않습니다");
					samePwCheck.setForeground(Color.RED);
				}
			}
		};

		repwTextField.addKeyListener(keyAdapter);
		pwTextField.addKeyListener(keyAdapter);

		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(12, 201, 77, 15);
		add(birthLabel);

		JTextField birthTextField = new JTextField();
		birthTextField.setColumns(10);
		birthTextField.setBounds(101, 198, 145, 21);
		add(birthTextField);

		JLabel birthEx = new JLabel("ex)910815");
		birthEx.setBounds(280, 205, 72, 15);
		add(birthEx);

		JLabel phoneLabel = new JLabel("핸드폰번호");
		phoneLabel.setBounds(12, 237, 72, 15);
		add(phoneLabel);

		JTextField phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(101, 234, 145, 21);
		add(phoneTextField);

		JLabel phoneEx = new JLabel("ex)01040418769");
		phoneEx.setBounds(280, 240, 97, 15);
		add(phoneEx);

		JLabel addrLabel = new JLabel("주소");
		addrLabel.setBounds(12, 273, 72, 15);
		add(addrLabel);

		JTextField addrTextField = new JTextField();
		addrTextField.setColumns(10);
		addrTextField.setBounds(101, 270, 145, 21);
		add(addrTextField);

		JButton registerBtn = new JButton("가입하기");
		registerBtn.setBounds(55, 309, 97, 23);
		add(registerBtn);
		registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String name = nameTextField.getText();
				String pw = pwTextField.getText();
				String repw = repwTextField.getText();
				String birth = birthTextField.getText();
				String phone = phoneTextField.getText();
				String addr = addrTextField.getText();

				// 유효성 검사(빈값 검사 및 자리수 검사)
				// phone은 11자리, birth는 6자리가 아니면 에러.
				if (!(MyUtil.valid("아이디", idTextField) && MyUtil.valid("이름", nameTextField)
						&& MyUtil.valid("비밀번호", pwTextField) && MyUtil.valid("비밀번호확인", repwTextField)
						&& MyUtil.valid("생년월일", birthTextField) && MyUtil.valid("핸드폰번호", phoneTextField)
						&& MyUtil.valid("주소", addrTextField))) {
					return;
				} else if (!((birth.length() == 6) && MyUtil.isNum(birth))) {// 생년월일 6자리인지 확인, 전부 숫자인지 확인.
					MyUtil.focusMsg("생년월일 값이 올바르지 않습니다.", birthTextField);
					return;
				} else if (!((phone.length() == 11) && MyUtil.isNum(phone))) {// 핸드폰번호 11자리인지 확인, 전부 숫자인지 확인.
					MyUtil.focusMsg("핸드폰번호 값이 올바르지 않습니다.", phoneTextField);
					return;
				} else if (!idCheck) {// id 중복확인 했는지 확인
					JOptionPane.showMessageDialog(null, "중복확인을 해주세요");
					return;
				} else if (!pw.equals(repw)) {// 비밀번호와 비밀번호확인 값이 일치하지 않을 때
					MyUtil.focusMsg("비밀번호를 확인해 주세요.", repwTextField);
					return;
				} else {// 전부 빈 값이 아닐때 (정상적인 값이 들어왔을 때)
					int year = Integer.parseInt(birth.substring(0, 2));
					int month = Integer.parseInt(birth.substring(2, 4)) - 1;
					int day = Integer.parseInt(birth.substring(4, 6));

					if (year < 20) {
						year += 20;
					}

					Calendar calendar = new GregorianCalendar(year, month, day);
					Date date = new Date(calendar.getTimeInMillis());

					register.addCustomer(new Customer(id, name, pw, addr, date, phone));

					JOptionPane.showMessageDialog(null, "회원가입 성공");
					MyUtil.changePanel(f, RegisterPanel.this, new LoginPanel(f));

				}

			}
		});

		JButton cancleBtn = new JButton("취소하기");
		cancleBtn.setBounds(187, 309, 97, 23);
		add(cancleBtn);

		cancleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, RegisterPanel.this, new LoginPanel(f));
			}
		});
		

	}

}
