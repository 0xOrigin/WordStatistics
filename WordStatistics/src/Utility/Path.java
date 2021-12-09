package Utility;

import java.io.File;

/**
 *
 * @author xorigin
 */
public class Path {

    private static String  beforeTheParentDir = "";

    private static void initPath(String path) {
        File file = new File(path);
        beforeTheParentDir = file.getParent() + "/";
    }

    public static boolean isValid(String dirPath) {
        File dir = new File(dirPath);
        initPath(dirPath);
        return dir.isDirectory();
    }

    public static String getParentOfFile(String path) {
        File p = new File(path);
        return p.getParent();
    }

    public static String generateMapKey(String path) {
        return path.replaceAll(beforeTheParentDir, "");
    }
    
}
