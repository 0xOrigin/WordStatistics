package SharedResources;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xorigin
 */
public class Buffer {
    
    private static Queue<String> q = new LinkedList<>();

    public synchronized static void pushBack(String path){
        q.add(path);
    }
    
    public synchronized static String getAndPopFront(){
        return (!q.isEmpty() ? q.remove() : null);
    }
    
    public static boolean isEmpty(){ // synchronized
        return q.isEmpty();
    }
    
    public static int size(){ // synchronized
        return q.size();
    }
    
    public static void clear(){
        q.clear();
    }
     
}
