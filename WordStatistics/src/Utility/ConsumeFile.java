package Utility;

import SharedResources.Buffer;
import SharedResources.FileContainer;
import Utility.Path;

public class ConsumeFile {
    private static final int MAX_NUM_OF_THREADS = 10;

    public synchronized static void consume() {

        while (true) {
            while (Buffer.isEmpty())
                ;

            int CURRENT_SIZE_OF_BUFFER = Buffer.size();

            final int NUM_OF_THREAD = Math.min(
                    CURRENT_SIZE_OF_BUFFER / 4 + (CURRENT_SIZE_OF_BUFFER % 4 == 0 ? 0 : 1),
                    MAX_NUM_OF_THREADS);

            Worker[] workerArr = new Worker[NUM_OF_THREAD];
            int start = 0;

            for (int j = 0; j < NUM_OF_THREAD; j++) {
                workerArr[j] = new Worker(start, start + 4, CURRENT_SIZE_OF_BUFFER);
                workerArr[j].start();
                start += 4;
            }

            for (Worker worker : workerArr) {
                try {
                    worker.join();
                } catch (InterruptedException e) {
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
                    FileContainer.add(Path.getdirType(currentPath), CurrentDirName(currentPath),
                            Path.getFileName(currentPath));
                    FReader.filereader(currentPath, CurrentDirName(currentPath), Path.getFileName(currentPath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private static String CurrentDirName(String path) {
            return (Path.getdirType(path) == 1 ? Path.getSubDirName(path)
                    : Path.getParentDirName());
        }
    }
}

// System.out.println(Thread.currentThread().getName());
