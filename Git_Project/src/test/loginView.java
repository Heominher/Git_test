package test;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class loginView extends JFrame implements ActionListener {
    BufferedImage img = null;
 
    public loginView() {
        setTitle("배경화면 테스트");
 
        // 배경 Panel
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(480, 640);
        layeredPane.setLayout(null);
 
        try {
            img = ImageIO.read(new File("C:\\Users\\Heomh\\Desktop\\good.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
            System.exit(0);
        }
        // 이미지 삽입
        myPanel panel = new myPanel();
        panel.setSize(480,640);
        layeredPane.add(panel);
 
        setLayout(null);
 
        add(layeredPane);
 
        setBounds(720, 220, 480, 640);
        setVisible(true);
        setResizable(false); // 창크기 수정불가
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    class myPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
    }
 
    public static void main(String[] args) {
        new loginView();
    }
 
}
