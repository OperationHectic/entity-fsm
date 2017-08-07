import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

enum filetype {MANIFEST, MAP, DATA, SAVE}

public class FileManager 
{
    private static FileManager instance = null;
	
	private FileManager() {}
	
	public static FileManager getInstance()
	{
		if(instance == null) { instance = new FileManager();}
		return instance;
	}
	
	public void readFile(String path, filetype type) throws IOException
	{
		fileFormat(getText(path), type);
	}
	
	private ArrayList<String> getText(String path) throws IOException
	{
		try
		{
		   ArrayList<String> buffer = new ArrayList<String>();
		   BufferedReader bf = new BufferedReader(new FileReader(path));
		   String line;
		   while((line = bf.readLine()) != null) 
		   { 
			   buffer.add(line);
		   } 
		   bf.close();
		   return buffer;
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	private void fileFormat(ArrayList<String> buffer, filetype type)
	{
	     switch(type)
	     {
	        case MANIFEST:  manifest(buffer); break;
	        case MAP:       map(buffer)     ; break;
	        case DATA:      data(buffer)    ; break;
	        case SAVE:      save(buffer)    ; break;
	     }
	}

	private ManifestFile manifest(ArrayList<String> buffer) 
	{
		if(buffer != null && buffer.get(0).equals("manifest_signature_625"))
		{
			ArrayList<String> temp = new ArrayList<String>();
			for(int i=1; i<buffer.size(); i++)
			{
				temp.add(buffer.get(i));
			}
			return new ManifestFile(temp);
		}
		else 
		{
			return null;
		}
	}
	
	private void map(ArrayList<String> buffer) 
	{
		
	}

	private void data(ArrayList<String> buffer) 
	{
	
		
	}
	
	private void save(ArrayList<String> buffer) 
	{
	
		
	}

	public void printText(ArrayList<String> text)
	{
		if(text != null)
		   for(String s: text) { System.out.println(s); }
	}
}
