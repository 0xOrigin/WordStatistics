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

    private static DefaultTableModel model = (DefaultTableModel) ResultFrame.getInstance().getDirectoryTable().getModel();
    
    private static ArrayList<Object> generateColumns() {

        ArrayList<Object> columnArr = new ArrayList<>();

        for (int i = 0; i < 7; i++)
            columnArr.add((i == Column.LONGEST_WORD.ordinal() || i == Column.SHORTEST_WORD.ordinal()) ? "" : 0);

        return columnArr;

    }

    public synchronized static void add(String dirPath) {
        
        ArrayList<Object> columns = generateColumns();
        String dir = generateMapKey(dirPath);
        ArrayList<Object> rowData = new ArrayList<>();
        
        columns.set(Column.ROW_NUM.ordinal(), model.getRowCount() + 1);
        
        mDirName.put(dir, columns);
        
        rowData.add(columns.get(Column.ROW_NUM.ordinal()));
        rowData.add(dir);
        for(int i = 1; i < 7; i++){
            rowData.add(columns.get(i));
        }
        
        model.addRow(rowData.toArray());
        
    }

    public synchronized static void incrementCounter(String filePath, int numOfCol) {
        
        String dir = generateMapKey(Path.getParentOfFile(filePath));
        int newValue = (int) mDirName.get(dir).get(numOfCol) + 1;
        mDirName.get(dir).set(numOfCol, newValue);
        /////////////////////////////////////////////////////
        if(!dir.equals(Path.getParentMapKey())){
            int newVal = (int) mDirName.get(Path.getParentMapKey()).get(numOfCol) + 1;
            mDirName.get(Path.getParentMapKey()).set(numOfCol, newVal);
            if(numOfCol > 0){
                model.setValueAt(newVal, (int)mDirName.get(Path.getParentMapKey()).get(Column.ROW_NUM.ordinal())-1, numOfCol+1);
            }
        }
        ////////////////////////////////////////////////////
        if(numOfCol > 0){
            model.setValueAt(newValue, (int)mDirName.get(dir).get(Column.ROW_NUM.ordinal())-1, numOfCol+1);
        }
    }

    public synchronized static void storeLongestWord(String filePath, String word) {

        String dir = generateMapKey(Path.getParentOfFile(filePath));
        
        if (word.length() >= mDirName.get(dir).get(Column.LONGEST_WORD.ordinal()).toString().length()) {

            mDirName.get(dir).set(Column.LONGEST_WORD.ordinal(), word);
            
            model.setValueAt(word, (int)mDirName.get(dir).get(Column.ROW_NUM.ordinal())-1, Column.LONGEST_WORD.ordinal()+1);
            
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (word.length() >= mDirName.get(Path.getParentMapKey()).get(Column.LONGEST_WORD.ordinal()).toString().length()) {

            mDirName.get(Path.getParentMapKey()).set(Column.LONGEST_WORD.ordinal(), word);
            
            model.setValueAt(word, (int)mDirName.get(Path.getParentMapKey()).get(Column.ROW_NUM.ordinal())-1, Column.LONGEST_WORD.ordinal()+1);
            
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public synchronized static void storeShortestWord(String filePath, String word) {
        
        String dir = generateMapKey(Path.getParentOfFile(filePath));
        
        String s = mDirName.get(dir).get(Column.SHORTEST_WORD.ordinal()).toString();

        if ((word.length() <= s.length() || s.equals(""))) {

            mDirName.get(dir).set(Column.SHORTEST_WORD.ordinal(), word);

            model.setValueAt(word, (int)mDirName.get(dir).get(Column.ROW_NUM.ordinal())-1, Column.SHORTEST_WORD.ordinal()+1);
            
        }
        ///////////////////////////////////////////////////////////////////////////
        String ss = mDirName.get(Path.getParentMapKey()).get(Column.SHORTEST_WORD.ordinal()).toString();
        if ((word.length() <= ss.length() || ss.equals(""))) {

            mDirName.get(Path.getParentMapKey()).set(Column.SHORTEST_WORD.ordinal(), word);

            model.setValueAt(word, (int)mDirName.get(Path.getParentMapKey()).get(Column.ROW_NUM.ordinal())-1, Column.SHORTEST_WORD.ordinal()+1);
            
        }
        //////////////////////////////////////////////////////////////////////////////
    }

}
