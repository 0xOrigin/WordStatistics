package Utility;

import SharedResources.Buffer;
import SharedResources.FileContainer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumeFile {
    private static final int MAX_NUM_OF_THREADS = 20;
    private static final int NUM_OF_FILES_PER_THREAD = 1;
    
    public static void consume() {

        while (true) {
            
            while (Buffer.isEmpty()){
              
            }
            
            int CURRENT_SIZE_OF_BUFFER = Buffer.size();

            final int NUM_OF_THREAD = Math.min(
                    CURRENT_SIZE_OF_BUFFER / NUM_OF_FILES_PER_THREAD + (CURRENT_SIZE_OF_BUFFER % NUM_OF_FILES_PER_THREAD == 0 ? 0 : 1),
                    MAX_NUM_OF_THREADS);

            Worker[] workerArr = new Worker[NUM_OF_THREAD];
            int start = 0;

            for (int j = 0; j < NUM_OF_THREAD; j++) {
                workerArr[j] = new Worker(start, start + NUM_OF_FILES_PER_THREAD, CURRENT_SIZE_OF_BUFFER);
                workerArr[j].start();
                start += NUM_OF_FILES_PER_THREAD;
            }
            
            for(Worker worker : workerArr){
                
                 try {
                     worker.join();
                 } catch (InterruptedException ex) {
                     Logger.getLogger(ConsumeFile.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
            }
        }
    }

    private static class Worker extends Thread {
        private int currentSize, start, stop;

        public Worker(int start, int stop, int currentSize) {
            super();
            this.start = start;
            this.stop = stop;
            this.currentSize = currentSize;
        }

        @Override
        public void run() {
            for (int i = start; i < stop && i < currentSize; i++) {
                String currentPath = Buffer.getAndPopFront();
                try {
               
                    FileContainer.add(currentPath);
                    FReader.read(currentPath);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println(Thread.currentThread().getName());
            }
        }

    }
}
