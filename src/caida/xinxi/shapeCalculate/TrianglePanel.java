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
	
	//���췽������������������ĳ�ʼ��
	public TriangPanel() {
		setLayout(new GridLayout(1,2));
		rightPanel=new KeyJPanel(this);
		leftPanel=new JPanel();
		
		//����һ����ֱ���������Box����box����������Ҫ��ӵ����
		Box box=Box.createVerticalBox();
		bpSideA=new BoxPanel("�����������εı�A��",10);
		sideATextField=bpSideA.getJTextField();
		//sideATextField�ı���ע��FocusEvent�¼�������
		sideATextField.addFocusListener(this);
		bpSideB=new BoxPanel("�����������εı�B��",10);
		sideBTextField=bpSideB.getJTextField();
		sideBTextField.addFocusListener(this);
		bpSideC=new BoxPanel("�����������εı�C��",10);
		sideCTextField=bpSideC.getJTextField();
		sideCTextField.addFocusListener(this);
		buttonPanel=new JPanel();
		resultButton=new JButton("������");
		//resultButton��ťע��ActionEvent�¼�������
		resultButton.addActionListener(this);
		clearButton=new JButton("���");
		
	}
}
