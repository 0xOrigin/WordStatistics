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
    
    public synchronized static boolean isEmpty(){
        return q.isEmpty();
    }
    
    public synchronized static int size(){
        return q.size();
    }
    
}
