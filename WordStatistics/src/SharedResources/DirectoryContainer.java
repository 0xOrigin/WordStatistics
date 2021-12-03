package SharedResources;

import Utility.Column;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xorigin
 */
public class DirectoryContainer {
    
    private static Map<Integer, Object> mColumn;
    private static Map<String, Map> mDirName = new HashMap<String, Map>();
    
    private static Map generateColumns(){
        
        mColumn = new HashMap<>();
        
        for(int i = 0; i < 6; i++)
            mColumn.put(i, (i == 1 || i == 2 ? "" : 0));
        
        return mColumn;
        
    }
    
    public static void add(String dirName){
        mDirName.put(dirName, generateColumns());
    }
    
    public static void incrementCounter(String dirName, int numOfCol){
        mDirName.get(dirName).put(numOfCol, 1+(Integer)mColumn.get(numOfCol));
    }
 
    public static void storeLongestWord(String dirName, String word){
        mDirName.get(dirName).put(Column.LONGEST_WORD.ordinal(), word);
    }
    
    public static void storeShortestWord(String dirName, String word){
        mDirName.get(dirName).put(Column.SHORTEST_WORD.ordinal(), word);
    }
    
    public static String getStatisticsOf(String dirName, int numOfCol){
           return mDirName.get(dirName).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mColumn.clear();
        mDirName.clear();
    }
    
}
