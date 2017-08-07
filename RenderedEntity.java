import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class RenderedEntity extends BaseEntity 
{
	protected float x, y;
	
	RenderedEntity(int id, float x, float y)
	{
		super(id);
		this.x = x;
		this.y = y;
	}

	abstract void update();
	
	abstract void draw(Graphics g, JPanel panel);
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public void setX(float x) { this.x = x; }
	
	public void setY(float y) { this.y = y; }
}
