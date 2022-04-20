package OOP;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static ArrayList<Word> listWord = new ArrayList();
//    public static List<String> listWordTarget = new ArrayList();
//    public static List<String> listWordRelated = new ArrayList();

    public Dictionary() {
    }

    public static void showAllWord() throws FileNotFoundException {
        System.out.println("No   |English\t\t\t\t\t\t|Vietnamese");

        for(int i = 0; i < listWord.size(); ++i) {
            String wordTarget = ((Word)listWord.get(i)).getWord_target();
            String wordExplain = ((Word)listWord.get(i)).getWord_explain();
            System.out.printf("%d     |%s\t\t\t\t\t|%s\n", i, wordTarget, wordExplain);
        }
    }
}