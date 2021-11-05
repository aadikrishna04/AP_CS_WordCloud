import java.util.*;
import java.io.*;

public class WordCloud {
  private ArrayList<Word> words;
  private ArrayList<Word> topHits;
  private int totalWords;
  private int uniqueWords;

  public WordCloud(String fileName) throws IOException {
    words = new ArrayList<Word>();
    topHits = new ArrayList<Word>();
    totalWords = 0;
    uniqueWords = 0;
    load(fileName);
  }

  private int getIndex(String str) {
    for(int i = 0; i < words.size(); i++) {
      if(words.get(i).getWord().equals(str)) {
        return i;
      } else {
        return -1;
      }
    }
  }

  private void load(String fileName) {
    Scanner console = new Scanner(fileName);
    
    while(console.hasNextLine()) {
      console.next().toLowerCase();

      if(Character.isLetterOrDigit(console.next().charAt(0))) {
        console.next() = console.next().substring(1);
      } else if(Character.isLetterOrDigit(console.next().length() - 1)) {
        console.next() = console.next().substring(0, console.next() - 1);
      }

      if(getIndex(console.next() == -1) {
        words.add(new Word(console.next()));
      } else {
        words.get(getIndex(console.next().increment()));
      }

      totalWords++;
      uniqueWords++;
    }
  }

  public ArrayList<Word> getTopHits() {
    while(topHits.size() <= 30) {
      int largest = 0;
      int index = 0;

      for(int i = 0; i < words.size(); i++) {
        if(words.get(i).getCount() > largest) {
          index = i;
          largest = words.get(i).getCount();
        }
      }

      topHits.add(words.get(index));
      words.remove(index);
    }
    
    return topHits;
  }

  public void printInfo() {
    System.out.println("Number of unique words >>>" + uniqueWords);
    System.out.println("Total # of words >>> " + totalWords);

    for(ArrayList<Word> item: topHits) {
      System.out.println(item.toString());
    }
  }
}
