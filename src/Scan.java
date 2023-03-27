import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scan {

    public void scanA(int n) throws FileNotFoundException {
        int k = 0, l = 0;

        Temp temp = new Temp(true);

        try {
            FileWriter fwrite = new FileWriter("wordss.txt");
            fwrite.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        try {
            File fread = new File("wordz");
            Scanner sf = new Scanner(fread);

            while(sf.hasNextLine()){
                k++;
                sf.nextLine();
            }

            sf.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        for(int i = 0; i < temp.english.size(); i++){
            if(temp.english.get(i).points >= n){

                try {
                    FileWriter fwrite = new FileWriter("wordz", true);

                        fwrite.append(String.format("%s|%d|%d\n", temp.norsk.get(i).sent, temp.norsk.get(i).points, k));
                        fwrite.append(String.format("%s|%d|%d\n", temp.english.get(i).sent, temp.english.get(i).points, k + 1));

                    fwrite.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
                k += 2;
            }
            else{
                try {
                    FileWriter fwrite = new FileWriter("wordss.txt", true);

                    fwrite.append(String.format("%s|%d|%d\n", temp.norsk.get(i).sent, temp.norsk.get(i).points, l));
                    fwrite.append(String.format("%s|%d|%d\n", temp.english.get(i).sent, temp.english.get(i).points, l + 1));

                    fwrite.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
                l += 2;
            }
        }
    }

    public void scanB(int n) throws FileNotFoundException {
        int k = 0, l = 0;

        Temp temp = new Temp(false);

        try {
            FileWriter fwrite = new FileWriter("wordz");
            fwrite.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        try {
            File fread = new File("wordss.txt");
            Scanner sf = new Scanner(fread);

            while(sf.hasNextLine()){
                k++;
                sf.nextLine();
            }

            sf.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        for(int i = 0; i < temp.english.size(); i++){
            if(temp.english.get(i).points < n){

                try {
                    FileWriter fwrite = new FileWriter("wordss.txt", true);

                    fwrite.append(String.format("%s|%d|%d\n", temp.norsk.get(i).sent, temp.norsk.get(i).points, k));
                    fwrite.append(String.format("%s|%d|%d\n", temp.english.get(i).sent, temp.english.get(i).points, k + 1));

                    fwrite.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
                k += 2;
            }
            else{
                try {
                    FileWriter fwrite = new FileWriter("wordz", true);

                    fwrite.append(String.format("%s|%d|%d\n", temp.norsk.get(i).sent, temp.norsk.get(i).points, l));
                    fwrite.append(String.format("%s|%d|%d\n", temp.english.get(i).sent, temp.english.get(i).points, l + 1));

                    fwrite.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
                l += 2;
            }
        }
    }
}
