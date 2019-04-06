package abc;

import java.awt.Color;
import java.awt.Graphics;

/**
 * �ڵ���
 * @author ��ѻ
 *
 */

public class Shell extends GameObject {
	double degree;
	public Shell() {                                                             //��ʼ���ڵ�����Ϣ
		x=200;
		y=200;
		width=30;
		height=30;
		speed=3;
		
		degree = Math.random()*Math.PI*2;
		
		
	}
	
	
	
	public void drawSelf(Graphics g) {                                                                                             //���ڵ�
		g.drawImage(img, (int)x,(int)y,null);
		
		Color c=g.getColor();
		
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x,(int)y,width,height);
		
		x+=speed*Math.cos(degree);                                    //�ڵ��ĳ�ʼ�Ƕȣ����⣩     
		y+=speed*Math.sin(degree);
		
		
		if(x<0 || x>Constant.GAME_WIDTH-width) {                           //�ڵ������ıڻص�
			degree = Math.PI-degree;
		}
		
		if(y<40 || y>Constant.GAME_HEIGHT-height) {
			degree = -degree;
		}
		
		
		
		
		g.setColor(c);
	}

}
