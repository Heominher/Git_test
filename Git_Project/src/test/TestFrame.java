package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame implements ActionListener {
	private static JPanel rightPanel = new JPanel(); // 오른쪽 패널
// 변할 화면, 다른 메소드에서 작업을 해 화면내용을 바꾸기 때문에 멤버공간에 선언

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(500, 300);
		frame.setPreferredSize(new Dimension(500, 300));
		Container test = frame.getContentPane();
		JPanel viewPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		test.add(viewPanel);
		viewPanel.setLayout(new BorderLayout());
		viewPanel.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // 왼쪽(고정) 패널의 레이아웃 설정
		ActionListener listener = new TestFrame(); // 한클래스에서 작업을 했기에 액션리스너를 본 클레스로
		for (int i = 1; i < 4; i++) { // 단순 버튼 만들어 액션 추가
			JButton btn = new JButton(i + "번째 패널 호출");
			leftPanel.add(btn);
			btn.addActionListener(listener);
		}
		firstRight(); // 초기화면
		viewPanel.add(rightPanel);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	static void firstRight() { // 초기 및 첫번째 패널의 화면
		rightPanel.add(new JLabel("첫번째 패널"));
	}

	static void secondRight() { // 두번째 패널의 화면
		rightPanel.add(new JLabel("두번째 패널"));
	}

	static void thirdRight() { // 세번째 패널의 화면
		rightPanel.add(new JLabel("세번째 패널"));
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 액션 리스너 설정
		String btnVal = e.getActionCommand(); // 버튼값 받기
		rightPanel.removeAll(); // 오른쪽 패널 지우기
		if (btnVal.equals("1번째 패널 호출")) {
			firstRight(); // 오른쪽 패널 화면 다시 추가
		} else if (btnVal.equals("2번째 패널 호출")) {
			secondRight();
		} else {
			thirdRight();
		}
		rightPanel.updateUI(); // 패널 화면 업데이트

//		  패널보다 상위 개념, 즉 컨테이너에서는 updateUI를 제공하지 않는다.
//		  추가 후 setVisible(b) 를 통해 껐다가, 다시 켜주는 방법으로 해야한다.
//		 ex)
//		 contentPane.removeAll();
//		 noticeWritePanel();
//		 contentPane.setVisible(false);
//		 contentPane.setVisible(true);

	}

}