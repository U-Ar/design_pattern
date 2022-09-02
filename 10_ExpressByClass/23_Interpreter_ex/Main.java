import java.nio.file.Files; 
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main filename");
            System.out.println("Ex)    java Main program.txt");
            System.exit(0);
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String text: Files.readAllLines(Path.of(args[0]))) {
                sb.append(text + " ");
            }
            String program = sb.toString();
            System.out.println("program = " + program);
            
            Displayer.displayProgram(program);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
