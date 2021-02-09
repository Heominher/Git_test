package newclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.Joinable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

public class ChatGUIClient extends JFrame implements ActionListener, Runnable {

    // ======== GUI =========
    JTextField tf; // 전송할 텍스트 입력창
    JTextArea ta; // 전송받은 텍스트 출력
    JTextArea ta1; // 전송받은 텍스트 출력(내꺼)

    JScrollPane js; // 스크롤바 생성

    // ======== Socket =======
    Socket s; // 서버와의 통신을 위함

    // ======== Stream =======
    BufferedReader br; // 클라이언트에서의 문자열 입력 스트림
    PrintWriter pw; // 문자열 출력 스트림

    // 서버로 전송할 문자열과 서버에서 받아올 문자열 변수
    String str, str1;
    static String nick;  //참가할 이름

    // ======== 생성자 ========
    public ChatGUIClient(String Nm) {
        // 창, 부착할 컴포넌트 생성 및 연결
        tf = new JTextField();
        ta = new JTextArea(7,30);
        ta.setLineWrap(true);
        ta.setLayout(new BoxLayout(ta, BoxLayout.Y_AXIS));
        ta1 = new JTextArea(7,10);
        ta1.setLineWrap(true);
        ta1.setEditable(false);   //수정 금지
        ta.setEditable(false);	 //수정 금지

        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
        top.setOpaque(true);
        top.setBackground(Color.pink);
        
        
        JButton btn2 = new JButton("퇴장");
        btn2.setOpaque(true);
        btn2.setBackground(Color.black);
        btn2.setFont(new Font("고딕", Font.BOLD, 20));
        btn2.setForeground(Color.white);
        
        JLabel nicklable = new JLabel();
        nicklable.setOpaque(true);
        nicklable.setBackground(Color.pink);
        nicklable.setFont(new Font("고딕", Font.BOLD, 20));
        nicklable.setForeground(Color.white);
        
        top.add(btn2);
        top.add(nicklable, BorderLayout.EAST);
        
        JPanel pan1 = new JPanel();
        pan1.setLayout(new BoxLayout(pan1, BoxLayout.X_AXIS));
        ta.setOpaque(true);
        ta.setFont(new Font("고딕",Font.BOLD,15));
        ta1.setFont(new Font("고딕",Font.BOLD,13));
        ta1.setForeground(Color.black);
        ta.setForeground(Color.white);
        ta1.setOpaque(true);
        ta.setBackground(Color.black);
        ta1.setBackground(Color.yellow);
        
        // 텍스트 출력창에 스크롤 바 연결
        js = new JScrollPane(ta);
        
        pan1.add(js);
        pan1.add(ta1);
        
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.add(tf);
        JButton sendbtn = new JButton("전송");
        sendbtn.setBackground(Color.white);
        sendbtn.setForeground(Color.black);
        bottom.add(sendbtn);


        add(top,BorderLayout.NORTH);
        // BorderLayout 배치관리자, JTextArea를 정중앙에 부착
        add(pan1, BorderLayout.CENTER);

        // 텍스트 필드를 하단에 부착
        add(bottom, BorderLayout.SOUTH);

        // 텍스트 필드에서 이벤트(enter)를 입력받고 해당 객체에서 이벤트 처리
        tf.addActionListener(this);

        // 창 크기 지정
        setBounds(200, 200, 500, 500);

        // 창이 보이도록 설정
        setResizable(false); // 창크기 수정불가
        setVisible(true);

        // 텍스트 필드에 커서 입력
        tf.requestFocus();

        // X버튼 클릭시 정상 종료되도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // 클라이언트 측 소켓 정보 초기화
            // Socket(host, port), host: 접속 서버 IP 주소, port: 서버 포트 번호
	        	System.out.println(nick+"가 커넥션을 맺음");
	        	nicklable.setText("이용자 : "+nick);
	        	
	        	s = new Socket("128.1.1.27", 8888);
	        	System.out.println("s>>>" + s);
	        	
	        	// ========== Server와 Stream 연결 ===========
	        	br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        	
	        	
	        	// PrintWriter 스트림의 autoFlush 기능 활성화
	        	pw = new PrintWriter(s.getOutputStream(), true);
	        	pw.println(nick);
	        	System.out.println("닉네임을 보냄!!!!");
	        	
	        	
	        	btn2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
	        	
	        	sendbtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 내가 쓴 메세지를 str 변수에 저장
				    	str = tf.getText();
				    	if(str==""||str==null||str.equals("")){
				    		System.out.println("Enter침");
				    	}else{
				    		// 변수에 저장 후 텍스트필드 초기화
				    		tf.setText("");
				    		// 내가 쓴 메세지 출력 -> 상대방은 br.readLine()으로 읽어들임
				    		pw.println(str);
				    		pw.flush();
				    	}
					}
				});
	        
        	

        } catch (Exception e) {
            System.out.println("접속 오류>>>" + e);
            ta.append("접속 오류>>>" + e);
            ta.append("\n서버가 꺼져 있습니다.");
        }

        // Thread 객체 생성, Runnable 인터페이스를 구현하기 때문에 this 작성
        Thread ct = new Thread(this);

        // 클라이언트 스레드 실행 → run() 호출
        ct.start();
    }

    // Runnable 인터페이스 run() 메소드 오버라이딩
    public void run() {
    	String[] joinlist = null;
    	JList list;
    	list = new JList(joinlist);
    	String join = "";
        // 더 이상 입력을 받을 수 없을 때까지 JTextArea(채팅창)에 출력
        try {
        	
            while ((str1 = br.readLine()) != null) {
            		
	        	if(str1.indexOf("member")!=-1){   //접속자 출력구문
	        		ta1.setText("");
	        		ta1.append("==================접속 유저 리스트=================\n");
	        		join = str1.substring(7).replace("[", "");
	        		join = join.replace("]", "");
	        		join = join.replace(" ","");
	        		joinlist = join.split(",");
	        		list = new JList(joinlist);
        			for(int i = 0 ;i < joinlist.length ; i++)
        			{
        				ta1.append((i+1)+". "+joinlist[i]+"님\n");
        			}
        			
            	}else if(str1.indexOf(nick)!=-1){
//            	}else if(str1.equals(nick)==true){
        		   ta.append("나 ====> "+str+"\n");
        		   ta.setCaretPosition(ta.getDocument().getLength());
            	}else{
        		    ta.append(str1 + "\n"); // 상대방이 보낸 문자를 채팅창에 세로로 출력
        		    ta.setCaretPosition(ta.getDocument().getLength());
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // ActionListener 메소드 오버라이딩, 입력란에서 enter입력시 실행할 코드
    public void actionPerformed(ActionEvent e) {
    	
    	// 내가 쓴 메세지를 str 변수에 저장
    	str = tf.getText();
    	if(str==""||str==null||str.equals("")){
    		System.out.println("Enter침");
    	}else{
    		// 변수에 저장 후 텍스트필드 초기화
    		tf.setText("");
    		// 내가 쓴 메세지 출력 -> 상대방은 br.readLine()으로 읽어들임
    		pw.println(str);
    		pw.flush();
    	}
    }
    
    static JFrame frame = new JFrame("Client");
    public static void join(){    //채팅 입장전 입장 이름 받는 프레임
    	
    	
    	Dimension dim = new Dimension(300,200);
		
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		JPanel top = new JPanel();
		top.setOpaque(true);
		top.setBackground(Color.black);
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		pan.setOpaque(true);
		pan.setBackground(Color.black);
		
		JLabel label = new JLabel("사용할 닉네임을 작성하세요");
		label.setForeground(Color.white);
		label.setFont(new Font("고딕",Font.BOLD,20));
		
		top.add(label);
		
		JTextField namefied = new JTextField();
		namefied.setOpaque(true);
		namefied.setBackground(Color.black);
		namefied.setForeground(Color.white);
		namefied.setFont(new Font("고딕",Font.BOLD,35));
		
		
		JButton submit = new JButton("입장");
		submit.setFont(new Font("고딕",Font.BOLD,20));
		submit.setForeground(Color.pink);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setHorizontalAlignment(SwingConstants.CENTER);
		
		pan.add(namefied);
		
		frame.add(top,BorderLayout.NORTH);
		frame.add(pan,BorderLayout.CENTER);
		frame.add(submit,BorderLayout.SOUTH);
		
		frame.setResizable(false); // 창크기 수정불가
		frame.pack();
		frame.setVisible(true);
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nick = namefied.getText();
				System.out.println("이름을 넘겨줌");
				System.out.println("서브@@@@@@@@@@@@@@@@@@@@이름 이름 : "+nick);
				frame.setVisible(false);
				frame.dispose();
				new ChatGUIClient(nick);
			}
		});
		
    }

    public static void main(String[] args) {
    	join();
    }

}
