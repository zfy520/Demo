package caida.xinxi.shapeCalculate;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoxPanel extends JPanel{
	JTextField text;
	
	//���췽������ʼ�����
	public BoxPanel(String s,int n) {
		//����ˮƽ���������Box�����Ķ���box
		Box box=Box.createHorizontalBox();
		box.add(new JLabel(s));
		text=new JTextField("",n);
		//�����ı����ı��Ҷ���
		text.setHorizontalAlignment(JTextField.RIGHT);
		//�����ı������ı��������ʽ
		text.setFont(new Font("Arial",Font.BOLD,15));
		box.add(text);
		add(box);
	}
	
	//��ȡ��ǰ�����ڵ��ı������
	public JTextField getJTextField() {
		return text;
	}
}