package view.user;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import common.MyUtil;
import controller.Login;
import view.MainFrame;
import view.shop.First;

public class UserInfoPanel extends JPanel {

	MainFrame f;

	public UserInfoPanel(MainFrame f) {
		this.f = f;

		setBackground(Color.white);
		setLayout(null);
		f.setSize(450, 450);
		f.setLocationRelativeTo(null);
		f.setTitle("회원 정보 수정");

		JPanel defaultPanel = new JPanel();
		defaultPanel.setBounds(10, 10, 400, 120);
		defaultPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(defaultPanel);
		defaultPanel.setLayout(null);
		defaultPanel.setBackground(Color.white);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(12, 18, 77, 15);
		defaultPanel.add(idLabel);

		JTextField idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setBounds(101, 15, 145, 21);
		idTextField.setText(MainFrame.user.getId());
		idTextField.setEditable(false);
		defaultPanel.add(idTextField);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(12, 51, 77, 15);
		defaultPanel.add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(101, 48, 145, 21);
		nameTextField.setText(MainFrame.user.getName());
		nameTextField.setEditable(false);
		defaultPanel.add(nameTextField);

		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(12, 84, 77, 15);
		defaultPanel.add(birthLabel);

		JTextField birthTextField = new JTextField();
		birthTextField.setColumns(10);
		birthTextField.setBounds(101, 81, 145, 21);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		birthTextField.setText(sdf.format(MainFrame.user.getBirth()));
		birthTextField.setEditable(false);
		defaultPanel.add(birthTextField);

		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(10, 129, 400, 40);
		phonePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(phonePanel);
		phonePanel.setLayout(null);
		phonePanel.setBackground(Color.white);

		JLabel phoneLabel = new JLabel("핸드폰번호");
		phoneLabel.setBounds(12, 12, 72, 15);
		phonePanel.add(phoneLabel);

		JTextField phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(101, 9, 145, 21);
		phoneTextField.setText(MainFrame.user.getPhone());
		phoneTextField.setEditable(false);
		phonePanel.add(phoneTextField);

		JButton modifyPhoneBtn = new JButton("핸드폰번호 수정");
		modifyPhoneBtn.setBounds(268, 8, 130, 23);
		modifyPhoneBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("바꾸실 핸드폰 번호를 입력하세요.");
				if (input == null || input.equals("")) {

					JOptionPane.showMessageDialog(null, "취소하셨습니다.");

				} else {

					Login login = new Login();
					MainFrame.user.setPhone(input);
					login.setCustomer(MainFrame.user);

					MyUtil.changePanel(f, UserInfoPanel.this, new UserInfoPanel(f));
				}
			}
		});

		phonePanel.add(modifyPhoneBtn);

		JPanel pwPanel = new JPanel();
		pwPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pwPanel.setBounds(10, 168, 400, 120);
		add(pwPanel);
		pwPanel.setLayout(null);
		pwPanel.setBackground(Color.white);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(12, 18, 77, 15);
		pwPanel.add(pwLabel);

		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(101, 15, 145, 21);
		pwPanel.add(pwTextField);

		JLabel newPwLabel = new JLabel("신규비밀번호");
		newPwLabel.setBounds(12, 51, 80, 15);
		pwPanel.add(newPwLabel);

		JPasswordField newPwTextField = new JPasswordField();
		newPwTextField.setColumns(10);
		newPwTextField.setBounds(101, 48, 145, 21);
		pwPanel.add(newPwTextField);

		JLabel reNewPwLabel = new JLabel("비밀번호확인");
		reNewPwLabel.setBounds(12, 84, 80, 15);
		pwPanel.add(reNewPwLabel);

		JPasswordField reNewPwTextField = new JPasswordField();
		reNewPwTextField.setColumns(10);
		reNewPwTextField.setBounds(101, 81, 145, 21);
		pwPanel.add(reNewPwTextField);

		JButton modifyPwBtn = new JButton("비밀번호 수정");
		modifyPwBtn.setBounds(268, 80, 120, 23);
		pwPanel.add(modifyPwBtn);

		modifyPwBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = pwTextField.getText();
				String newpw = newPwTextField.getText();
				String renewpw = reNewPwTextField.getText();
				if (!(MyUtil.valid("비밀번호", pwTextField) && MyUtil.valid("신규 비밀번호", newPwTextField)
						&& MyUtil.valid("신규 비밀번호 확인", reNewPwTextField))) {
					return;
				} else if (!MainFrame.user.getPw().equals(pw)) {
					MyUtil.focusMsg("비밀번호를 확인하세요", pwTextField);
					return;
				} else if (!newpw.equals(renewpw)) {
					MyUtil.focusMsg("비밀번호를 확인하세요", reNewPwTextField);
					return;
				} else if (pw.equals(newpw)) {
					MyUtil.focusMsg("같은 비밀번호로 변경하실 수 없습니다.", reNewPwTextField);
				} else {
					MainFrame.user.setPw(newpw);
					Login login = new Login();
					login.setCustomer(MainFrame.user);

					JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.\n로그인을 다시 하세요.");
					MainFrame.user = null;

					MyUtil.changePanel(f, UserInfoPanel.this, new LoginPanel(f));

				}
			}
		});

		JPanel addrPanel = new JPanel();
		addrPanel.setBounds(10, 287, 400, 46);
		addrPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(addrPanel);
		addrPanel.setLayout(null);
		addrPanel.setBackground(Color.white);

		JLabel addrLabel = new JLabel("주소");
		addrLabel.setBounds(12, 15, 72, 15);
		addrPanel.add(addrLabel);

		JTextField addrTextField = new JTextField();
		addrTextField.setColumns(10);
		addrTextField.setBounds(101, 12, 145, 21);
		addrTextField.setText(MainFrame.user.getAddr());
		addrTextField.setEditable(false);
		addrPanel.add(addrTextField);

		JButton addrBtn = new JButton("배송지 변경");
		addrBtn.setBounds(268, 11, 120, 23);
		addrPanel.add(addrBtn);

		addrBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("바꾸실 주소를 입력하세요.");
				if (input == null || input.equals("")) {

					JOptionPane.showMessageDialog(null, "취소하셨습니다.");

				} else {

					Login login = new Login();
					MainFrame.user.setAddr(input);
					login.setCustomer(MainFrame.user);

					MyUtil.changePanel(f, UserInfoPanel.this, new UserInfoPanel(f));
				}
			}
		});

		JButton exitBtn = new JButton("나가기");
		exitBtn.setBounds(151, 341, 97, 23);
		add(exitBtn);

		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, UserInfoPanel.this, new First(f));
			}
		});

	}

}
