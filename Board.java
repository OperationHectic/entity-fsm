import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Image;
//import javax.swing.ImageIcon;

public class Board extends JPanel implements Runnable
{
	
	private boolean running = false;
	private Thread thread;
	private SpriteSheet ss;
	private Animation cat;
	Player player = new Player(1, 0, 0, new SpriteSheet("characters.png", 32, 32));
	Tile grass = new Tile(0, 31, 31, "grass_tile.png");
	Archive archive = Archive.getInstance();
	FileManager fileMgr = FileManager.getInstance();
	private InputManager input = InputManager.getInstance();
	
	public Board() 
	{
		ss = new SpriteSheet("cat.png", 512, 256);
		cat = new Animation(ss, 3, 0, 7);
		setBackground(Color.BLACK);
		addKeyListener(input);
		setFocusable(true);
		//archive.addEntry("Birds", "Crow", "it is a crow");
		//archive.addEntry("Birds", "Duck", "it is a duck");
		//archive.test("Birds", "Duck");
		//archive.test("Birds", "Crow");
		try {
			fileMgr.readFile("InputFiles/manifest.txt", filetype.MANIFEST);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}
	
	private synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop()
	{
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	@Override
	public void run() 
	{
		long start = System.nanoTime();
		final double amtFrames = 60.0;
		double ns = 1000000000/amtFrames;
		double delta = 0;
		long now = 0;
		long timer = System.currentTimeMillis(); 
		int frames = 0;
		int updates = 0;
		while(running)
		{
			now = System.nanoTime();
			delta += (now - start) / ns;
			start = now;
			while(delta >= 1)
			{
				//System.out.println("delta: " + delta);
				keyboard();
				update();
				updates++;
				delta--;
			}
			render();
			//input.update();
			frames++;
			
			if(System.currentTimeMillis() - timer >= 1000)
			{
				timer += 1000;
				//System.out.println("frames: " + frames + " updates: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	public void keyboard()
	{
		if(input.isKeyDown(KeyEvent.VK_DOWN))
		{
		   player.keyPressed(KeyEvent.VK_DOWN);
		} 
		
		if(input.isKeyUp(KeyEvent.VK_DOWN)) 
		{
			player.keyReleased(KeyEvent.VK_DOWN);	
		}
		
		if(input.isKeyDown(KeyEvent.VK_UP))
		{
		   player.keyPressed(KeyEvent.VK_UP);
		} 
		
		if(input.isKeyUp(KeyEvent.VK_UP)) 
		{
			player.keyReleased(KeyEvent.VK_UP);	
		}
		
		if(input.isKeyDown(KeyEvent.VK_LEFT))
		{
		   player.keyPressed(KeyEvent.VK_LEFT);
		}
		
		if(input.isKeyUp(KeyEvent.VK_LEFT)) 
		{
			player.keyReleased(KeyEvent.VK_LEFT);	
		}
		
		if(input.isKeyDown(KeyEvent.VK_RIGHT))
		{
		   player.keyPressed(KeyEvent.VK_RIGHT);
		} 
		
		if(input.isKeyUp(KeyEvent.VK_RIGHT)) 
		{
			player.keyReleased(KeyEvent.VK_RIGHT);	
		}
		
		input.update();
	}
	
	public void update()
	{
		player.update();
	}
	
	public void render()
	{
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
		
		//Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		
		//g2d.drawImage(grass.getImg(), 0, 0, null, null);
		grass.draw(g2d, this);
		player.draw(g2d, this);
		//AffineTransform at = AffineTransform.getScaleInstance(getWidth(), getHeight());
	}
}
