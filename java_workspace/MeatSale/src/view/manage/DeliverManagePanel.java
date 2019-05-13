package view.manage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import common.MyUtil;
import controller.Pay;
import model.vo.Item;
import model.vo.Payment;
import view.MainFrame;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DeliverManagePanel extends JPanel {
	MainFrame f;
	private String[] columns;

	public DeliverManagePanel(MainFrame f) {
		this.f = f;

		f.setTitle("배송 목록 화면");
		setLayout(null);
		setBackground(Color.white);

		f.setSize(650, 500);
		f.setLocationRelativeTo(null);

		Pay pay = new Pay();

		columns = new String[] { "구매자", "이름", "가격", "수량", "배송소요일", "구매날짜", "배송현황" };
		Object[][] rowData = pay.getArr(null, null);

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

		JTextField searchId = new JTextField();
		searchId.setBounds(110, 31, 159, 21);
		add(searchId);
		searchId.setColumns(10);

		JRadioButton allRadio = new JRadioButton("전체 보기");
		allRadio.setBounds(8, 58, 121, 23);
		add(allRadio);

		JRadioButton ingRadio = new JRadioButton("배송중");
		ingRadio.setBounds(167, 58, 121, 23);
		add(ingRadio);

		JRadioButton completeRadio = new JRadioButton("배송완료");
		completeRadio.setBounds(322, 58, 121, 23);
		add(completeRadio);

		JLabel bel = new JLabel("아이디 검색");
		bel.setBounds(12, 34, 86, 15);
		add(bel);

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
					obj = pay.getArr(null, searchId.getText());
				} else if (jr.getText().equals("배송중")) {
					obj = pay.getArr("배송중", searchId.getText());
				} else {
					obj = pay.getArr("배송완료", searchId.getText());
				}

				DefaultTableModel model = new DefaultTableModel(obj, columns);
				table.setModel(model);
			}
		};

		allRadio.addActionListener(ac);
		allRadio.setSelected(true);

		JButton btnNewButton = new JButton("검색하기");
		btnNewButton.setBounds(312, 30, 97, 23);
		add(btnNewButton);
		ingRadio.addActionListener(ac);
		completeRadio.addActionListener(ac);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Object[][] obj;

				if (allRadio.isSelected()) {
					obj = pay.getArr(null, searchId.getText());
				} else if (ingRadio.isSelected()) {
					obj = pay.getArr("배송중", searchId.getText());
				} else {
					obj = pay.getArr("배송완료", searchId.getText());
				}

				DefaultTableModel model = new DefaultTableModel(obj, columns);
				table.setModel(model);

			}
		});

		ingRadio.setBackground(Color.white);
		allRadio.setBackground(Color.white);
		completeRadio.setBackground(Color.white);

	}

}
