import java.util.Scanner;

public class DictionaryCommandline {
    protected DictionaryManagement DictionaryManage;
    public DictionaryCommandline() {
        this.DictionaryManage = new DictionaryManagement();
        DictionaryManage.insertFromFile("src\\english.txt");
    }
    //
    public void showAllWords() {
        System.out.printf("%-6s%c %-15s%c %-20s%n","No", '|' ,"English", '|', "Vietnamese");
        for (int i = 0; i < DictionaryManage.getDictionary().size(); i++) {
            System.out.printf("%-6d%c %-15s%c %-15s%n", i + 1,'|',  DictionaryManage.getDictionary().get(i).getWord_target(), '|',DictionaryManage.getDictionary().get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {

        DictionaryManage.insertFromCommandline();
        this.showAllWords();
    }

//    public <Trie> ArrayList<String> dictionarySearcher(String find) {
//        find = find.toUpperCase();
//        ArrayList<Word> arrayList = super.getDictionary();
//        Trie findTrie = new Trie();
//        for (Word word : arrayList) {
//            String key = word.getWord_target().toLowerCase();
//            findTrie.add(key);
//        }
//        return findTrie.findAllWord(find);
//    }


    public void dictionaryAdvance() {
        while (true) {
            System.out.println("Welcome to advanced dictionary");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");

            System.out.println("[7] Import from file");
            System.out.println("[8] Export to file");
            System.out.print("Your action: ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "0":
                    System.out.println("exiting");
                    return;
                case "1":
                    // insert from commandline "Add"
                    DictionaryManage.insertFromCommandline();
                    break;

                case "2":
                    // "remove"
                    System.out.println("enter word to remove");
                    String word2 = scanner.nextLine();
                    DictionaryManage.DeleteFromDict(word2);
                    break;
                case "3":
                    System.out.println("enter word to change");
                    String word3 = scanner.nextLine();
                    DictionaryManage.DeleteFromDict(word3);
                    break;


                case "4":
                    // Display all words
                    showAllWords();
                    break;

                case "5":
                    //lookup
                    System.out.println("enter word to lookup");
                    String word5 = scanner.nextLine();
                    System.out.println(DictionaryManage.dictionaryLookup(word5));
                    break;
//                case "6":
//                    //search
//                    System.out.println("enter word to search");
//                    String word6 = scanner.nextLine();
//                    this.dictionarySearcher(word6);
//                    break;
                case "7" :
                    //import from file
                    System.out.println("name of the file");
                    String word7 = scanner.nextLine();
                    DictionaryManage.insertFromFile("src\\" + word7);
                    System.out.println("insert successful");
                    break;

//                case "8" :
//                    //export to file
//                    System.out.println("exporting");
//                    dictionaryManagement.dictionaryExportToFile();
//                    break;
//
                default:
                    System.out.println("Invalid action. Please enter a number between 0 and 9.");
                    break;
            }
        }
    }

}

