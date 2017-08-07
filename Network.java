import java.net.*;

public class Network 
{
	public Network()
	{
		try
		{
		   InetAddress address = InetAddress.getLocalHost();
		}
		catch(UnknownHostException e)
		{
			
		}
	}
}
