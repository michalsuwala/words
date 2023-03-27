import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.Scanner;

public class GetWords {
    public ArrayList<Wscore[]> getWords(int n, boolean f) throws FileNotFoundException {
        int len = 0;
        try {
            File fread = new File(f ? "wordss.txt" : "wordz");
            Scanner sf = new Scanner(fread);

            while(sf.hasNextLine()){
                len++;
                sf.nextLine();
            }

            sf.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        //Words words = new Words();
        Temp temp = new Temp(f);
        ArrayList<Wscore[]> res = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < len / 2; i++) nums.add(i);
        Collections.shuffle(nums);
        for(int i = 0; i < n; i++){
            int index = nums.get(i);
            Wscore[] wscore = temp.getWord(index);
            res.add(wscore);
        }

        return res;
    }
}
