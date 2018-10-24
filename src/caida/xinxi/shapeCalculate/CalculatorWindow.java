package caida.xinxi.shapeCalculate;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalculatorWindow extends JFrame implements ActionListener,ItemListener{
	CardLayout mycard;
	JPanel controlpananel,Pcenter;
	JComboBox chooseList;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem mainWindow,exit;
	
	//CalculatorWindow ��Ĺ��췽������ɶԳ���������ĳ�ʼ������
	public CalculatorWindow() {
		setTitle("��������ͼ�μ�����");
		
		//���ô��ڵĲ˵������˵����˵�����˵�����ע��ActionEvent�¼�������
		menuBar =new JMenuBar;
		menu=new JMenu("����");
		mainWindow=new JMenuItem("������");
		mainWindow.addActionListener(this);
		exit=new JMenuItem("�˳�");
		exit.addActionListener(this);
		menu.add(mainWindow);
		menu.add(exit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		//�������ڵ��в����һ�����pCenter���䲼����Cardlayout��
		mycard = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(mycard);
		add(pCenter,"center");
		
		//���һ���������controlPanel���ɹ�ѡ��ͼ�μ���
		controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		//���������б�chooseLIstanbul�������ѡ�ע�� ItemEventʱ�������
		chooseList = new JComboBox();
		chooseList.addItem("�뵥�������б�ѡ��");
		chooseList.addItem("���εĻ�������");
		chooseList.addItem("Բ�Ļ�������");
		chooseList.addItem("�����εĻ�������");
		chooseList.addItem("Բ���Ļ�������");
		chooseList.addItemListener(this);
		//������ͼ��İ�ť
		ImageIcon icon = new ImageIcon("image/MP900438781.jpg");
		JButoon imageButton = new JButoon(icon);
		//�ڿ������controlPanel��������������б�Ͱ�ť
		controlPanel.add(imageButoon,"Center");
		controlPanel.add(chooseList,"North");
		
		//�ھ���Cardlayout���ֵ����pCenter��������
		pCenter.add("0",controlPanel);
		pCenter.add("1",new RectanglePanel);
		pCenter.add("2",new CirclePanel);
		pCenter.add("3",new TrianglePanel);
		pCenter.add("4",new CylinderPanel);
		
		setBounds(100,100,700,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//���û�ѡ�������б��ѡ��ʱ������ItemEvent�¼����Զ�ִ�и÷����ڵĴ���
	public void itemStateChanged(ItemEvent e) {
		int index =chooseList.getSelectedIndex();
		String choice=String.valueOf(index);
		mycard.show(pCenter, choice);
	}
	
	//���û������˵�ѡ��ʱ������ActionEvent�¼����Զ�ִ�и÷����ڵĴ���
	public void actionPerformed(ActionEvent e) {
		//ѡ�������桱��������л��ؿ������controlPanel��״̬
		if(e.getSource()==mainWindow) {
			mycard.first(pCenter);
			chooseList.setSelectedIndex(0);
		}
	//ѡ���˳�������˳�����
		else if(e.getSource()==exit) {
			System.exit(0);
		}
	}
	public static void main(String [] args) {
		new CalculatorWindow();
	} 
}
	

