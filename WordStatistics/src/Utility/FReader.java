package Utility;

import SharedResources.DirectoryContainer;
import SharedResources.FileContainer;
import java.util.*;
import java.io.*;

public abstract class FReader implements Runnable {

    public static void read(String filePath) throws IOException {

        Counter c = Counter.getInstance();

        ArrayList<String> FileContent = ReadFromFile(filePath);
        String LONGEST_WORD = "", SHORTEST_WORD = "";

        for (String line : FileContent) {
            String[] words = line.split("[\\s|\\u00A0]+");
            for (String word : words) {
                if ("".equals(word) || word.equals("[\\s|\\u00A0]+")) {
                    continue;
                }
                Counter.increaseWords(filePath);
                switch (word.toLowerCase()) {
                    case "is": {
                        Counter.increaseIs(filePath);
                        break;
                    }
                    case "are": {
                        Counter.increaseAre(filePath);
                        break;
                    }
                    case "you": {
                        Counter.increaseYou(filePath);
                        break;
                    }
                }
                if (word.length() >= LONGEST_WORD.length()) {
                    LONGEST_WORD = word;
                    FileContainer.storeLongestWord(filePath, LONGEST_WORD);
                    DirectoryContainer.storeLongestWord(filePath, LONGEST_WORD);
                }
                if ((word.length() <= SHORTEST_WORD.length()) || SHORTEST_WORD.length() == 0) {
                    SHORTEST_WORD = word;
                    FileContainer.storeShortestWord(filePath, SHORTEST_WORD);
                    DirectoryContainer.storeShortestWord(filePath, SHORTEST_WORD);
                }
            }
        }
    }

    private static ArrayList<String> ReadFromFile(String path) throws IOException {
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