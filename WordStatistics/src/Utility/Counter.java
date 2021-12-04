package Utility;

import SharedResources.DirectoryContainer;
import SharedResources.FileContainer;

public class Counter {
    
    private volatile static Counter uniqueIstance;
    
    private Counter(){
    
    }
    
    public static Counter getInstance() {
        if(uniqueIstance == null){
            synchronized(Counter.class){
                uniqueIstance = new Counter();
            }
        }
        return uniqueIstance;
    }
    
    
    public static void increaseIs(int dirType, String dirName, String fileName) {
      FileContainer.incrementCounter(dirType, dirName, fileName,
          Column.NUMBER_OF_IS.ordinal());

      DirectoryContainer.incrementCounter(dirType, dirName,
          Column.NUMBER_OF_IS.ordinal());
    }

    public static void increaseYou(int dirType, String dirName, String fileName) {
      FileContainer.incrementCounter(dirType, dirName, fileName,
          Column.NUMBER_OF_YOU.ordinal());

      DirectoryContainer.incrementCounter(dirType, dirName,
          Column.NUMBER_OF_YOU.ordinal());
    }

    public static void increaseAre(int dirType, String dirName, String fileName) {
      FileContainer.incrementCounter(dirType, dirName, fileName,
          Column.NUMBER_OF_ARE.ordinal());

      DirectoryContainer.incrementCounter(dirType, dirName,
          Column.NUMBER_OF_ARE.ordinal());
    }

    public static void increaseWords(int dirType, String dirName, String fileName) {
      FileContainer.incrementCounter(dirType, dirName, fileName,
          Column.NUMBER_OF_WORDS.ordinal());

      DirectoryContainer.incrementCounter(dirType, dirName,
          Column.NUMBER_OF_WORDS.ordinal());
    }
}