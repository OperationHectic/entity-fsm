import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class ImageLoader 
{
    protected BufferedImage img;
    
    protected ImageLoader() {}
	
	public ImageLoader(String path) { loadImg(path); }
	
	protected boolean loadImg(String path)
	{
		try
		{
		  img = ImageIO.read(new File(path));
		  return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public BufferedImage getImg() { return img; }
}
