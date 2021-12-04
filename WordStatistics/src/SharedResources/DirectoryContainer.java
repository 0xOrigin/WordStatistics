package SharedResources;

import Utility.Column;
import static Utility.Path.generateMapKey;
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
    
    public static synchronized void add(int dirType, String dirName){
        mDirName.put(generateMapKey(dirType, dirName), generateColumns());
    }
    
    public static synchronized void incrementCounter(int dirType, String dirName, int numOfCol){
        mDirName.get(generateMapKey(dirType, dirName)).put(numOfCol, 1+(Integer)mColumn.get(numOfCol));
    }
 
    public static synchronized void storeLongestWord(int dirType, String dirName, String word){
        mDirName.get(generateMapKey(dirType, dirName)).put(Column.LONGEST_WORD.ordinal(), word);
    }
    
    public static synchronized void storeShortestWord(int dirType, String dirName, String word){
        mDirName.get(generateMapKey(dirType, dirName)).put(Column.SHORTEST_WORD.ordinal(), word);
    }
    
    public static String getStatisticsOf(int dirType, String dirName, int numOfCol){
        return mDirName.get(generateMapKey(dirType, dirName)).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mColumn.clear();
        mDirName.clear();
    }
     
}
