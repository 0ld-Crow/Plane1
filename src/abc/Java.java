package abc;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 飞机爆炸后产生java图片
 * （找不到爆炸的照片）
 * @author 老鸦
 *
 */

public class Java extends GameObject{
	public void drawSelf(Graphics g) {                                            //用来画背景图
		g.drawImage(img, (int)x,(int)y,null);
	}
	
	public Java(Image img,double x,double y) {
		this.img=img;
		this.x=x;
		this.y=y;
	}

}