package abc;

import java.awt.Graphics;
import java.awt.Image;

/**
 * �ɻ���ը�����javaͼƬ
 * ���Ҳ�����ը����Ƭ��
 * @author ��ѻ
 *
 */

public class Java extends GameObject{
	public void drawSelf(Graphics g) {                                            //����������ͼ
		g.drawImage(img, (int)x,(int)y,null);
	}
	
	public Java(Image img,double x,double y) {
		this.img=img;
		this.x=x;
		this.y=y;
	}

}