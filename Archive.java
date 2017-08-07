import java.util.HashMap;
import java.lang.Object;

public final class Archive
{
	HashMap<String, HashMap<String, Object>> m_archive = 
			new HashMap<String, HashMap<String, Object>>();
	
	private static Archive instance = null;
	
	private Archive() {}
	
	public static Archive getInstance()
	{
		if(instance == null) { instance = new Archive();}
		return instance;
	}
	
	public void addEntry(String entryName, String itemName, Object obj)
	{
		HashMap<String, ?> temp = m_archive.get(entryName);
		if(temp == null)
		{
		   HashMap<String, Object> entry = new HashMap<String, Object>();
		   entry.put(itemName, obj);
		   m_archive.put(entryName, entry);
		}
		else
		{
			m_archive.get(entryName).put(itemName, obj);
		}
	}
	
	public void test(String archiveName, String entryName)
	{
		System.out.println(m_archive.get(archiveName).get(entryName));
	}
}
