package SharedResources;

import Utility.Column;
import static Utility.Path.generateMapKey;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xorigin
 */
public class FileContainer {
    
    private static Map<Integer, Object> mColumn;
    private static Map<String, Map> mFileName = new HashMap<String, Map>();
    
    private static Map generateColumns(){
        
        mColumn = new HashMap<>();
        
        for(int i = 0; i < 6; i++)
            mColumn.put(i, (i == 1 || i == 2 ? "" : 0));
        
        return mColumn;
        
    }
    
    public static void add(int dirType, String dirName, String fileName){
        mFileName.put(generateMapKey(dirType, dirName)+ "/" + fileName, generateColumns());
    }
    
    public static void incrementCounter(int dirType, String dirName, String fileName, int numOfCol){
        mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).put(numOfCol, 1+(Integer)mColumn.get(numOfCol));
    }
 
    public static void storeLongestWord(int dirType, String dirName, String fileName, String word){
        mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).put(Column.LONGEST_WORD.ordinal(), word);
    }
    
    public static void storeShortestWord(int dirType, String dirName, String fileName, String word){
        mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).put(Column.SHORTEST_WORD.ordinal(), word);
    }
    
    public static String getStatisticsOf(int dirType, String dirName, String fileName, int numOfCol){
           return mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mColumn.clear();
        mFileName.clear();
    }
    
}
