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
public class DirectoryContainer {
    
    private static Map<String, ArrayList<Object>> mDirName = new HashMap<String, ArrayList<Object>>();
    
    private static ArrayList<Object> generateColumns(){
        
        ArrayList<Object> columnArr = new ArrayList<>();
        
        for(int i = 0; i < 6; i++)
            columnArr.add((i == 1 || i == 2) ? "" : 0);
        
        return columnArr;

    }
    
    public static synchronized void add(int dirType, String dirName){
        mDirName.put(generateMapKey(dirType, dirName), generateColumns());
    }
    
    public static synchronized void incrementCounter(int dirType, String dirName, int numOfCol){
        
        int oldValue = (int) mDirName.get(generateMapKey(dirType, dirName)).get(numOfCol);
        mDirName.get(generateMapKey(dirType, dirName)).set(numOfCol, oldValue + 1);

    }
 
    public static synchronized void storeLongestWord(int dirType, String dirName, String word){
        
        if(word.length() >= mDirName.get(generateMapKey(dirType, dirName)).get(Column.LONGEST_WORD.ordinal()).toString().length()){
        
            mDirName.get(generateMapKey(dirType, dirName)).set(Column.LONGEST_WORD.ordinal(), word);
        
        }
        
        System.out.println(mDirName.get(generateMapKey(dirType, dirName)).get(Column.LONGEST_WORD.ordinal()).toString() + "    from longest dir = " + dirName);
    }
    
    public static synchronized void storeShortestWord(int dirType, String dirName, String word){
        
        if(word.length() <= mDirName.get(generateMapKey(dirType, dirName)).get(Column.SHORTEST_WORD.ordinal()).toString().length()){
            
            mDirName.get(generateMapKey(dirType, dirName)).set(Column.SHORTEST_WORD.ordinal(), word);
        
        }
        
        System.out.println(mDirName.get(generateMapKey(dirType, dirName)).get(Column.SHORTEST_WORD.ordinal()).toString()+ "    from shortest dir = " + dirName);
    }
    
    public static String getStatisticsOf(int dirType, String dirName, int numOfCol){
        return mDirName.get(generateMapKey(dirType, dirName)).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mDirName.clear();
    }
}
