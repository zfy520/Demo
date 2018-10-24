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


public class RectanglePanel extends AbstractPanel implements ActionListener,FocusListener {
	JButton resultButton,clearButton;
	JPanel leftPanel,rightPanel,buttonPanel;
	JTextField widthTextField,heightTextField;
	JTextField lengthTextField,areaTextField,inputTextField;
	BoxPanel bpWidth,bpHeight,bpLength,bpArea;
	
	//构造方法，初始化矩形计算器界面
	public RectanglePanel() {
		setLayout(new GridLayout(1,2));
		rightPanel=new KeyJPanel(this);
		leftPanel=new JPanel();
		
		//创建一个垂直排列组件的Box容器box，并创建box容器内的各个组件
		Box box=Box.createVerticalBox();
		bpWidth=new BoxPanel("请输入矩形的宽：",10);
		widthTextField=bpWidth.getJTextField();
		//文本框widthTextField注册FocusEvent事件监听器
		widthTextField.addFocusListener(this);
		bpHeight=new BoxPanel("请输入矩形的高：",10);
		heightTextField=bpHeight.getJTextField();
		heightTextField.addFocusListener(this);
		buttonPanel=new JPanel();
		resultButton=new JButton("计算结果：");
		//按钮注册ActionEvent事件监听器
		resultButton.addActionListener(this);
		clearButton=new JButton("清空");
		clearButton.addActionListener(this);
		buttonPanel.add(resultButton);
		buttonPanel.add(clearButton);
		bpLength=new BoxPanel("矩形的周长：",20);
		lengthTextField=bpLength.getJTextField();
		bpArea=new BoxPanel("矩形的面积：",20);
		this.areaTextField=this.bpArea.getJTextField();
		
		//box 容器依次添加五个面板
		box.add(bpWidth);
		box.add(bpHeight);
		box.add(buttonPanel);
		box.add(bpLength);
		box.add(bpArea);
		leftPanel.add(box);
		//RectanglePanel面板添加组件
		add(leftPanel);
		add(rightPanel);
	}
	
	//当用户单击按钮时，触发ActionEvent事件，自动执行该方法内代码
	public void actionPerformed (ActionEvent e) {
		//单击“计算结果：”按钮，则计算矩形的周长和面积
		if(e.getSource()==resultButton) {
			try {
				double width=Double.parseDouble(widthTextField.getText());
				double height=Double.parseDouble(heightTextField.getText());
				lengthTextField.setText(""+2*(width+height));
				areaTextField.setText(""+width*height);
				}catch (NumberFormatException e1) {
					//若参数录入非数字字符，弹出消息对话框警告
					JOptionPane.showMessageDialog(this,"请输入数字：","警告对话框",JOptionPane.WARNING_MESSAGE);
				}
		}
		//单击“清空”按钮，则清空参数文本框中的内容
		else if(e.getSource()==clearButton) {
			widthTextField.setText(" ");
			heightTextField.setText(" ");
		}
	}
	//FocusListener 接口中的方法，当获得焦点时调用该方法
	public void focusGained(FocusEvent e) {
		inputTextField=(JTextField)e.getSource();
	}
	//FocusListener 接口中的的方法，当失去焦点时调用该方法
	public void focusLost(FocusEvent e) {}
	
	//得到当前获得焦点的文本框对象
	public JTextField getInputTextField() {
		return inputTextField;
	}
}
