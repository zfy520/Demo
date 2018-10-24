package caida.xinxi.shapeCalculate;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TrianglePanel extends AbstractPanel implements ActionListener,FocusListener{
	JButton resultButton,clearButton;
	JPanel leftPanel,rightButton,ButtonPanle;
	JTextField sideATextField,sideBTextField,sideCTextField;
	JTextField lengthTextField,areaTextField,inputTextField;
	BoxPanel bpSideA,bpSideB,bpSideC,bpLength,bpArea;
	
	//构造方法，负责对三角形面板的初始化
	public TriangPanel() {
		setLayout(new GridLayout(1,2));
		rightPanel=new KeyJPanel(this);
		leftPanel=new JPanel();
		
		//创建一个垂直排列组件的Box容器box，并创建需要添加的组件
		Box box=Box.createVerticalBox();
		bpSideA=new BoxPanel("请输入三角形的边A：",10);
		sideATextField=bpSideA.getJTextField();
		//sideATextField文本框注册FocusEvent事件监听器
		sideATextField.addFocusListener(this);
		bpSideB=new BoxPanel("请输入三角形的边B：",10);
		sideBTextField=bpSideB.getJTextField();
		sideBTextField.addFocusListener(this);
		bpSideC=new BoxPanel("请输入三角形的边C：",10);
		sideCTextField=bpSideC.getJTextField();
		sideCTextField.addFocusListener(this);
		buttonPanel=new JPanel();
		resultButton=new JButton("计算结果");
		//resultButton按钮注册ActionEvent事件监听器
		resultButton.addActionListener(this);
		clearButton=new JButton("清空");
		
	}
}
