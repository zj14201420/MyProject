import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.math.*;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;

/*计算器的建立，需要swing里面的对象JFrame类以及JPanel类
 * JFrame只能有一个，而JPanel可以有多个，对于按钮的控件，可以建立多个JPanel,将他附加到JFrame上
 */
public class Caculate {
	//-----初始化定义按键
	static JFrame frame = new JFrame("计算器");
	static JTextField textField = new JTextField();
	static JButton button0 = new JButton("0");
	static JButton button1 = new JButton("1");
	static JButton button2 = new JButton("2");
	static JButton button3 = new JButton("3");
	static JButton button4 = new JButton("4");
	static JButton button5 = new JButton("5");
	static JButton button6 = new JButton("6");
	static JButton button7 = new JButton("7");
	static JButton button8 = new JButton("8");
	static JButton button9 = new JButton("9");
	static JButton button_add = new JButton("+");
	static JButton button_jian = new JButton("-");
	static JButton button_cheng = new JButton("*");
	static JButton button_chu = new JButton("/");
	static JButton button_quyu = new JButton("%");
	static JButton button_dengyu = new JButton("=");
	static JButton button_xiaoshudian = new JButton(".");
	static JButton button_qingchu = new JButton("del");
	static JButton button_ce = new JButton("ce");
	public static void main(String[] args) {
		// -----------------------建立画面--------------------------
		frame.setSize(400, 300);
		frame.setLocation(200, 200);
		frame.setLayout(null);
		button0.setBounds(85, 195, 60, 40);
		button1.setBounds(20, 60, 60, 40);
		button2.setBounds(85, 60, 60, 40);
		button3.setBounds(150, 60, 60, 40);
		button4.setBounds(20, 105, 60, 40);
		button5.setBounds(85, 105, 60, 40);
		button6.setBounds(150, 105, 60, 40);
		button7.setBounds(20, 150, 60, 40);
		button8.setBounds(85, 150, 60, 40);
		button9.setBounds(150, 150, 60, 40);
		button_quyu.setBounds(20, 195, 60, 40);
		button_dengyu.setBounds(150, 195, 60, 40);
		button_add.setBounds(215, 60, 60, 40);
		button_jian.setBounds(215, 105, 60, 40);
		button_cheng.setBounds(215, 150, 60, 40);
		button_chu.setBounds(215, 195, 60, 40);
		button_xiaoshudian.setBounds(280, 60, 60, 40);
		button_qingchu.setBounds(280, 105, 60, 40);
		button_ce.setBounds(280, 150, 60, 85);
		textField.setBounds(20, 10, 300, 32);
		/*-----将按钮附加到frame----*/
		frame.add(button_quyu);
		frame.add(button0);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		frame.add(button_dengyu);
		frame.add(button_add);
		frame.add(button_jian);
		frame.add(button_cheng);
		frame.add(button_chu);
		frame.add(button_xiaoshudian);
		frame.add(button_qingchu);
		frame.add(button_ce);
		frame.add(textField);
		/*----按键监听-----*/
		jianshiqi ac = new jianshiqi();
		button0.addActionListener(ac);
		button1.addActionListener(ac);
		button2.addActionListener(ac);
		button3.addActionListener(ac);
		button4.addActionListener(ac);
		button5.addActionListener(ac);
		button6.addActionListener(ac);
		button7.addActionListener(ac);
		button8.addActionListener(ac);
		button9.addActionListener(ac);
		button_add.addActionListener(ac);
		button_jian.addActionListener(ac);
		button_cheng.addActionListener(ac);
		button_chu.addActionListener(ac);
		button_dengyu.addActionListener(ac);
		button_quyu.addActionListener(ac);
		button_xiaoshudian.addActionListener(ac);
		button_ce.addActionListener(ac );
		button_qingchu.addActionListener(ac);
		button0.setActionCommand("0");
		button1.setActionCommand("1");
		button2.setActionCommand("2");
		button3.setActionCommand("3");
		button4.setActionCommand("4");
		button5.setActionCommand("5");
		button6.setActionCommand("6");
		button7.setActionCommand("7");
		button8.setActionCommand("8");
		button9.setActionCommand("9");
		button_add.setActionCommand("+");
		button_jian.setActionCommand("-");
		button_cheng.setActionCommand("*");
		button_chu.setActionCommand("/");
		button_quyu.setActionCommand("%");
		button_xiaoshudian.setActionCommand(".");
		button_qingchu.setActionCommand("del");
		ac.jianshi(textField);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	/* 事件监听和事件响应 */
}
class jianshiqi implements ActionListener {
	JTextField text;
	jisuan js = new jisuan();
	public void jianshi(JTextField text) {
		this.text = text;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String re = e.getActionCommand();
		if (re.equals("ce")) {
			text.setText("");
			return;
		}
		if (re.equals("del")) {
			try {
				String dd = text.getText();
				dd = dd.substring(0, dd.length() - 1);
				text.setText(dd);
				return;
			} catch (Exception x) {
				return;
			}
		}
		//-----等于运算------//
		if (re.equals("=")) {
			String dy = text.getText();
			dy = js.number(dy);
			text.setText(dy);
			return;
		}
		String num = text.getText();
		num += re;
		text.setText(num);
	}
}
