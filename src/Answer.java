import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Answer {
    private int score = 0;
    private int i = 1;
    public void answer(int n, boolean f) throws FileNotFoundException {
        GetWords getwords = new GetWords();
        Scanner ss = new Scanner(System.in);
        Temp temp = new Temp(f);
        try {
            temp.getWord(n);
        } catch(IndexOutOfBoundsException e){
            System.out.println("Not enough words");
            return;
        }

        for(Wscore[] s : getwords.getWords(n, f)){
            System.out.println(s[1].sent);
            System.out.println("Answer:");
            if(ss.nextLine().equals(s[0].sent)){
                System.out.println("Correct");
                score++;
                s[0].points++;
                s[1].points++;
            }
            else{
                System.out.println(String.format("Incorrect: %s", s[0].sent));
                if(s[0].points > 0) {
                    s[0].points--;
                    s[1].points--;
                }
            }
            temp.norsk.set(s[0].index / 2, s[0]);
            temp.english.set(s[1].index / 2, s[1]);
            System.out.println(String.format("%d/%d", score, i));
            i++;
        }
        try {
            FileWriter fwrite = new FileWriter(f ? "wordss.txt" : "wordz");
            int len = temp.getEnglish().size();
            for(int i = 0; i < len; i++) {


                fwrite.append(String.format("%s|%d|%d\n", temp.norsk.get(i).sent, temp.norsk.get(i).points, temp.norsk.get(i).index));
                fwrite.append(String.format("%s|%d|%d\n", temp.english.get(i).sent, temp.english.get(i).points, temp.english.get(i).index));


            }
            fwrite.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
