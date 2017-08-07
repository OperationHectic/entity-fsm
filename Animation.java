import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation 
{
	private ArrayList<Integer> animationSequence;
	private SpriteSheet ss;
	private int currentFrame;
    private int counter, frameSpeed;
    
    public Animation(SpriteSheet ss, int frameSpeed, int startFrame, int endFrame)
    {
    	this.ss = ss;
    	this.frameSpeed = frameSpeed;
    	animationSequence = new ArrayList<Integer>();
    	
    	for(int frameNum = startFrame; frameNum <= endFrame; frameNum++) 
    		animationSequence.add(frameNum); 
    }
    
    public Animation(SpriteSheet ss, int frameSpeed, int[] sequence)
    {
    	this.ss = ss;
    	this.frameSpeed = frameSpeed;
    	animationSequence = new ArrayList<Integer>();
    	
    	for(int i = 0; i < sequence.length; i++)
    	    this.animationSequence.add(sequence[i]);
    }
    
    public void update()
    {
    	if(counter == (frameSpeed - 1))
    	   currentFrame = (currentFrame + 1) % (animationSequence.size());
    	
    	counter = (counter + 1) % frameSpeed;
    }
    
    public int getCurrentFrame() { return currentFrame; }

	public void setCurrentFrame(int frameNum) { currentFrame = frameNum; }
    
    public BufferedImage getFrame() { return ss.getFrame(animationSequence.get(currentFrame)); }
}
