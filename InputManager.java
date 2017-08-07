import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener
{
	
	private boolean[] key_state_up = new boolean[256];
	private boolean[] key_state_down = new boolean[256];
	
	private static InputManager instance = null;
	
	private InputManager() { super(); }
	
	public static InputManager getInstance()
	{
		if(instance == null) { instance = new InputManager(); }
		return instance;
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{ 
		if( e.getKeyCode() >= 0 && e.getKeyCode() < 256 ) 
		{
			key_state_down[e.getKeyCode()] = true;
			key_state_up[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if( e.getKeyCode() >= 0 && e.getKeyCode() < 256 ) 
		{
			key_state_down[e.getKeyCode()] = false;
			key_state_up[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
	
	public boolean isKeyDown( int key ) { return key_state_down[key]; }
	
	public boolean isKeyUp( int key ) { return key_state_up[key]; }
	
	public void update() 
	{
		key_state_up = new boolean[256];
	}	

}
