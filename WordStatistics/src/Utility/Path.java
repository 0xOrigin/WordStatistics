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
        return path.replaceAll(beforeTheParentDir, "");
    }
    
}
