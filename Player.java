import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;

public class Player extends AnimatedEntity 
{
	final int FRONT = 0;
	final int BACK = 1;
	final int LEFT = 2;
	final int RIGHT = 3;
	
	private int speed;
	private int currentDirection;
	private boolean isMoving;
	private SpriteSheet sheet;
	private int animationSpeed = 8;
	private Animation currentAnimation;
	
	Player(int id, float x, float y, SpriteSheet ss)
	{
		super(id, x, y);
		speed = 1;
		sheet = ss;
		loadAnimations();
		currentDirection = RIGHT;
		currentAnimation = getAnimation(currentDirection);
		setVelX(0);
		setVelY(0);
	}
	
	public int getSpeed() { return speed; }

	public void setSpeed(int speed) { this.speed = speed; }

	private void loadAnimations()
	{
		if(sheet != null)
		{
		   int[] front = {1, 0, 1, 2};
		   int[] back = {37, 36, 37, 38};
		   int[] left = {13, 12, 13, 14};
		   int[] right = {25, 24, 25, 26};
		   addAnimation(FRONT, new Animation(sheet, animationSpeed, front));
		   addAnimation(BACK,  new Animation(sheet, animationSpeed, back));
		   addAnimation(LEFT,  new Animation(sheet, animationSpeed, left));
		   addAnimation(RIGHT, new Animation(sheet, animationSpeed, right));
		}
	}

	public void update() 
	{
		x += velX;
	    y += velY;
		if(isMoving)
		{
			currentAnimation = getAnimation(currentDirection); 
			currentAnimation.update();
		} 
		else { currentAnimation.setCurrentFrame(0); }
	}
	
	public void keyPressed(int key)
	{
		isMoving = true;
		switch(key)
		{
		    case KeyEvent.VK_DOWN:  currentDirection = FRONT;
		                            setVelY(speed);    break;
		    
		    case KeyEvent.VK_UP:    currentDirection = BACK; 
		                            setVelY(-speed);   break;
		                            
		    case KeyEvent.VK_LEFT:  currentDirection = LEFT;  
		                            setVelX(-speed);   break;
		                            
		    case KeyEvent.VK_RIGHT: currentDirection = RIGHT;  
		                            setVelX(speed);    break;
		}
	}
	
	public void keyReleased(int key)
	{
		isMoving = false;
		switch(key)
		{
		    case KeyEvent.VK_DOWN:  setVelY(0);  break;
		    
		    case KeyEvent.VK_UP:    setVelY(0); break;
		                            
		    case KeyEvent.VK_LEFT:  setVelX(0); break;
		                            
		    case KeyEvent.VK_RIGHT: setVelX(0); break;
		}
	}
	
	public void draw(Graphics g, JPanel panel) 
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(currentAnimation.getFrame(), (int)x, (int)y, panel);
	}
}
