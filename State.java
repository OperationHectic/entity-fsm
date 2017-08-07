public interface State<object_type> 
{
	public void enter(object_type obj);
	
	public void execute(object_type obj);
	
	public void exit(object_type obj);
}
