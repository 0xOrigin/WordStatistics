package Utility;

import SharedResources.DirectoryContainer;
import SharedResources.FileContainer;

public class Counter {
  static void IncreseIs(int dirType, String dirName, String fileName) {
    FileContainer.incrementCounter(dirType, dirName, fileName,
        Column.NUMBER_OF_IS.ordinal());

    DirectoryContainer.incrementCounter(dirType, dirName,
        Column.NUMBER_OF_IS.ordinal());
  }

  static void IncreseYou(int dirType, String dirName, String fileName) {
    FileContainer.incrementCounter(dirType, dirName, fileName,
        Column.NUMBER_OF_YOU.ordinal());

    DirectoryContainer.incrementCounter(dirType, dirName,
        Column.NUMBER_OF_YOU.ordinal());
  }

  static void IncreseAre(int dirType, String dirName, String fileName) {
    FileContainer.incrementCounter(dirType, dirName, fileName,
        Column.NUMBER_OF_ARE.ordinal());

    DirectoryContainer.incrementCounter(dirType, dirName,
        Column.NUMBER_OF_ARE.ordinal());
  }

  static void IncreseWords(int dirType, String dirName, String fileName) {
    FileContainer.incrementCounter(dirType, dirName, fileName,
        Column.NUMBER_OF_WORDS.ordinal());

    DirectoryContainer.incrementCounter(dirType, dirName,
        Column.NUMBER_OF_WORDS.ordinal());
  }
}