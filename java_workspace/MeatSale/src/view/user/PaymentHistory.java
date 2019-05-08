package view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import common.MyUtil;
import controller.Pay;
import model.vo.Payment;
import view.MainFrame;
import view.manage.DeliverManagePanel;

public class PaymentHistory extends JPanel {

	MainFrame f;
	private String[] columns;

	public PaymentHistory(MainFrame f, String name) {
		this.f = f;
		setLayout(null);

		f.setSize(650, 500);
		f.setLocationRelativeTo(null);

		Pay pay = new Pay();
		ArrayList<Payment> payArr = pay.getPayments();

		columns = new String[] { "구매자", "이름", "가격", "수량", "배송소요일", "구매날짜", "배송현황" };
		Object[][] rowData = pay.getArr(null, name);

		JTable table = new JTable(rowData, columns);

		table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {

				JOptionPane.showMessageDialog(null, "수정 금지");
				MyUtil.changePanel(f, MainFrame.currentPanel, new DeliverManagePanel(f));

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 87, 600, 150);
		add(scrollPane);

		scrollPane.setViewportView(table);

		JRadioButton allRadio = new JRadioButton("전체 보기");
		allRadio.setBounds(8, 58, 121, 23);
		add(allRadio);

		JRadioButton ingRadio = new JRadioButton("배송중");
		ingRadio.setBounds(167, 58, 121, 23);
		add(ingRadio);

		JRadioButton completeRadio = new JRadioButton("배송완료");
		completeRadio.setBounds(322, 58, 121, 23);
		add(completeRadio);	

		ButtonGroup bg = new ButtonGroup();
		bg.add(allRadio);
		bg.add(ingRadio);
		bg.add(completeRadio);

		ActionListener ac = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JRadioButton jr = (JRadioButton) e.getSource();
				Object[][] obj;
				if (jr.getText().equals("전체 보기")) {
					obj = pay.getArr(null, name);
				} else if (jr.getText().equals("배송중")) {
					obj = pay.getArr("배송중", name);
				} else {
					obj = pay.getArr("배송완료", name);
				}

				DefaultTableModel model = new DefaultTableModel(obj, columns);
				table.setModel(model);
			}
		};

		allRadio.addActionListener(ac);
		allRadio.setSelected(true);

		ingRadio.addActionListener(ac);
		completeRadio.addActionListener(ac);

	}

}
