import java.util.Comparator;

// test
public class ComparatorWord implements Comparator<Word> {
    @Override
    public int compare(Word a, Word b) {
        return a.getWord_target().compareTo(b.getWord_target());
    }
}
