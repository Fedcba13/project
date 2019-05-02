package common;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.MainFrame;
import view.Menu;

public class MyUtil {

	public static void changePanel(MainFrame f, JPanel old, JPanel new_) {

		f.remove(f.getJMenuBar());
		f.add(new Menu(f));
		
		
		f.remove(old);
		f.add(new_);
		
		MainFrame.currentPanel = new_;
		

		// 다시 그려주기
		f.revalidate();
		f.repaint();
		

	}

	// 유효성 검사(빈값인지 확인 후 boolean 값 return)
	// false 시 focus
	public static boolean valid(String s, JTextField j) {
		if (j.getText().equals("")) {
			focusMsg(s + " 값이 입력되지 않았습니다.", j);
			return false;
		}
		return true;
	}

	// focus + dialog띄우기
	/**
	 * 
	 * @param msg
	 * @param j
	 * 
	 * msg를 다이얼로그로 띄우고, j의 포커스를 줍니다.
	 */
	public static void focusMsg(String msg, JTextField j) {
		j.requestFocus();
		
		JOptionPane.showMessageDialog(null, msg);
	}

	// 숫자인지 확인하는 메소드
	public static boolean isNum(String s) {
		
		// 이미지를 눌렀을때 
		JOptionPane.showMessageDialog(null, "0");
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
