package abc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
/**
 * 嗄老嶄議匯乂麗悶議効窃
 * @author 析兒
 *
 */
public class GameObject {
	
	Image img;
	double x,y;
	int speed;
	int width,height;
	
	public void drawSelf(Graphics g) {
		g.drawImage(img, (int)x,(int)y,null);
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
	public GameObject() {
		
	}

//！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！	
	
	public Rectangle getRect() {                                       //卦指麗悶侭壓議裳侘��宴噐朔偬議当弉殊霞
		return new Rectangle((int)x,(int)y,width,height);
	}

}
