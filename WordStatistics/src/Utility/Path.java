package Utility;

import java.io.File;
/**
 *
 * @author xorigin
 */
public class Path { 
    
    public static boolean isValid(String dirPath){
        File dir = new File(dirPath);
        return dir.isDirectory();
    }
    
    public static String getDirName(String path){
        File dir = new File(path);
        return dir.getName();
    }
    
}
