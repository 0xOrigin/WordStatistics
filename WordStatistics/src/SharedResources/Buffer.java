package SharedResources;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xorigin
 */
public class Buffer {
    
    private static Queue<String> q = new LinkedList<>();

    public static void pushBack(String dirName, String fileName){
        q.add(dirName + " " + fileName);
    }
    
    public static String getAndPopFront(){
        return (!q.isEmpty() ? q.remove() : null);
    }
    
    public static boolean isEmpty(){
        return q.isEmpty();
    }
    
    public static int size(){
        return q.size();
    }
    
}
