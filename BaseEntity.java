
public abstract class BaseEntity 
{
	private int m_ID;
	
	BaseEntity(int id) {m_ID = id;}
	
	abstract void update();
	
	int getID() { return m_ID; }
}
