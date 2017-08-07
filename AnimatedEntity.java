import java.util.Map;
import java.util.HashMap;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class AnimatedEntity extends RenderedEntity 
{
	protected BufferedImage entity;
	protected Map<Integer, Animation> animations = new HashMap<Integer, Animation>();
	protected float velX, velY;

	AnimatedEntity(int id, float x, float y)
	{
		super(id, x, y);
	}
	
	abstract void update();
	
	abstract void draw(Graphics g, JPanel panel);
	
	public void addAnimation(int idVal, Animation animation)
	{
		if(animation != null) { this.animations.put(idVal, animation); }
		
		else { System.out.println("Cannot add a null animation"); }
	}
	
	public Animation getAnimation(int idVal) { return animations.get(idVal); }
	
	public float getVelX() { return velX; }

	public void setVelX(float velX) { this.velX = velX; }

	public float getVelY() { return velY; }

	public void setVelY(float velY) { this.velY = velY; }
}
