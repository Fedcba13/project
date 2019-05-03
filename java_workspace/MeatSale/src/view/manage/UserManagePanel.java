package view.manage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import common.MyUtil;
import controller.Login;
import model.vo.Customer;
import view.MainFrame;

public class UserManagePanel extends JPanel {

	MainFrame f;

	public UserManagePanel(MainFrame f) {
		this.f = f;
		setLayout(null);

		f.setSize(650, 500);
		f.setLocationRelativeTo(null);

		Login login = new Login();
		ArrayList<Customer> customerArr = login.getCustomer();

		String[] columns = { "아이디", "이름", "생년월일", "핸드폰 번호", "주소" };
		Object[][] rowData = new Object[customerArr.size()][columns.length];

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

		for (int i = 0; i < customerArr.size(); i++) {
			rowData[i][0] = customerArr.get(i).getId();
			rowData[i][1] = customerArr.get(i).getName();
			rowData[i][2] = sdf.format(customerArr.get(i).getBirth());
			rowData[i][3] = customerArr.get(i).getPhone();
			rowData[i][4] = customerArr.get(i).getAddr();
		}

		JTable table = new JTable(rowData, columns);

		table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				
				TableModel tm = (TableModel) e.getSource();

				int rowIndex = e.getFirstRow();
				int columnIndex = e.getColumn();

				String str;
				String newStr = tm.getValueAt(rowIndex, columnIndex).toString();

				if (columnIndex == 0) {
					JOptionPane.showMessageDialog(null, "아이디는 변경 금지 !! ");
				}else if(columnIndex==2) {
					JOptionPane.showMessageDialog(null, "생년월일은 변경 금지 !! ");
				} else {

					Customer c = customerArr.get(rowIndex);
					
					if(columnIndex == 1) {//이름
						str = customerArr.get(rowIndex).getName();
						c.setName(newStr);
					}else if(columnIndex == 3) {//핸드폰 번호
						str = customerArr.get(rowIndex).getPhone();
						c.setPhone(newStr);
					}else if(columnIndex == 4) {//주소
						str = customerArr.get(rowIndex).getAddr();
						c.setPhone(newStr);
					}else {
						return;
					}
					
					int result = JOptionPane.showConfirmDialog(null, str + "  =>  " + newStr + "로 변경 하시겠습니까?");

					if (result == JOptionPane.YES_OPTION) {// 확인
						login.setCustomer(c);
					}
					
				}
				
				//새로고침
				MyUtil.changePanel(f, MainFrame.currentPanel, new UserManagePanel(f));
				
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 600, 150);
		add(scrollPane);

		scrollPane.setViewportView(table);

	}

}
