package Utility;

import SharedResources.DirectoryContainer;
import SharedResources.FileContainer;
import static Utility.Path.getdirType;
import java.util.*;
import java.io.*;

public abstract class FReader implements Runnable {

    private static String path, dirName, fileName;
    private static int dirType = 0;

    public static void filereader(String path, String dirName, String fileName) throws IOException {
        FReader.path = path;
        FReader.dirName = dirName;
        FReader.fileName = fileName;
        FReader.dirType = getdirType(path);
        UpdateStatistics(dirType, dirName, fileName);
    }

    private static void UpdateStatistics(int dirType, String dirName, String fileName) throws IOException {
        
        Counter c = Counter.getInstance();
        
        ArrayList<String> FileContent = ReadFromFile();
        String LONGEST_WORD = "", SHORTEST_WORD = "";
        for (String line : FileContent) {
            String[] words = line.split(" ");
            for (String word : words) {
                Counter.IncreseWords(dirType, dirName, fileName);
                switch (word.toLowerCase()) {
                    case "is": {
                        Counter.IncreseIs(dirType, dirName, fileName);
                        break;
                    }
                    case "are": {
                        Counter.IncreseAre(dirType, dirName, fileName);
                        break;
                    }
                    case "you": {
                        Counter.IncreseYou(dirType, dirName, fileName);
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

    }

    private static ArrayList<String> ReadFromFile() throws IOException {
        ArrayList<String> FileContent = null;
        File file = new File(path);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            FileContent = new ArrayList<>(Arrays.asList(new String(chars).split("\n")));
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
