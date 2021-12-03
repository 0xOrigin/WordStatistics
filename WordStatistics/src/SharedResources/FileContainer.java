package SharedResources;

import Utility.Column;
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
    
    public static void add(String dirName, String fileName){
        mFileName.put(dirName + "/" + fileName, generateColumns());
    }
    
    public static void incrementCounter(String dirName, String fileName, int numOfCol){
        mFileName.get(dirName + "/" + fileName).put(numOfCol, 1+(Integer)mColumn.get(numOfCol));
    }
 
    public static void storeLongestWord(String dirName, String fileName, String word){
        mFileName.get(dirName + "/" + fileName).put(Column.LONGEST_WORD.ordinal(), word);
    }
    
    public static void storeShortestWord(String dirName, String fileName, String word){
        mFileName.get(dirName + "/" + fileName).put(Column.SHORTEST_WORD.ordinal(), word);
    }
    
    public static String getStatisticsOf(String dirName, String fileName, int numOfCol){
           return mFileName.get(dirName + "/" + fileName).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mColumn.clear();
        mFileName.clear();
    }
    
}
