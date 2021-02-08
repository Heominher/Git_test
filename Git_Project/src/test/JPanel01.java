package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class JPanel01 extends JPanel {  // 1번째 패널
    
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JPanelTest win;
    
    public JPanel01(JPanelTest win){
        this.win = win;
        setLayout(null);
        
        jButton1 = new JButton("버튼");
        jButton1.setSize(70,20);        
        jButton1.setLocation(10, 10);
        add(jButton1);
        
        jTextArea1 = new JTextArea();

        jScrollPane1 = new JScrollPane(jTextArea1);
        jScrollPane1.setSize(200,150);
        jScrollPane1.setLocation(10,40);
        add(jScrollPane1);
        
        jButton1.addActionListener(new MyActionListener());
    }
    class MyActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("panel02");
        }
     }
}


class JPanel02 extends JPanel{        // 2번째 패널
    private JTextField textField;
    private JPasswordField passwordField;
    private JPanelTest win;
    
    public JPanel02(JPanelTest win) {
        setLayout(null);
        this.win = win;
        JLabel lblLbl = new JLabel("아이디:");
        lblLbl.setBounds(31, 40, 67, 15);
        add(lblLbl);
        
        textField = new JTextField();
        textField.setBounds(123, 40, 116, 21);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblLbl_1 = new JLabel("암호:");
        lblLbl_1.setBounds(31, 84, 67, 15);
        add(lblLbl_1);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(123, 84, 116, 21);
        add(passwordField);
        
        JButton btn = new JButton("버튼");
        btn.setSize(70,20);
        btn.setLocation(10,10);
        add(btn);
        btn.addActionListener(new MyActionListener());
    }
    class MyActionListener implements ActionListener {         // 버튼 키 눌리면 패널 1번 호출
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("panel01");
        }
    }
}


class JPanelTest extends JFrame{
    
    public JPanel01 jpanel01 = null;
    public JPanel02 jpanel02 = null;
    
    public void change(String panelName){        // 패널 1번과 2번 변경 후 재설정
        
        if(panelName.equals("panel01")){
            getContentPane().removeAll();
            getContentPane().add(jpanel01);
            revalidate();
            repaint();
        }else {
            getContentPane().removeAll();
            getContentPane().add(jpanel02);
            revalidate();
            repaint();
        }
    }
    
    public static void main(String[] args) {
        
       JPanelTest win = new JPanelTest();            
        
        win.setTitle("frame test");
        win.jpanel01 = new JPanel01(win);
        win.jpanel02 = new JPanel02(win);
        
        win.add(win.jpanel01);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(500,700);
        win.setVisible(true);    
    }
}