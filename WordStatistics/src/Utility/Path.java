package Utility;

import java.io.File;
/**
 *
 * @author xorigin
 */
public class Path { 
    
    private static String fullPath = "", parentDir = "";
    
    private static void initPaths(String pDir, String path){
        parentDir = pDir;
        fullPath = path;
    }
    
    public static boolean isValid(String dirPath){
        File dir = new File(dirPath);
        initPaths(dir.getName(), dirPath);
        return dir.isDirectory();
    }
    
    public static String getParentDirName(){
        return parentDir;
    }
    
    public static String getSubDirName(String path){
        File p = new File(path);
        return p.getName();
    }
    
    public static String getFileName(String path) throws Exception{
        File p = new File(path);
        if(p.isFile()){
            return p.getName();
        }
        throw RuntimeException();
    }
    
    public static String getFullPath(){
        return fullPath;
    }
    
    public static String generateMapKey(int dirType, String dir){
        if(dirType == 1){
            return (getParentDirName() + "/" + dir);
        }
        return dir;
    }

    private static Exception RuntimeException() {
        throw new UnsupportedOperationException("Make sure you passed a file not dir.");
    }
}
