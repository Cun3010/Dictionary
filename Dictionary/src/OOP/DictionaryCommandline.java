package OOP;

import OOP.Dictionary;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class DictionaryCommandline extends Dictionary {
    public DictionaryCommandline() {
    }

    public static void dictionaryBasic() throws FileNotFoundException, SQLException {
        DictionaryManagement.insertFromCommandline();
        Dictionary.showAllWord();
    }

    public static void dictionaryAdvanced() throws FileNotFoundException {

    }
    public static void dictionaryPlus() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        Dictionary.showAllWord();
        DictionaryManagement.dictionaryLookup();
        DictionaryManagement.dictionarySearcher();

    }
}