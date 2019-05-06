package check;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.vo.Item;
import view.MainFrame;

public class ItemAdd extends JPanel {
	
	private ArrayList<Item> items = new ArrayList<Item>();

	private String c1[] = {"소", "돼지", "닭", "양"};
	private String c2[] = {"목심", "등심", "채끝", "안심", "우둔", "앞다리", "사태", "갈비", "양지", "설도", "우족"};
	private String c3[] = {"목살", "등심", "앞다리", "갈비", "갈매기살", "삼겹살", "사태", "안심", "뒷다리살"};
	private String c4[] = {"윗날개살", "아랫날개살", "안심＊가슴살", "윗다리살", "아랫다리살"};
	private String c5[] = {"목", "양갈비", "어깨", "가슴살 갈비", "배갈비", "등", "옆구리", "가슴", "다리"};
	
	private ArrayList<String> arr = new ArrayList<String>();
	private MainFrame f;
	
	public ItemAdd(MainFrame f) {
		this.f = f;
		setBounds(100, 100, 500, 400);
		f.setSize(600,500);
		setLayout(null);
		f.setTitle("상품 추가");
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 0, 484, 38);
		JLabel nameLabel = new JLabel("상품 이름을 입력하세요 : ");
		JTextField nameField = new JTextField(10);
		
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(0, 38, 484, 38);
		JLabel priceLabel = new JLabel("상품 가격을 입력하세요 : ");
		JTextField priceField = new JTextField(10);
		
		pricePanel.add(priceLabel);
		pricePanel.add(priceField);
		
		JPanel amountPanel = new JPanel();
		amountPanel.setBounds(0, 76, 484, 38);
		JLabel amountLabel = new JLabel("상품의 수량을 입력하세요 : ");
		JTextField amountField = new JTextField(10);
		
		amountPanel.add(amountLabel);
		amountPanel.add(amountField);
		
		JPanel originPanel = new JPanel();
		originPanel.setBounds(0, 114, 484, 38);
		JLabel originLabel = new JLabel("상품의 원산지를 입력하세요 : ");
		JTextField originField = new JTextField(10);
		
		originPanel.add(originLabel);
		originPanel.add(originField);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(0, 152, 484, 38);
		JLabel categoryLabel = new JLabel("고기 종류1");
		JComboBox<String> categoryBox = new JComboBox<String>(c1);
		
		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryBox);
		
		JPanel categoryPanel2 = new JPanel();
		categoryPanel2.setBounds(0, 190, 484, 38);
		JLabel categoryLabel2 = new JLabel("고기 종류2");
		
		categoryBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(categoryBox.getSelectedItem().toString() == "소") {
					for(int i = 0; i < c2.length; i++) {
						arr.add(c2[i]);
					}
				} else if(categoryBox.getSelectedItem().toString() == "돼지") {
					for(int i = 0; i < c3.length; i++) {
						arr.add(c3[i]);
					}
				} else if(categoryBox.getSelectedItem().toString() == "닭") {
					for(int i = 0; i < c4.length; i++) {
						arr.add(c4[i]);
					}
				} else if(categoryBox.getSelectedItem().toString() == "양") {
					for(int i = 0; i < c5.length; i++) {
						arr.add(c5[i]);
					}
				}
			}
		});
		
		String[] resultarr = arr.toArray(new String[arr.size()]);
		JComboBox<String> categoryBox2 = new JComboBox<String>(resultarr);
		
		categoryPanel2.add(categoryLabel2);
		categoryPanel2.add(categoryBox2);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 228, 484, 38);
		JButton addButton = new JButton("추가");
		JButton cancel = new JButton("취소");
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				items.add(new Item(nameField.toString(), Integer.parseInt(priceField.toString()),
//						originField.toString(), categoryBox.toString(), categoryBox2.toString())); 
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//취소버튼
			}
		});
		
		buttonPanel.add(addButton);
		buttonPanel.add(cancel);
		
		add(namePanel);
		add(pricePanel);
		add(amountPanel);
		add(originPanel);
		add(categoryPanel);
		add(categoryPanel2);
		add(buttonPanel);
		
		setVisible(true);
	}
}
