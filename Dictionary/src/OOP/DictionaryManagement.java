package OOP;

import OOP.Dictionary;

import java.io.*;
import java.util.*;

public class DictionaryManagement extends Dictionary {
    public DictionaryManagement() {
    }
    public static String insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of words you want to insert: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            System.out.print("Enter Word_Target: ");
            String wordTarget = sc.nextLine();
            System.out.print("Enter this Word_Explain: ");
            String wordExplain = sc.nextLine();
            Word newWord = new Word(wordTarget, wordExplain);
            listWord.add(newWord);
        }
        return "Insert successful!";
    }

    public static void insertFromFile() {
        listWord.clear();
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(new File("src\\File\\dictionaries.txt"));
            while (sc.hasNext()) {
                String wordTarget = sc.nextLine().trim();
                String wordExplain = sc.nextLine().trim();
                listWord.add(new Word(wordTarget, wordExplain));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your word target: ");
        String wordtarget = sc.nextLine();
        Iterator var3 = listWord.iterator();

        while(var3.hasNext()) {
            Word word = (Word)var3.next();
            if (wordtarget.equalsIgnoreCase(word.getWord_target())) {
                ++count;
                System.out.println("The word explain is: ");
                System.out.println(word.getWord_explain());
            }
        }

        if (count == 0) {
            System.out.println("No word exist!");
        }

    }

    public static void addWordFromCommandline()
    {
        System.out.println("Enter a word_target & a word_explain you want to add: ");
        Scanner sc = new Scanner(System.in);
        String wordTarget = sc.nextLine();
        String wordExplain = sc.nextLine();
        listWord.add(new Word(wordTarget,wordExplain));
    }


    public static String removeFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word you want to delete: ");
        String wordTarget = sc.nextLine();

        for(int i = 0; i < listWord.size(); i++) {
            if (wordTarget.equalsIgnoreCase(((Word)listWord.get(i)).getWord_target())) {
                listWord.remove(listWord.get(i));
            }
        }

        return "Remove successful";
    }

    public static void editFromCommandLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word you want to edit: ");
        String s = sc.nextLine();
        boolean m = false;
        for(Word word : listWord)
        {
            if(s.equalsIgnoreCase(word.getWord_explain())) {
                System.out.println("Enter a new target:");
                String newtarget = sc.nextLine();
                word.setWord_target(newtarget);
                m=true;
            }
            else if (s.equalsIgnoreCase(word.getWord_target()))
            {
                System.out.println("Enter a new explain:");
                String newexplain = sc.nextLine();
                word.setWord_explain(newexplain);
                m=true;
            }
        }
        if(m==false) {
            System.out.println("Invalid");
        }
        else {
            System.out.println("Edit Successfull");
        }
    }

    public static void dictionarySearcher()
    {
        System.out.println("Enter a word you want to search: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Word> words = new ArrayList<Word>();
        for(Word word : listWord)
        {
            if(word.getWord_target().startsWith(s))
            {
                words.add(new Word(word.getWord_target(),word.getWord_explain()));
            }
        }
        System.out.println("NO\t| English\t | Vietnamese");
        for(int i=0;i<words.size();i++)
        {
            System.out.println((i+1)+"\t"+words.get(i).getWord_target()+"\t"+words.get(i).getWord_explain());
        }
    }

    public static void dictionaryExportToFile() {
        try {
            FileWriter fileWriter = new FileWriter("src\\File\\dictionaries(new).txt");

            for(int i = 0; i < listWord.size(); i++) {
                fileWriter.write(((Word)listWord.get(i)).getWord_target() + "\n");
                fileWriter.write(((Word)listWord.get(i)).getWord_explain() + "\n");
            }

            fileWriter.close();
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
