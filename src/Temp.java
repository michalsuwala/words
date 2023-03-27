import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Temp {


        public ArrayList<Wscore> norsk;
        public ArrayList<Wscore> english;

        public Wscore[] getWord(int i) throws IndexOutOfBoundsException{
            Wscore[] res = {norsk.get(i), english.get(i)};
            return res;
        }

        public Temp(boolean f) throws FileNotFoundException {
            norsk = new ArrayList<>();
            english = new ArrayList<>();

            try {
                File fread = new File(f ? "wordss.txt" : "wordz");
                Scanner sf = new Scanner(fread);

                int i = 0;

                while(sf.hasNextLine()){
                    if(i % 2 == 0){
                        String[] tmp = sf.nextLine().split("\\|");
                        Wscore wsc = new Wscore(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
                        norsk.add(wsc);

                    }
                    else{
                        String[] tmp = sf.nextLine().split("\\|");
                        Wscore wsc = new Wscore(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
                        english.add(wsc);
                    }
                    i++;
                }

                sf.close();
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }
        public ArrayList<Wscore> getNorsk(){
            return norsk;
        }

    public ArrayList<Wscore> getEnglish() {
        return english;
    }

    public void addWord(){
            try {
                FileWriter fwrite = new FileWriter("wordss.txt", true);
                Scanner ss = new Scanner(System.in);
                System.out.println("Add norwegian word");
                String temp = ss.nextLine();
                Wscore wscore = new Wscore(temp);
                fwrite.append(String.format("%s|%d|%d\n", wscore.sent, wscore.points, norsk.size() + english.size()));
                System.out.println("Add english word");
                temp = ss.nextLine();
                Wscore wscore1 = new Wscore(temp);
                fwrite.append(String.format("%s|%d|%d\n", wscore1.sent, wscore1.points, norsk.size() + english.size() + 1));
                ss.close();
                fwrite.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    class Wscore{
        Wscore(String sent){
            this.sent = sent;
            this.points = 0;
        }
        Wscore(String sent, int points){
            this.sent = sent;
            this.points = points;
        }

        public Wscore(String sent, int points, int index) {
            this.sent = sent;
            this.points = points;
            this.index = index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String sent;
        public int points;
        public int index;
    }


