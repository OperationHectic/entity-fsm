import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Tile extends RenderedEntity 
{
	BufferedImage m_tileImg;
	
	public Tile(int id, float x, float y)
	{
		super(id, x, y);
	}
	
	public Tile(int id, float x, float y, String tileImg)
	{
		this(id, x, y);
		m_tileImg = new ImageLoader(tileImg).getImg();
	}
	
	public void update() {}
	
	public void draw(Graphics g, JPanel panel) 
	{
		Graphics2D g2d = (Graphics2D)g;
		try
		{
		   g2d.drawImage(m_tileImg, (int)x, (int)y, panel);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void setTileImg(BufferedImage tileImg) { m_tileImg = tileImg;}
}
