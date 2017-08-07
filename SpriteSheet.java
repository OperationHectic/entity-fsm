import java.awt.image.BufferedImage;

public class SpriteSheet extends ImageLoader
{
	//private BufferedImage img;
	private BufferedImage[] frames;
	private int frameWidth, frameHeight;
	private int framesInRow, numRows;
	
	public SpriteSheet(String path, int frameWidth, int frameHeight)
	{
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		if(loadImg(path))
		{
		   calcFrames();
		   loadFrames();
		}
	}
	
	private void calcFrames()
	{
	   framesInRow = Math.floorDiv(img.getWidth(), frameWidth);
	   numRows = Math.floorDiv(img.getHeight(), frameHeight);
	   frames = new BufferedImage[framesInRow*numRows];
	}
	
	private void loadFrames()
	{
		int row, col;
		BufferedImage temp;
		
		for(int currentFrame=0; currentFrame<frames.length; currentFrame++)
		{
			row = Math.floorDiv(currentFrame, framesInRow);
			col = Math.floorMod(currentFrame, framesInRow);
			temp = img.getSubimage(col * frameWidth, row * frameHeight, frameWidth, frameHeight);
			frames[currentFrame] = temp;
		}
	}
	
	public BufferedImage getFrame(int frameNum) { return frames[frameNum]; }
}
