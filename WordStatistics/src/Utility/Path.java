package Utility;

import java.io.File;
/**
 *
 * @author xorigin
 */
public class Path { 
    
    private static String fullPath;
    
    public static boolean isValid(String dirPath){
        File dir = new File(dirPath);
        return dir.isDirectory();
    }
    
    public static String getDirName(String path){
        File dir = new File(path);
        fullPath = path;
        return dir.getName();
    }
    
    public static String getBeforeDirPath(){
        File path = new File(fullPath);
        return path.getParent();
    }
}
