package check;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import common.MyUtil;
import controller.Goods;
import model.vo.Item;
import view.MainFrame;
import view.manage.ItemManagePanel;

public class ItemAdd extends JPanel {

	private String cate[] = { "고기종류를 선택해 주세요.", "소", "돼지", "닭", "양" };
	private String cow[] = { "목심", "등심", "채끝", "안심", "우둔", "앞다리", "사태", "갈비", "양지", "설도", "우족" };
	private String pork[] = { "목살", "등심", "앞다리", "갈비", "갈매기살", "삼겹살", "사태", "안심", "뒷다리살" };
	private String chicken[] = { "윗날개살", "아랫날개살", "안심＊가슴살", "윗다리살", "아랫다리살" };
	private String lamb[] = { "목", "양갈비", "어깨", "가슴살 갈비", "배갈비", "등", "옆구리", "가슴", "다리" };

	private String paint = "";

	private MainFrame f;

	public ItemAdd(MainFrame f) {
		this.f = f;
		setBounds(100, 100, 500, 400);
		f.setSize(600, 580);
		setLayout(null);
		f.setTitle("상품 추가");

		JLabel image = new JLabel();
		image.setBounds(188, 10, 100, 100);
		image.setBorder(new LineBorder(Color.black));
		add(image);

		image.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(paint);
			}

		});

		JButton addPic = new JButton("사진 추가");
		addPic.setBounds(300, 10, 100, 50);
		addPic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("그림 파일", "jpg", "png", "gif"));

				int returnState = fc.showOpenDialog(null);
				// returnState 1 CANCEL_OPTION: 취소
				// returnState 0 APPROVE_OPTION: 정상적으로 선택
				// returnState -1 ERROR_OPTION: 에러 발생

				if (returnState == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					String realPath = f.getPath();
					String fileName = f.getName();

					int pos = fileName.lastIndexOf(".");
					String ext = fileName.substring(pos + 1);

					if (ext.toLowerCase().equals("jpg") || ext.toLowerCase().equals("png")) {

						String s = copyFile(realPath);

						if (s == null) {
							return;
						}

						Image icon = new ImageIcon(s).getImage().getScaledInstance(150, 150, 0);

						image.setIcon(new ImageIcon(icon));
						paint = s;
					} else {
						JOptionPane.showMessageDialog(null, "png,jpg 파일만 선택해줘요.");
					}

				}

			}
		});

		JButton delPic = new JButton("사진 삭제");
		delPic.setBounds(300, 60, 100, 50);
		delPic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				image.setIcon(null);
				paint = "";
			}
		});

		add(addPic);
		add(delPic);

		JPanel namePanel = new JPanel();
		namePanel.setBounds(12, 126, 560, 38);
		JLabel nameLabel = new JLabel("상품 이름을 입력하세요 : ");
		JTextField nameField = new JTextField(10);

		namePanel.add(nameLabel);
		namePanel.add(nameField);

		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(12, 174, 560, 38);
		JLabel priceLabel = new JLabel("상품 가격을 입력하세요 : ");
		JTextField priceField = new JTextField(10);

		pricePanel.add(priceLabel);
		pricePanel.add(priceField);

		JPanel amountPanel = new JPanel();
		amountPanel.setBounds(12, 222, 560, 38);
		JLabel amountLabel = new JLabel("상품의 수량을 입력하세요 : ");
		JTextField amountField = new JTextField(10);

		amountPanel.add(amountLabel);
		amountPanel.add(amountField);

		JPanel originPanel = new JPanel();
		originPanel.setBounds(12, 270, 560, 38);
		JLabel originLabel = new JLabel("상품의 원산지를 입력하세요 : ");
		JTextField originField = new JTextField(10);

		originPanel.add(originLabel);
		originPanel.add(originField);

		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(12, 318, 560, 38);
		JLabel categoryLabel = new JLabel("고기 종류");
		JComboBox<String> categoryBox = new JComboBox<String>(cate);

		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryBox);

		JPanel categoryPanel2 = new JPanel();
		categoryPanel2.setBounds(12, 366, 560, 38);
		JLabel categoryLabel2 = new JLabel("부위");

		JComboBox<String> categoryBox2 = new JComboBox<String>();
		categoryBox2.addItem("고기종류를 선택해 주세요.");

		categoryBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (categoryBox.getItemAt(0).toString().equals("고기종류를 선택해 주세요.")) {// 기본값 삭제
					categoryBox.removeItemAt(0);
					// categoryBox.repaint();
				}

				categoryBox2.removeAllItems();

				if (categoryBox.getSelectedItem().toString().equals("소")) {
					for (int i = 0; i < cow.length; i++) {
						categoryBox2.addItem(cow[i]);
					}
				} else if (categoryBox.getSelectedItem().toString().equals("돼지")) {
					for (int i = 0; i < pork.length; i++) {
						categoryBox2.addItem(pork[i]);
					}
				} else if (categoryBox.getSelectedItem().toString().equals("닭")) {
					for (int i = 0; i < chicken.length; i++) {
						categoryBox2.addItem(chicken[i]);
					}
				} else if (categoryBox.getSelectedItem().toString().equals("양")) {
					for (int i = 0; i < lamb.length; i++) {
						categoryBox2.addItem(lamb[i]);
					}
				}
			}
		});

		categoryPanel2.add(categoryLabel2);
		categoryPanel2.add(categoryBox2);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 462, 560, 38);
		JButton addButton = new JButton("추가");
		JButton cancel = new JButton("취소");

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Goods goods = new Goods();
				String itemName = nameField.getText();
				int itemPrice = Integer.parseInt(priceField.getText());
				int itemAmount = Integer.parseInt(amountField.getText());
				String itemOrigin = originField.getText();
				String itemCategory = categoryBox.getSelectedItem().toString();
				String itemCategory2 = categoryBox2.getSelectedItem().toString();
				int deliver = 3; // 그냥 일단 넣음
				String itemImageUrl = paint;

				Item item = new Item(goods.getMaxNum(), itemName, itemPrice, itemAmount, itemOrigin, itemCategory,
						itemCategory2, deliver, itemImageUrl);
				System.out.println(item);
				goods.addItem(item);
				MyUtil.changePanel(f, MainFrame.currentPanel, new ItemManagePanel(f));
			}
		});

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainFrame.currentPanel, new ItemManagePanel(f));
			}
		});

		buttonPanel.add(addButton);
		buttonPanel.add(cancel);

		JPanel deliveryPanel = new JPanel();
		deliveryPanel.setBounds(12, 414, 560, 38);
		f.getContentPane().add(deliveryPanel);

		JLabel deliveryLabel = new JLabel("배송일");
		deliveryPanel.add(deliveryLabel);

		JTextField deliveryTextField = new JTextField();
		deliveryPanel.add(deliveryTextField);
		deliveryTextField.setColumns(10);

		add(namePanel);
		add(pricePanel);
		add(amountPanel);
		add(originPanel);
		add(categoryPanel);
		add(categoryPanel2);
		add(buttonPanel);
		add(deliveryPanel);

	}

	public String copyFile(String url) {

		File file = new File(url);
		String tmp = file.getName();

		String url1 = "images/" + tmp;// 복사후
		String url2 = url;// 복사전

		try (FileInputStream fis = new FileInputStream(url2); FileOutputStream fos = new FileOutputStream(url1);) {

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			return url1;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
