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
 * 飞机的主窗口的初始化
 * @author 老鸦
 *
 */


public class Frame extends JFrame{
	
	
	
	
	
	Image planeimg = Photoinput.getImage("images/plane.png");                                                       //利用Photoinput工具类导入照片
	Image backgroundimg = Photoinput.getImage("images/background.jpg");
	Image javaimg = Photoinput.getImage("images/Java.jpg");
	
	Java java;                                  //爆炸后显示的照片
	
	Date startTime = new Date();              //设置开始时间
	Date endTime;                            //设置结束时间
	int period;                               //计算持续时间
	
	Plane plane = new Plane(planeimg,350,350);
	Background background = new Background(backgroundimg,0,0);
	
	Shell []shells = new Shell[50];           //建立50个Shell对象放在数组里面，在类中只有属性和方法，所以初始化不能放在这里
	
	
	public void paint(Graphics g)/*g相当于画笔*/ {        /*自动被调用*/                                               //用来在主窗口上画东西
		

		
		plane.drawSelf(g);                                //用来画背景图
		background.drawSelf(g);                              //用来画飞机
		
		for(int i=0;i<shells.length;i++) {                       //每画一次圆都检测一次是否和飞机碰撞
			shells[i].drawSelf(g);
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				
				plane.live =false; 
				if(java==null) {                                //爆炸一次
					java = new Java(javaimg,0,0);
					endTime = new Date();
					period=(int)((endTime.getTime()-startTime.getTime())/1000);
				}
				
				
			}
			
			if(!plane.live) {                                  //爆炸后的操作 
				java.drawSelf(g);
				
				Font f =new Font("宋体",Font.BOLD,50);
				g.setFont(f);
				g.setColor(Color.red);
				g.drawString("时间："+period+"秒", (int)plane.x, (int)plane.y);
				
			}
			
			
		}
		
		
	}
	
	
	
	class PaintThread extends Thread {                                                                            //用来反复重画窗口的内部类
		@Override
		public void run() {
			while(true) {
				repaint();           //重画
				
				try {
					Thread.sleep(40);               //重画的频率
				} catch (InterruptedException e) {
					e.printStackTrace();
				}         
			} 
		}
	}
	
	class KeyMonitor extends KeyAdapter{                                                                            //用来监听键盘的内部类
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}
	
	
//———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————	
	
	public void launchFrame() {                                                                                   //用来设置主窗口的一些基本东西
		
		this.setTitle("老鸦的飞机");                            //主窗口参数的设置
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(300,300);
		
		this.addWindowListener(new WindowAdapter(){          //主窗口的真正关闭
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		new PaintThread().start();                         //启动重画窗口的线程
		
		addKeyListener(new KeyMonitor());                 //增加键盘的监听
		
		for(int i=0;i<shells.length;i++) {                //对数组中的shell初始化 
			shells[i]=new Shell();			
			}
		}
		
		
		
		
		
	

//———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————	
	
	
	public static void main(String[] args) {
		Frame a = new Frame();
		a.launchFrame();
	}
}
