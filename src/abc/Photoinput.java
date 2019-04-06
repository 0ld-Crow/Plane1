package abc;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * 将图片导入主窗口的工具类
 * @author 老鸦
 *
 */
public class Photoinput {
	private Photoinput() {
		
	}
	public static Image getImage(String path) {
		BufferedImage bi =null;
		try {
			URL u =Photoinput.class.getClassLoader().getResource(path);
			bi = ImageIO.read(u);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return bi;
	}

}
