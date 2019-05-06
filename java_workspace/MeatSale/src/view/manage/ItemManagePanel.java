package view.manage;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import common.MyUtil;
import controller.Goods;
import model.vo.Item;
import view.MainFrame;

public class ItemManagePanel extends JPanel{
	MainFrame f;
	
	public ItemManagePanel(MainFrame f) {
		this.f = f;
		setLayout(null);

		f.setSize(650, 500);
		f.setLocationRelativeTo(null);

		Goods goods = new Goods();
		ArrayList<Item> itemArr = goods.getItems();

		String[] columns = { "이름", "가격", "수량", "원산지", "분류1", "분류2" };
		Object[][] rowData = new Object[itemArr.size()][columns.length];

		for (int i = 0; i < itemArr.size(); i++) {
			rowData[i][0] = itemArr.get(i).getItemName();
			rowData[i][1] = itemArr.get(i).getItemPrice();
			rowData[i][2] = itemArr.get(i).getItemAmount();
			rowData[i][3] = itemArr.get(i).getItemOrigin();
			rowData[i][4] = itemArr.get(i).getItemCategory();
			rowData[i][5] = itemArr.get(i).getItemCategory2();
		}

		JTable table = new JTable(rowData, columns);

		table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				TableModel tm = (TableModel) e.getSource();

				int rowIndex = e.getFirstRow();
				int columnIndex = e.getColumn();

				String str = "";
				String newStr = tm.getValueAt(rowIndex, columnIndex).toString();

				// "이름", "가격", "수량", "원산지", "분류1", "분류2"
				if (columnIndex == 4) {
					JOptionPane.showMessageDialog(null, "분류1은 변경 금지 !! ");
				}else if(columnIndex==5) {
					JOptionPane.showMessageDialog(null, "분류2는 변경 금지 !! ");
				} else {

					Item c = itemArr.get(rowIndex);
					
					if(columnIndex == 0) {//이름
						str = itemArr.get(rowIndex).getItemName();
						c.setItemName(newStr);
					}else if(columnIndex == 1) {//가격
						int tmp = itemArr.get(rowIndex).getItemPrice();
						str = tmp + "";
						c.setItemPrice(tmp);
					}else if(columnIndex == 2) {//수량
						int tmp = itemArr.get(rowIndex).getItemAmount();
						str = tmp + "";
						c.setItemAmount(tmp);
					}else if(columnIndex == 3) {//원산지
						str = itemArr.get(rowIndex).getItemOrigin();
						c.setItemOrigin(str);
					}
					
					int result = JOptionPane.showConfirmDialog(null, str + "  =>  " + newStr + "로 변경 하시겠습니까?");

					if (result == JOptionPane.YES_OPTION) {// 확인
						goods.setItem(c);
					}
					
				}
				
				//새로고침
				MyUtil.changePanel(f, MainFrame.currentPanel, new ItemManagePanel(f));
				
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 600, 150);
		add(scrollPane);

		scrollPane.setViewportView(table);

	}

}
