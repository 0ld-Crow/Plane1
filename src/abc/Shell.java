package abc;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹类
 * @author 老鸦
 *
 */

public class Shell extends GameObject {
	double degree;
	public Shell() {                                                             //初始化炮弹的信息
		x=200;
		y=200;
		width=30;
		height=30;
		speed=3;
		
		degree = Math.random()*Math.PI*2;
		
		
	}
	
	
	
	public void drawSelf(Graphics g) {                                                                                             //画炮弹
		g.drawImage(img, (int)x,(int)y,null);
		
		Color c=g.getColor();
		
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x,(int)y,width,height);
		
		x+=speed*Math.cos(degree);                                    //炮弹的初始角度（任意）     
		y+=speed*Math.sin(degree);
		
		
		if(x<0 || x>Constant.GAME_WIDTH-width) {                           //炮弹碰到四壁回弹
			degree = Math.PI-degree;
		}
		
		if(y<40 || y>Constant.GAME_HEIGHT-height) {
			degree = -degree;
		}
		
		
		
		
		g.setColor(c);
	}

}
