import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferOverflowException;

// openとcloseでストリームの開始終了を書いたが、明らかにこれはよくない
// printのたびreadAllLinesしたテキストファイルの内容を表示した方が簡潔なコードになる
public class FileDisplayImpl extends DisplayImpl {
    private String filename = "hoge.txt";

    private FileReader reader;

    public FileDisplayImpl(String filename) {
        this.filename = filename;
    }

    public void rawOpen() {
        try {
            System.out.println("Reading " + filename);
            reader = new FileReader(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rawPrint() {
        try {
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
            reader.close();
            reader = new FileReader(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rawClose() {
        try {
            System.out.println("Closing " + filename);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
