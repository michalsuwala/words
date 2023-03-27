import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        wordsA(20);
        //wordsB(5);
        scan(10);
        //addWord();
    }

    public static void wordsA(int n) throws FileNotFoundException {
        Answer answer = new Answer();
        answer.answer(n, true);
    }

    public static void wordsB(int n) throws FileNotFoundException {
        Answer answer = new Answer();
        answer.answer(n, false);
    }

    public static void addWord() throws FileNotFoundException {
        Temp temp = new Temp(true);
        temp.addWord();
    }

    public static void scan(int n) throws FileNotFoundException {
        Scan scan = new Scan();
        scan.scanA(n);
        scan.scanB(n);
    }
}