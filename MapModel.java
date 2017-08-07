import java.util.ArrayList;

public class MapModel 
{
		private ArrayList<ArrayList<Integer>> m_mapData = new ArrayList<ArrayList<Integer>>();

		public MapModel() { }
		
		public ArrayList<ArrayList<Integer>> getMapData() { return m_mapData; }

		public void setMapData(ArrayList<ArrayList<Integer>> mapData) { m_mapData = mapData; }
}
