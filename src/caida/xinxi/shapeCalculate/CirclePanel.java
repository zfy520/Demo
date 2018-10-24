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
	
	//���췽������ɶ�CirclePanel ����ĳ�ʼ��
	public CirclePanel() {
		setLayout (new GridLayout(1,2));
		rightPanel=new KeyJPanel(this);
		leftPanel=new JPanel();
		
		//����һ����ֱ���������Box����box��������������Ҫ��ӵ����
		Box box=Box.createVerticalBox();
		bpRadius=new BoxPanel("������Բ�İ뾶��",10);
		radiusTextField=bpRadius.getJTextField();
		//radiusTextField�ı���ע��FocusEvent�¼�������
		radiusTextField.addFocusListener(this);
		clearButton=new JButton("���");
		clearButton.addActionListener(this);
		buttonPanel.add(resultButton);
		buttonPanel.add(clearButton);
		bpLength=new BoxPanel("Բ���ܳ���",20);
		lengthTextField=bpLength.getJTextField();
		bpArea=new BoxPanel("Բ�������",20);
		areaTextField=bpArea.getJTextField();
		//Box������������ĸ����
		box.add(bpRadius);
		box.add(buttonPanel);
		box.add(bpLength);
		box.add(bpArea);
		leftPanel.add(box);
		
		//CirclePanel��������������
		add(leftPanel);
		add(rightPanel);
	}
	
	//ActionListener�ӿ��еķ��������û������˰�ť����ִ�и÷���
	public void actionPerformed(ActionEvent e) {
		//�����ˡ�������������ť�����㲢��ʾԲ���ܳ������
		if(e.getSource()==resultButton) {
			try {
				double radius=Double.parseDouble(radiusTextField.getText());
				lengthTextField.setText(""+2*Math.PI*radius);
				areaTextField.setText(""+Math.PI*radius*radius);
			}catch(NumberFormatException e1) {
				//���������Ϊ�����ֵ��ַ����򵯳��þ���ĶԻ���
				JOptionPane.showMessageDialog(this,"���������֣�","����Ի���",JOptionPane.WARNING_MESSAGE);
			}
		}
		//��������ա���ť������հ뾶�ı���
		else if(e.getSource()==clearButton) {
			radiusTextField.setText(" ");
		}
	}
	
	//FocusListener�ӿ��еķ��������¼�Դ��ý���ʱִ�и÷���
	public void focusGained(FocusEvent e) {
		inputTextField=(JTextField)e.getSource();
	}
	
	//FocusListener�ӿ��еķ��������¼�Դʧȥ����ʱִ�и÷���
	public void focusLost(FocusEvent e) {}
	
	//��ȡ��ǰ��ý�����ı������
	public JTextField getInputTextField() {
		return inputTextField;
	}
}
