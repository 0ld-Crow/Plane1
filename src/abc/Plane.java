package abc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 * �ɻ���
 * @author ������
 *
 */
public class Plane extends GameObject {
	int speed =6;
	
	boolean live =true;                                       //�����˷ɻ�������
	
	public void drawSelf(Graphics g) {                                                                       //�������ɻ�
		
		
		
		if(live) {                                           //���ɻ�������true�Żử���ɻ�
			
			g.drawImage(img, (int)x,(int)y,null);
			
			
			if(left) {                                     //�ƶ��ɻ�
				if(x>0) {                   //ʹ�÷ɻ��ɲ�����Ļ
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
		
		
		this.width=img.getWidth(null);                       //Ϊ�˺������ײ�����Ի�÷ɻ���size
		this.height=img.getHeight(null);
		
	}
	
	
	                                                                                                                     //��Ӧ����
	boolean left,right,up,down;
	public void addDirection(KeyEvent e) {                                      //����ĳ����������Ӧ�ķ���
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
	
	public void minusDirection(KeyEvent e) {                                      //̧��ĳ����ȡ����Ӧ�ķ���
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
