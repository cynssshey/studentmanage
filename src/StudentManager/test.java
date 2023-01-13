package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class J10 extends JFrame{
    J10(){
        setTitle("登陆界面");
        setSize(400,150);
        setVisible(true);
    }
}

class J11 extends J10{
    JTextField t1;
    JPasswordField pass;
    J11(){
        t1 = new JTextField(12);//文本框
        pass = new JPasswordField(12);//密码框
        JLabel l1 = new JLabel("账号："); JLabel l2 = new JLabel("密码："); //标签对象
        setLayout(new GridLayout(2,1)); //网格布局管理器
        JPanel p1 = new JPanel(); JPanel p2 = new JPanel();
        p1.add(l1); p2.add(l2);
        p1.add(t1); p2.add(pass);
        add(p1); add(p2);
    }
}

class J12 extends J11 implements ActionListener{
    JButton b1;
    Object obj;
    J12(){
        setLayout(new GridLayout(3,1));
        JPanel p3 = new JPanel();
        b1 = new JButton("登录");
        b1.addActionListener(this);
        p3.add(b1);
        add(p3);
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b1){
            String name = this.t1.getText();
            String password = this.pass.getText();
            boolean t = false;
            try {
                JDB x = new JDB();
                x.OpenConn();
                t = x.login(name, password);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if(t == true)
            {
                System.out.println("登陆成功！");
                new J31().setVisible(true);
            }
            else {
                System.out.println("登陆失败！");
                new J10().setTitle("登录失败！！！");
            }
        }
    }
}

class J31 extends J10 implements ActionListener{
    JMenuBar mainMenu = new JMenuBar(); //创建菜单栏
    JMenu menuSystem = new JMenu("系统管理");
    JMenuItem itemOpen = new JMenuItem("打开");
    JMenuItem itemExit = new JMenuItem("退出");

    JMenu menuStu = new JMenu("学生管理");
    JMenuItem itemAdds = new JMenuItem("增加");
    JMenuItem itemEdits = new JMenuItem("修改");
    JMenuItem itemDeletes = new JMenuItem("删除");
    JMenuItem itemSearch = new JMenuItem("查询");

    Font t = new Font("Dialog",0,12);

    J31(){
        itemAdds.addActionListener(this);
        itemEdits.addActionListener(this);
        itemDeletes.addActionListener(this);
        itemSearch.addActionListener(this);
        itemExit.addActionListener(this);
        this.pack();
        setTitle("学生管理系统"); setSize(400,300);
        menuSystem.setFont(t);
        menuSystem.add(itemOpen); menuSystem.add(itemExit);

        menuStu.add(itemAdds); menuStu.add(itemEdits); menuStu.add(itemDeletes); menuStu.add(itemSearch);

        mainMenu.add(menuSystem); mainMenu.add(menuStu);
        this.setJMenuBar(mainMenu);
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == itemAdds) {
            new add().setVisible(true);
        }
        else if(obj == itemEdits) {
            new update().setVisible(true);
        }
        else if(obj == itemDeletes) {
            new delete().setVisible(true);
        }
        else if(obj == itemSearch) {
            new query().setVisible(true);
        }
        else if(obj == itemExit) {
            this.dispose();
        }
    }
}

public class test{
    public static void main(String []args) {
        J12 x = new J12();
        x.setVisible(true);
        x.setResizable(false);
        x.setLocationRelativeTo(null); //居中
    }
}
