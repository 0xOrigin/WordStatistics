package Utility;

import java.io.File;

/**
 *
 * @author xorigin
 */
public class Path {

    private static String fullPath = "", parentDirName = "";

    private static void initPaths(String pDir, String path) {
        parentDirName = pDir;
        fullPath = path;
    }

    public static boolean isValid(String dirPath) {
        File dir = new File(dirPath);
        initPaths(dir.getName(), dirPath);
        return dir.isDirectory();
    }

    public static String getParentDirName() {
        return parentDirName;
    }

    public static String currentDirName(String filepath) {
        File p = new File(filepath);
        File pn = new File(p.getParent());
        return pn.getName();
    }

    public static String getFileName(String path) throws Exception {
        File p = new File(path);
        if (p.isFile()) {
            return p.getName();
        }
        throw RuntimeException();
    }

    public static String getParentOfFile(String path) {
        File p = new File(path);
        return p.getParent();
    }

    public static String getFullPath() {
        return fullPath;
    }

    public static String generateMapKey(int dirType, String dir) {
        if (dirType == 1) {
            return (getParentDirName() + "/" + dir);
        }
        return dir;
    }

    public static int getdirType(String filePath) {
        return (getParentOfFile(filePath).equals(getFullPath()) ? 0 : 1);
    }

    private static Exception RuntimeException() {
        throw new UnsupportedOperationException("Make sure you passed a file not dir.");
    }

}
