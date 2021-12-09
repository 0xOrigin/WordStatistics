package Utility;
import java.io.File;
import SharedResources.DirectoryContainer;
import java.io.FilenameFilter;

public class DiscoverSubdirs implements Runnable {
    
    private String path = "";
    
    public DiscoverSubdirs(String path){
        this.path = path;
    }
    
    @Override
    public void run(){
        
        File file = new File(path);
        
        File[] subdirs = file.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File current, String name){
                return new File(current, name).isDirectory();
            }
        });
        
        Thread t;
        for(File dir :subdirs){

            DirectoryContainer.add(dir.getAbsolutePath());
            t = new Thread(new DiscoverFiles(dir.getAbsolutePath()));
            t.start();            

        }
    } 
}
