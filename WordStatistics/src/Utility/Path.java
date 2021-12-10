package Utility;

import java.io.File;

/**
 *
 * @author xorigin
 */
public class Path {

    private static String  beforeTheParentDir = "", parentMapKey = "";
    private static boolean parentFlag = true;
    
    private static void initPath(String path) {
        File file = new File(path);
        beforeTheParentDir = file.getParent() + "/";
        beforeTheParentDir = beforeTheParentDir.replaceAll("\\\\", "/");
    }

    public static boolean isValid(String dirPath) {
        File dir = new File(dirPath);
        initPath(dirPath);
        return dir.isDirectory();
    }

    public static String getParentOfFile(String path) {
        File p = new File(path);
        String parent = p.getParent();
        return parent.replaceAll("\\\\", "/");
    }

    public static String generateMapKey(String path) {
        path = path.replaceAll("\\\\", "/");
        //////////////////////////////////////////
        if(parentFlag){
            parentMapKey = path.replaceAll(beforeTheParentDir, "");
            parentFlag = false;
        }
        //////////////////////////////////////////
        return path.replaceAll(beforeTheParentDir, "");
    }
    ////////////////////////////////////////////
    public static String getParentMapKey(){
        return parentMapKey;
    }
    ///////////////////////////////////////////
}
