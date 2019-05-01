package common;

import javax.swing.JPanel;

import view.MainFrame;

public class MyUtil {
	
	public static void changePanel(MainFrame f, JPanel old, JPanel new_) {
		f.add(new_);
		f.remove(old);
		
		//다시 그려주기
		f.repaint();
		
		
		
	}

}
