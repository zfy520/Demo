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


public class CirclePanel extends AbstractPanel implements ActionListener,FocusListener{
	JButton resultButton,clearButton;
	JPanel leftPanel,rightPanel,buttonPanel;
	JTextField radiusTextField;
	JTextField lengthTextField,areaTextField,inpitTextField;
	BoxPanel bpRadius,bpLength,bpArea;
	
	//构造方法，完成对CirclePanel 对象的初始化
	public CirclePanel() {
		setLayout (new GridLayout(1,2));
		rightPanel=new KeyJPanel(this);
		leftPanel=new JPanel();
		
		//创建一个垂直排列组件的Box容器box，并创建容器内要添加的组件
		Box box=Box.createVerticalBox();
		bpRadius=new BoxPanel("请输入圆的半径：",10);
		radiusTextField=bpRadius.getJTextField();
		//radiusTextField文本框注册FocusEvent事件监听器
		radiusTextField.addFocusListener(this);
		clearButton=new JButton("清空");
		clearButton.addActionListener(this);
		buttonPanel.add(resultButton);
		buttonPanel.add(clearButton);
		bpLength=new BoxPanel("圆的周长：",20);
		lengthTextField=bpLength.getJTextField();
		bpArea=new BoxPanel("圆的面积：",20);
		areaTextField=bpArea.getJTextField();
		//Box容器依次添加四个组件
		box.add(bpRadius);
		box.add(buttonPanel);
		box.add(bpLength);
		box.add(bpArea);
		leftPanel.add(box);
		
		//CirclePanel对象依次添加组件
		add(leftPanel);
		add(rightPanel);
	}
	
	//ActionListener接口中的方法，当用户单击了按钮，就执行该方法
	public void actionPerformed(ActionEvent e) {
		//单击了“计算结果：”按钮，计算并显示圆的周长和面积
		if(e.getSource()==resultButton) {
			try {
				double radius=Double.parseDouble(radiusTextField.getText());
				lengthTextField.setText(""+2*Math.PI*radius);
				areaTextField.setText(""+Math.PI*radius*radius);
			}catch(NumberFormatException e1) {
				//若输入参数为非数字的字符，则弹出该警告的对话框
				JOptionPane.showMessageDialog(this,"请输入数字：","警告对话框",JOptionPane.WARNING_MESSAGE);
			}
		}
		//单击“清空”按钮，则清空半径文本框
		else if(e.getSource()==clearButton) {
			radiusTextField.setText(" ");
		}
	}
	
	//FocusListener接口中的方法，当事件源获得焦点时执行该方法
	public void focusGained(FocusEvent e) {
		inputTextField=(JTextField)e.getSource();
	}
	
	//FocusListener接口中的方法，当事件源失去焦点时执行该方法
	public void focusLost(FocusEvent e) {}
	
	//获取当前获得焦点的文本框对象
	public JTextField getInputTextField() {
		return inputTextField;
	}
}
