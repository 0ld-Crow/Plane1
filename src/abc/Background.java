package abc;

import java.awt.Graphics;
import java.awt.Image;

/**
 * ±≥æ∞¿‡
 * @author ¿œ—ª
 *
 */

public class Background extends GameObject{
	public void drawSelf(Graphics g) {                                            //”√¿¥ª≠±≥æ∞Õº
		g.drawImage(img, (int)x,(int)y,null);
	}
	
	public Background(Image img,double x,double y) {
		this.img=img;
		this.x=x;
		this.y=y;
	}

}
