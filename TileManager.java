import java.util.Map;
import java.util.HashMap;

public class TileManager 
{
	Map<String, Tile> m_TileMap = new HashMap<String, Tile>();
	
	private static TileManager instance;
	
	private TileManager() {}
	
	static TileManager instance() 
	{
	    instance = new TileManager();
		return instance;
	}
	
	public void add(String name, Tile tile) { m_TileMap.put(name, tile); }
}
