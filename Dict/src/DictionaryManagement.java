import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    public DictionaryManagement() {
        super();
    }
    public void insertFromCommandline() {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int nums = input2.nextInt();
        while (0 < nums) {
            String line = input.nextLine();
            String[] rows = line.split("\t");
            String word_target = rows[0];
            String word_explain = rows[1];
            super.addWord(word_target, word_explain);
            nums--;
        }
    }
    public void insertFromFile(String filePath) {
        String line;
        String split = "\t";
        try {
            BufferedReader br = new BufferedReader(new FileReader("Dict/src/dictionaries.txt"));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(split);
                super.addWord(row[0], row[1]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Thêm các từ vào từ điển
        super.addWord("hello", "Xin chào.");
        super.addWord("java", "phim nhật.");

    }

    public String dictionaryLookup(String word_find) {
        word_find = word_find.toLowerCase();
        for (Word word: super.getDictionary()) {
            String res = word.getWord_target().trim().toLowerCase();
            if(res.equals(word_find)){
                return word.getWord_explain();
            }
        }
        return "NOT FOUND WORD \n";
    }

    public void DeleteFromDict(String target) {
        target = target.toLowerCase();
        for (int i = 0; i < super.getDictionary().size(); i++) {
            String delete_key = getDictionary().get(i).getWord_target().toLowerCase();
            if (delete_key.equals(target)) super.remove(i);
        }
    }

    public int binaryFind(String keyWord) {
        try {
            super.wordArrayList.sort(new ComparatorWord());
            int left = 0;
            int right = getDictionary().size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int res = getDictionary().get(mid).getWord_target().compareTo(keyWord);
                if (res == 0) return mid;
                if (res <= 0) left = mid + 1;
                else right = mid - 1;
            }
        } catch (NullPointerException e) {
            System.out.println("Null Exception.");
        }
        return -1;
    }

}

// Ko co gi