package abc;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


/**
 * �ɻ��������ڵĳ�ʼ��
 * @author ��ѻ
 *
 */


public class Frame extends JFrame{
	
	
	
	
	
	Image planeimg = Photoinput.getImage("images/plane.png");                                                       //����Photoinput�����ർ����Ƭ
	Image backgroundimg = Photoinput.getImage("images/background.jpg");
	Image javaimg = Photoinput.getImage("images/Java.jpg");
	
	Java java;                                  //��ը����ʾ����Ƭ
	
	Date startTime = new Date();              //���ÿ�ʼʱ��
	Date endTime;                            //���ý���ʱ��
	int period;                               //�������ʱ��
	
	Plane plane = new Plane(planeimg,350,350);
	Background background = new Background(backgroundimg,0,0);
	
	Shell []shells = new Shell[50];           //����50��Shell��������������棬������ֻ�����Ժͷ��������Գ�ʼ�����ܷ�������
	
	
	public void paint(Graphics g)/*g�൱�ڻ���*/ {        /*�Զ�������*/                                               //�������������ϻ�����
		

		
		plane.drawSelf(g);                                //����������ͼ
		background.drawSelf(g);                              //�������ɻ�
		
		for(int i=0;i<shells.length;i++) {                       //ÿ��һ��Բ�����һ���Ƿ�ͷɻ���ײ
			shells[i].drawSelf(g);
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				
				plane.live =false; 
				if(java==null) {                                //��ըһ��
					java = new Java(javaimg,0,0);
					endTime = new Date();
					period=(int)((endTime.getTime()-startTime.getTime())/1000);
				}
				
				
			}
			
			if(!plane.live) {                                  //��ը��Ĳ��� 
				java.drawSelf(g);
				
				Font f =new Font("����",Font.BOLD,50);
				g.setFont(f);
				g.setColor(Color.red);
				g.drawString("ʱ�䣺"+period+"��", (int)plane.x, (int)plane.y);
				
			}
			
			
		}
		
		
	}
	
	
	
	class PaintThread extends Thread {                                                                            //���������ػ����ڵ��ڲ���
		@Override
		public void run() {
			while(true) {
				repaint();           //�ػ�
				
				try {
					Thread.sleep(40);               //�ػ���Ƶ��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}         
			} 
		}
	}
	
	class KeyMonitor extends KeyAdapter{                                                                            //�����������̵��ڲ���
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}
	
	
//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������	
	
	public void launchFrame() {                                                                                   //�������������ڵ�һЩ��������
		
		this.setTitle("��ѻ�ķɻ�");                            //�����ڲ���������
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(300,300);
		
		this.addWindowListener(new WindowAdapter(){          //�����ڵ������ر�
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		new PaintThread().start();                         //�����ػ����ڵ��߳�
		
		addKeyListener(new KeyMonitor());                 //���Ӽ��̵ļ���
		
		for(int i=0;i<shells.length;i++) {                //�������е�shell��ʼ�� 
			shells[i]=new Shell();			
			}
		}
		
		
		
		
		
	

//������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������	
	
	
	public static void main(String[] args) {
		Frame a = new Frame();
		a.launchFrame();
	}
}
