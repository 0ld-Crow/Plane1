package abc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 * 飞机类
 * @author 邢梓奇
 *
 */
public class Plane extends GameObject {
	int speed =6;
	
	boolean live =true;                                       //设置了飞机的生命
	
	public void drawSelf(Graphics g) {                                                                       //用来画飞机
		
		
		
		if(live) {                                           //当飞机生命会true才会画出飞机
			
			g.drawImage(img, (int)x,(int)y,null);
			
			
			if(left) {                                     //移动飞机
				if(x>0) {                   //使得飞机飞不出屏幕
					x-=speed;
				}	
			}
			if(right) {
				if(x<Constant.GAME_WIDTH-width) {
					x+=speed;
				}		
			}
			if(up) {
				if(y>40) {
					y-=speed;
				}				
			}
			if(down) {
				if(y<Constant.GAME_HEIGHT-height) {
					y+=speed;
				}				
			}
		}else {
			
		}
		
		
		

	}
	
	
	public Plane(Image img,double x,double y) {                                 
		this.img=img;
		this.x=x;
		this.y=y;
		
		
		this.width=img.getWidth(null);                       //为了后面的碰撞检测可以获得飞机的size
		this.height=img.getHeight(null);
		
	}
	
	
	                                                                                                                     //响应键盘
	boolean left,right,up,down;
	public void addDirection(KeyEvent e) {                                      //按下某键，增加相应的方向
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;	
		case KeyEvent.VK_UP:
			up = true;
			break;	
		case KeyEvent.VK_DOWN:
			down = true;
			break;				
		}
	}
	
	public void minusDirection(KeyEvent e) {                                      //抬起某键，取消相应的方向
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;	
		case KeyEvent.VK_UP:
			up = false;
			break;	
		case KeyEvent.VK_DOWN:
			down = false;
			break;				
		}
	}

}
