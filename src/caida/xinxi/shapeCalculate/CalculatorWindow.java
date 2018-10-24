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
	
	//CalculatorWindow 类的构造方法，完成对程序主界面的初始化工作
	public CalculatorWindow() {
		setTitle("常见几何图形计算器");
		
		//设置窗口的菜单条，菜单，菜单项，给菜单单项注册ActionEvent事件监听器
		menuBar =new JMenuBar;
		menu=new JMenu("操作");
		mainWindow=new JMenuItem("主界面");
		mainWindow.addActionListener(this);
		exit=new JMenuItem("退出");
		exit.addActionListener(this);
		menu.add(mainWindow);
		menu.add(exit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		//在主窗口的中部添加一个面板pCenter，其布局是Cardlayout型
		mycard = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(mycard);
		add(pCenter,"center");
		
		//设计一个控制面板controlPanel，可供选择图形计算
		controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		//创建下拉列表chooseLIstanbul，并添加选项，注册 ItemEvent时间监听器
		chooseList = new JComboBox();
		chooseList.addItem("请单击下拉列表选择");
		chooseList.addItem("矩形的基本计算");
		chooseList.addItem("圆的基本计算");
		chooseList.addItem("三角形的基本计算");
		chooseList.addItem("圆柱的基本计算");
		chooseList.addItemListener(this);
		//创建带图标的按钮
		ImageIcon icon = new ImageIcon("image/MP900438781.jpg");
		JButoon imageButton = new JButoon(icon);
		//在控制面板controlPanel容器内添加下拉列表和按钮
		controlPanel.add(imageButoon,"Center");
		controlPanel.add(chooseList,"North");
		
		//在具有Cardlayout布局的面板pCenter中添加组件
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
	
	//当用户选择下拉列表的选项时，触发ItemEvent事件，自动执行该方法内的代码
	public void itemStateChanged(ItemEvent e) {
		int index =chooseList.getSelectedIndex();
		String choice=String.valueOf(index);
		mycard.show(pCenter, choice);
	}
	
	//当用户单击菜单选项时，触发ActionEvent事件，自动执行该方法内的代码
	public void actionPerformed(ActionEvent e) {
		//选择“主界面”命令，界面切换回控制面板controlPanel的状态
		if(e.getSource()==mainWindow) {
			mycard.first(pCenter);
			chooseList.setSelectedIndex(0);
		}
	//选择“退出”命令，退出程序
		else if(e.getSource()==exit) {
			System.exit(0);
		}
	}
	public static void main(String [] args) {
		new CalculatorWindow();
	} 
}
	

