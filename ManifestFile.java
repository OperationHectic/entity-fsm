import java.util.ArrayList;

public class ManifestFile 
{
    private ArrayList<String> files;
    
    public ManifestFile() { files = new ArrayList<String>(); }
    
    public ManifestFile(ArrayList<String> files) { this.files = files; }
    
    public void add(String fileName) { files.add(fileName); }
    
    public ArrayList<String> getFiles() { return files; }
}
