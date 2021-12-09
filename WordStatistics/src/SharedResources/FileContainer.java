package SharedResources;

import GUI.ResultFrame;
import Utility.Column;
import static Utility.Path.generateMapKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

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
     
    public static synchronized void add(String filePath){
        
        ArrayList<Object> columns = generateColumns();
        String file = generateMapKey(filePath);
        ArrayList<Object> rowData = new ArrayList<>();
        
        mFileName.put(file, columns);
        
        DefaultTableModel model = (DefaultTableModel) ResultFrame.getInstance().getFileTable().getModel();
        rowData.add(model.getRowCount() + 1);
        rowData.add(file);
        for(Object o : columns){
            rowData.add(o);
        }
        
        model.addRow(rowData.toArray());
    }
    
    public static synchronized void incrementCounter(String filePath, int numOfCol){
        
        String file = generateMapKey(filePath);
        int oldValue = (int) mFileName.get(file).get(numOfCol);
        mFileName.get(file).set(numOfCol, oldValue + 1);
        
    }
 
    public static synchronized void storeLongestWord(String filePath, String word){
        String file = generateMapKey(filePath);
        mFileName.get(file).set(Column.LONGEST_WORD.ordinal(), word);

    }
    
    public static synchronized void storeShortestWord(String filePath, String word){
        String file = generateMapKey(filePath);
        mFileName.get(file).set(Column.SHORTEST_WORD.ordinal(), word);

    }
    
    public static String getStatisticsOf(String filePath, int numOfCol){
        String file = generateMapKey(filePath);
        return mFileName.get(file).get(numOfCol).toString();
    }
    
    public static void clearResults(){
        mFileName.clear();
    }

}
