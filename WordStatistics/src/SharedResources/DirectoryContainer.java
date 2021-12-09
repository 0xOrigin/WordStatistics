package SharedResources;

import Utility.Column;
import GUI.ResultFrame;
import Utility.Path;
import static Utility.Path.generateMapKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xorigin
 */
public class DirectoryContainer {
    
    private static Map<String, ArrayList<Object>> mDirName = new HashMap<String, ArrayList<Object>>();

    private static ArrayList<Object> generateColumns() {

        ArrayList<Object> columnArr = new ArrayList<>();

        for (int i = 0; i < 6; i++)
            columnArr.add((i == 1 || i == 2) ? "" : 0);

        return columnArr;

    }

    public static synchronized void add(String dirPath) {
        
        ArrayList<Object> columns = generateColumns();
        String dir = generateMapKey(dirPath);
        ArrayList<Object> rowData = new ArrayList<>();
        
        mDirName.put(dir, columns);
        
        DefaultTableModel model = (DefaultTableModel) ResultFrame.getInstance().getDirectoryTable().getModel();
        rowData.add(model.getRowCount() + 1);
        rowData.add(dir);
        for(Object o : columns){
            rowData.add(o);
        }
        
        model.addRow(rowData.toArray());
        
    }

    public static synchronized void incrementCounter(String filePath, int numOfCol) {
        
        String dir = generateMapKey(Path.getParentOfFile(filePath));
        int oldValue = (int) mDirName.get(dir).get(numOfCol);
        mDirName.get(dir).set(numOfCol, oldValue + 1);

    }

    public static synchronized void storeLongestWord(String filePath, String word) {

        String dir = generateMapKey(Path.getParentOfFile(filePath));
        
        if (word.length() >= mDirName.get(dir).get(Column.LONGEST_WORD.ordinal())
                .toString().length()) {

            mDirName.get(dir).set(Column.LONGEST_WORD.ordinal(), word);

        }

    }

    public static synchronized void storeShortestWord(String filePath, String word) {
        
        String dir = generateMapKey(Path.getParentOfFile(filePath));
        
        String s = mDirName.get(dir).get(Column.SHORTEST_WORD.ordinal()).toString();

        if ((word.length() <= s.length() || s.equals(""))) {

            mDirName.get(dir).set(Column.SHORTEST_WORD.ordinal(), word);

        }

    }

    public static String getStatisticsOf(String filePath, int numOfCol) {
        
        String dir = generateMapKey(Path.getParentOfFile(filePath));
        
        return mDirName.get(dir).get(numOfCol).toString();
    
    }

    public static void clearResults() {
        mDirName.clear();
    }
}
