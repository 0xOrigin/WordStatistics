package Utility;

import SharedResources.Buffer;

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
                    
            Worker[] WorkerArr = new Worker[NUM_OF_THREAD];
            int start = 0;

            for (int j = 0; j < NUM_OF_THREAD; j++) {
                WorkerArr[j] = new Worker(start, start + 4, CURRENT_SIZE_OF_BUFFER);
                WorkerArr[j].start();
                start += 4;
            }

            for (Worker worker : WorkerArr) {
                try {
                    worker.join();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private static class Worker extends Thread {
        private int CurrentSize, start, stop;

        public Worker(int start, int stop, int CurrentSize) {
            super();
            this.start = start;
            this.stop = stop;
            this.CurrentSize = CurrentSize;
        }

        @Override
        public void run() {
            for (int i = start; i < stop && i < CurrentSize; i++) {
                String currentPath = Buffer.getAndPopFront();
                try {
                    FReader.filereader(
                            currentPath,
                            (Path.getdirType(currentPath) == 1 ? Path.getSubDirName(currentPath)
                                    : Path.getParentDirName()),
                            Path.getFileName(currentPath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// System.out.println(Thread.currentThread().getName());
