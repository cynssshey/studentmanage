package StudentManager;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class add extends J10 implements ActionListener{ //增加
    JButton b3;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    add(){
        setSize(600,300);
        setTitle("增加信息");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7 = new JTextField(10);

        JLabel l1 = new JLabel("姓名：");
        JLabel l2 = new JLabel("学号：");
        JLabel l3 = new JLabel("性别：");
        JLabel l4 = new JLabel("班级：");
        JLabel l5 = new JLabel("学院：");
        JLabel l6 = new JLabel("专业：");
        JLabel l7 = new JLabel("入学日期：");

        setLayout(new GridLayout(5,2));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        p1.add(l1);p2.add(l2);p3.add(l3);p4.add(l4);p5.add(l5);p6.add(l6);p7.add(l7);
        p1.add(t1);p2.add(t2);p3.add(t3);p4.add(t4);p5.add(t5);p6.add(t6);p7.add(t7);
        add(p1);add(p2);add(p3);add(p4);add(p5);add(p6);add(p7);

        JPanel p10 = new JPanel();
        b3 = new JButton("增加");
        b3.addActionListener(this);
        p10.add(b3); add(p10);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b3) {
            String name = this.t1.getText();
            String num = this.t2.getText();
            String sex = this.t3.getText();
            String cid = this.t4.getText();
            String college = this.t5.getText();
            String major = this.t6.getText();
            String year = this.t7.getText();
            JDB x = new JDB();
            try {
                x.OpenConn();
                //String sql = "select * from student where sid="+num;
                String sql = "select * from student";
                x.rs = x.executeQuery(sql);
                //if(x.rs.next()) new J10().setTitle("添加失败！！！");
                //else new J10().setTitle("添加成功！！！");

                sql = "insert into student(sid,sname,sex,cid,college,major,inyear) values("+num+",'"+name+"','"+sex+"','"+cid+"','"+college+"','"+major+"','"+year+"')";
                System.out.println(sql);
                x.execute(sql);
            }catch(Exception e1) {
                System.err.println(e1.getMessage());
            }
            x.closeStmt();
            x.closeConn();
        }
    }
    public static void main(String []args) {
        //new add().setVisible(true);
    }
}
