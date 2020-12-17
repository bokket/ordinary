/*
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class login extends JFrame implements ActionListener
{
    JButton login = new JButton("登录");
    JButton exit = new JButton("退出");
    JLabel  name = new JLabel("用户名：");
    JLabel password = new JLabel("密码：");
    JTextField JName = new JTextField(10);
    JPasswordField JPassword = new JPasswordField(10);

    public login()
    {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,2));  //3行2列的面板jp（网格布局）

        name.setHorizontalAlignment(SwingConstants.RIGHT);  //设置该组件的对齐方式为向右对齐
        password.setHorizontalAlignment(SwingConstants.RIGHT);

        jp.add(name);   //将内容加到面板jp上
        jp.add(JName);
        jp.add(password);
        jp.add(JPassword);
        jp.add(login);
        jp.add(exit);

        login.addActionListener(this); //登录增加事件监听
        exit.addActionListener(this);	//退出增加事件监听

        this.add(jp,BorderLayout.CENTER);	//将整块面板定义在中间

        this.setTitle("登录窗口");
        this.setLocation(600,400);
        this.pack();  		//表示随着面板自动调整大小
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)  // 对时间进行处理
    {
        if(e.getSource() == exit)
        {
            int i = JOptionPane.showConfirmDialog(null,"确认要退出吗？", "确认", JOptionPane.YES_NO_OPTION);
            // 显示选择对话框
            if(i == JOptionPane.YES_OPTION);
                System.exit(0);
        }
        else
        {
            if(JName.getText().equals("admin")&& String.valueOf(JPassword.getPassword()).equals("wxz"))
            {
                JOptionPane.showMessageDialog(null, "登录成功，欢迎到来！");
                //显示信息提示框
                System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "用户或密码错误！请从新登录！");
                //显示信息提示框
                JName.setText("");
                JPassword.setText("");
            }
        }
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new login();
    }
}*/
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class login extends JFrame{
    public static void main(String[] args) {
        login frm = new login();
        frm.setSize(300, 200);
        frm.setTitle("密码验证");
        // 设置颜色，这里使用RGB三颜色
        Container c = frm.getContentPane();
        c.setBackground(new Color(200, 200, 255)); // RGB色
        frm.setLayout(null);
        // 创建“用户名： ”标签
        JLabel L1 = new JLabel("用户名: ");
        L1.setBounds(40, 50, 55, 20);
        frm.setResizable(false);
        // 创建文本框
        JTextField t1 = new JTextField(50);
        t1.setBounds(100, 50, 100, 20);
        // 创建“密码：”标签
        JLabel L2 = new JLabel("密码: ");
        L2.setBounds(40, 80, 55, 20);
        //　 创建密码文本框,设置密码文本框的回显字符为"*"
        JPasswordField t2 = new JPasswordField(50);
        t2.setEchoChar('*');
        t2.setBounds(100, 80, 100, 20);
        // 创建“确定”按钮
        JButton btn = new JButton("确定");
        // “确定”按钮获取用户名和密码
        btn.addActionListener((ActionEvent e)->{
            System.out.println(t1.getText());
            System.out.println(t2.getPassword());
        });
        btn.setBounds(40, 110, 80, 30);
        // 创建“清除”按钮
        JButton btn2 = new JButton("清除");
        // “清除”按钮可情况用户名和密码中的文本
        btn2.addActionListener((ActionEvent e)->{
            t1.setText("");
            t2.setText("");
        });
        btn2.setBounds(130, 110, 80, 30);
        // 将组件添加到frm中
        frm.add(t1);
        frm.add(L1);
        frm.add(L2);
        frm.add(t2);
        frm.add(btn);
        frm.add(btn2);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}

