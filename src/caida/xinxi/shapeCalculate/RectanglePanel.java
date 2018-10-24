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
	
	//���췽������ʼ�����μ���������
	public RectanglePanel() {
		setLayout(new GridLayout(1,2));
		rightPanel=new KeyJPanel(this);
		leftPanel=new JPanel();
		
		//����һ����ֱ���������Box����box��������box�����ڵĸ������
		Box box=Box.createVerticalBox();
		bpWidth=new BoxPanel("��������εĿ�",10);
		widthTextField=bpWidth.getJTextField();
		//�ı���widthTextFieldע��FocusEvent�¼�������
		widthTextField.addFocusListener(this);
		bpHeight=new BoxPanel("��������εĸߣ�",10);
		heightTextField=bpHeight.getJTextField();
		heightTextField.addFocusListener(this);
		buttonPanel=new JPanel();
		resultButton=new JButton("��������");
		//��ťע��ActionEvent�¼�������
		resultButton.addActionListener(this);
		clearButton=new JButton("���");
		clearButton.addActionListener(this);
		buttonPanel.add(resultButton);
		buttonPanel.add(clearButton);
		bpLength=new BoxPanel("���ε��ܳ���",20);
		lengthTextField=bpLength.getJTextField();
		bpArea=new BoxPanel("���ε������",20);
		this.areaTextField=this.bpArea.getJTextField();
		
		//box �����������������
		box.add(bpWidth);
		box.add(bpHeight);
		box.add(buttonPanel);
		box.add(bpLength);
		box.add(bpArea);
		leftPanel.add(box);
		//RectanglePanel���������
		add(leftPanel);
		add(rightPanel);
	}
	
	//���û�������ťʱ������ActionEvent�¼����Զ�ִ�и÷����ڴ���
	public void actionPerformed (ActionEvent e) {
		//������������������ť���������ε��ܳ������
		if(e.getSource()==resultButton) {
			try {
				double width=Double.parseDouble(widthTextField.getText());
				double height=Double.parseDouble(heightTextField.getText());
				lengthTextField.setText(""+2*(width+height));
				areaTextField.setText(""+width*height);
				}catch (NumberFormatException e1) {
					//������¼��������ַ���������Ϣ�Ի��򾯸�
					JOptionPane.showMessageDialog(this,"���������֣�","����Ի���",JOptionPane.WARNING_MESSAGE);
				}
		}
		//��������ա���ť������ղ����ı����е�����
		else if(e.getSource()==clearButton) {
			widthTextField.setText(" ");
			heightTextField.setText(" ");
		}
	}
	//FocusListener �ӿ��еķ���������ý���ʱ���ø÷���
	public void focusGained(FocusEvent e) {
		inputTextField=(JTextField)e.getSource();
	}
	//FocusListener �ӿ��еĵķ�������ʧȥ����ʱ���ø÷���
	public void focusLost(FocusEvent e) {}
	
	//�õ���ǰ��ý�����ı������
	public JTextField getInputTextField() {
		return inputTextField;
	}
}
