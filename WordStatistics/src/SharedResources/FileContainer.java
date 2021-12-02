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
            mColumn.put(i, 0);
        
        return mColumn;
        
    }
    
    public static void add(String fileName){
        mFileName.put(fileName, generateColumns());
    }
    
    public static void incrementCounter(String fileName, int numOfCol){
        mFileName.get(fileName).put(numOfCol, 1+(Integer)mColumn.get(numOfCol));
    }
 
    public static void storeLongestWord(String fileName, String word){
        mFileName.get(fileName).put(Column.LONGEST_WORD.ordinal(), word);
    }
    
    public static void storeShortestWord(String fileName, String word){
        mFileName.get(fileName).put(Column.SHORTEST_WORD.ordinal(), word);
    }
    
    public static String getStatisticsOf(String fileName, int numOfCol){
           return mFileName.get(fileName).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mColumn.clear();
        mFileName.clear();
    }
    
}
