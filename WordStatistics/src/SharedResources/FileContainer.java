package SharedResources;

import Utility.Column;
import static Utility.Path.generateMapKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xorigin
 */
public class FileContainer {
    
    private static Map<String, ArrayList<Object>> mFileName = new HashMap<String, ArrayList<Object>>();
    
    private static ArrayList<Object> generateColumns(){
        
        ArrayList<Object> columnArr = new ArrayList<>();
        
        for(int i = 0; i < 6; i++)
            columnArr.add((i == 1 || i == 2) ? "" : 0);
        
        return columnArr;

    }
     
    public static synchronized void add(int dirType, String dirName, String fileName){
        mFileName.put(generateMapKey(dirType, dirName) + "/" + fileName, generateColumns());
    }
    
    public static synchronized void incrementCounter(int dirType, String dirName, String fileName, int numOfCol){
        
        int oldValue = (int) mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).get(numOfCol);
        mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).set(numOfCol, oldValue + 1);

    }
 
    public static synchronized void storeLongestWord(int dirType, String dirName, String fileName, String word){
        mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).set(Column.LONGEST_WORD.ordinal(), word);
    }
    
    public static synchronized void storeShortestWord(int dirType, String dirName, String fileName, String word){
        mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).set(Column.SHORTEST_WORD.ordinal(), word);
    }
    
    public static String getStatisticsOf(int dirType, String dirName, String fileName, int numOfCol){
        
           return mFileName.get(generateMapKey(dirType, dirName) + "/" + fileName).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mFileName.clear();
    }

}
