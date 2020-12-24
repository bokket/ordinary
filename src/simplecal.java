import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class simplecal extends JFrame {
    ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");

    public static void main(String[] args) {
        new simplecal();
    }


    public simplecal() {
        init();
        button_add();
        display();
    }

    private void init() {
        setBounds(300, 300, 500, 700);
        getContentPane().setLayout(null);
        setTitle("P&p calculator v5.0");
    }

    private void button_add() {
        JLabel jisuan = new JLabel("计算式");
        jisuan.setFont(new Font("华文楷体", Font.CENTER_BASELINE, 25));
        jisuan.setBounds(0, 0, 100, 80);
        getContentPane().add(jisuan);
        JTextField jisuan_text = new JTextField();
        jisuan_text.setBounds(100, 15, 360, 50);
        jisuan_text.setHorizontalAlignment(JTextField.LEFT);
        jisuan_text.setFont(new Font("华文楷体", Font.PLAIN, 20));
        getContentPane().add(jisuan_text);

        JLabel answer = new JLabel("结     果");
        answer.setFont(new Font("华文楷体", Font.CENTER_BASELINE, 25));
        answer.setBounds(0, 55, 100, 80);
        getContentPane().add(answer);
        JTextField answer_text = new JTextField();
        answer_text.setBounds(100, 70, 360, 50);
        answer_text.setHorizontalAlignment(JTextField.LEFT);
        answer_text.setFont(new Font("华文楷体", Font.PLAIN, 20));
        getContentPane().add(answer_text);
        final JButton celan = new JButton();
        celan.addActionListener(e -> jisuan_text.setText(jisuan_text.getText().length() != 0
                ? jisuan_text.getText().substring(0, jisuan_text.getText().length() - 1) : ""));
        celan.setFont(new Font("华文楷体", Font.PLAIN, 42));
        celan.setText("退  格");
        celan.setBounds(50, 150, 180, 80);
        getContentPane().add(celan);
        final JButton celan_all = new JButton();
        celan_all.addActionListener(e -> jisuan_text.setText(""));
        celan_all.setFont(new Font("华文楷体", Font.PLAIN, 42));
        celan_all.setText("清  除");
        celan_all.setBounds(250, 150, 180, 80);
        getContentPane().add(celan_all);
        final JButton num_1 = new JButton();
        num_1.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 1));
        num_1.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_1.setText("1");
        num_1.setBounds(50, 250, 80, 80);
        getContentPane().add(num_1);
        final JButton num_2 = new JButton();
        num_2.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 2));
        num_2.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_2.setText("2");
        num_2.setBounds(150, 250, 80, 80);
        getContentPane().add(num_2);
        final JButton num_3 = new JButton();
        num_3.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 3));
        num_3.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_3.setText("3");
        num_3.setBounds(250, 250, 80, 80);
        getContentPane().add(num_3);
        final JButton clc_add = new JButton();
        clc_add.addActionListener(e -> jisuan_text.setText(m1(jisuan_text, "+")));
        clc_add.setFont(new Font("华文楷体", Font.PLAIN, 42));
        clc_add.setText("+");
        clc_add.setBounds(350, 250, 80, 80);
        getContentPane().add(clc_add);
        final JButton num_4 = new JButton();
        num_4.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 4));
        num_4.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_4.setText("4");
        num_4.setBounds(50, 350, 80, 80);
        getContentPane().add(num_4);
        final JButton num_5 = new JButton();
        num_5.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 5));
        num_5.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_5.setText("5");
        num_5.setBounds(150, 350, 80, 80);
        getContentPane().add(num_5);
        final JButton num_6 = new JButton();
        num_6.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 6));
        num_6.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_6.setText("6");
        num_6.setBounds(250, 350, 80, 80);
        getContentPane().add(num_6);
        final JButton clc_sub = new JButton();
        clc_sub.addActionListener(e -> jisuan_text.setText(m1(jisuan_text, "-")));
        clc_sub.setFont(new Font("华文楷体", Font.PLAIN, 42));
        clc_sub.setText("-");
        clc_sub.setBounds(350, 350, 80, 80);
        getContentPane().add(clc_sub);
        final JButton num_7 = new JButton();
        num_7.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 7));
        num_7.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_7.setText("7");
        num_7.setBounds(50, 450, 80, 80);
        getContentPane().add(num_7);
        final JButton num_8 = new JButton();
        num_8.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 8));
        num_8.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_8.setText("8");
        num_8.setBounds(150, 450, 80, 80);
        getContentPane().add(num_8);
        final JButton num_9 = new JButton();
        num_9.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 9));
        num_9.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_9.setText("9");
        num_9.setBounds(250, 450, 80, 80);
        getContentPane().add(num_9);
        final JButton clc_mun = new JButton();
        clc_mun.addActionListener(e -> jisuan_text.setText(m1(jisuan_text, "*")));
        clc_mun.setFont(new Font("华文楷体", Font.PLAIN, 42));
        clc_mun.setText("*");
        clc_mun.setBounds(350, 450, 80, 80);
        getContentPane().add(clc_mun);
        final JButton num_point = new JButton();
        num_point.addActionListener(e -> jisuan_text.setText(m1(jisuan_text, ".")));
        num_point.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_point.setText(".");
        num_point.setBounds(50, 550, 80, 80);
        getContentPane().add(num_point);
        final JButton num_0 = new JButton();
        num_0.addActionListener(e -> jisuan_text.setText(jisuan_text.getText() + 0));
        num_0.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_0.setText("0");
        num_0.setBounds(150, 550, 80, 80);
        getContentPane().add(num_0);
        final JButton num_equ = new JButton();
        num_equ.addActionListener(e -> answer_text.setText(clc(this.se, jisuan_text.getText())));
        num_equ.setFont(new Font("华文楷体", Font.PLAIN, 42));
        num_equ.setText("=");
        num_equ.setBounds(250, 550, 80, 80);
        getContentPane().add(num_equ);
        final JButton clc_div = new JButton();
        clc_div.addActionListener(e -> jisuan_text.setText(m1(jisuan_text, "/")));
        clc_div.setFont(new Font("华文楷体", Font.PLAIN, 42));
        clc_div.setText("/");
        clc_div.setBounds(350, 550, 80, 80);
        getContentPane().add(clc_div);

    }

    private String clc(ScriptEngine se2, String text) {
        Object obj = null;
        try {
            obj = se.eval(text);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }

    private String m1(JTextField jisuan_text, String string) {
        String Str = jisuan_text.getText() + ((jisuan_text.getText().endsWith("+")
                || (jisuan_text.getText().endsWith("-")) || (jisuan_text.getText().endsWith("*"))
                || (jisuan_text.getText().endsWith("/")) || (jisuan_text.getText().endsWith("."))) ? "" : string);
        return Str;

    }
    private void display() {
        setVisible(1 < 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}