import javax.swing.JFrame;
import java.awt.Dimension;

public class Game extends JFrame 
{
	private Board panel;
	
	public Game(Dimension d)
	{
		panel = new Board();
		add(panel);
		setSize(d.width, d.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Game gf = new Game(new Dimension(640, 480));
	}
}
