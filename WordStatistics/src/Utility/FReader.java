package Utility;

import SharedResources.DirectoryContainer;
import SharedResources.FileContainer;
import static Utility.Path.getdirType;
import java.util.*;
import java.io.*;

public abstract class FReader implements Runnable {

    private static String path ;
    private static int dirType = 0 ;

    public static void filereader(String path, String dirName, String fileName) {
        FReader.path = path;
        FReader.dirType = getdirType(path);
        UpdateStatistics(dirType, dirName, fileName);
    }

    private synchronized static void UpdateStatistics(int dirType, String dirName, String fileName) {
        try {
            ArrayList<String> FileContent = ReadFromFile();
            String LONGEST_WORD = "", SHORTEST_WORD = "";
            for (String line : FileContent) {
                String[] words = line.split(" ");
                for (String word : words) {
                    
                    FileContainer.incrementCounter(dirType, dirName, fileName,
                   Column.NUMBER_OF_WORDS.ordinal());
                    
                    DirectoryContainer.incrementCounter(dirType, dirName,
                                   Column.NUMBER_OF_WORDS.ordinal());

                    switch (word.toLowerCase()) {
                        case "is": {
                            FileContainer.incrementCounter(dirType, dirName, fileName,
                                   Column.NUMBER_OF_IS.ordinal());

                            DirectoryContainer.incrementCounter(dirType, dirName,
                                   Column.NUMBER_OF_IS.ordinal());

                            break;
                        }
                        case "are": {
                            FileContainer.incrementCounter(dirType, dirName, fileName,
                                   Column.NUMBER_OF_ARE.ordinal());

                            DirectoryContainer.incrementCounter(dirType, dirName,
                                   Column.NUMBER_OF_ARE.ordinal());

                            break;
                        }
                        case "you": {
                            FileContainer.incrementCounter(dirType, dirName, fileName,
                                   Column.NUMBER_OF_YOU.ordinal());

                            DirectoryContainer.incrementCounter(dirType, dirName,
                                   Column.NUMBER_OF_YOU.ordinal());

                            break;
                        }
                        default: {
                            if (word.length() > LONGEST_WORD.length()) {
                                LONGEST_WORD = word;
                                FileContainer.storeLongestWord(dirType, dirName, fileName, LONGEST_WORD);
                                DirectoryContainer.storeLongestWord(dirType, dirName, LONGEST_WORD);
                            }
                            if (word.length() < SHORTEST_WORD.length() || SHORTEST_WORD.length() == 0) {
                                SHORTEST_WORD = word;
                                FileContainer.storeShortestWord(dirType, dirName, fileName,
                                        SHORTEST_WORD);
                                DirectoryContainer.storeLongestWord(dirType, dirName, SHORTEST_WORD);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

  
    private static ArrayList<String> ReadFromFile() throws IOException {
        ArrayList<String> FileContent = null;
        File file = new File(path);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            FileContent = new ArrayList<String>(Arrays.asList(new String(chars).split("\n")));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return FileContent;
    }

}
