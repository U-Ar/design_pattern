import interpreter.*;
import visitor.*;

// 文字列のパースとキャンバスへの表示を行うFacade
public class Displayer {
    private Displayer() {}

    public static void displayProgram(String program) {
        try {
            ProgramNode node = new ProgramNode();
            node.parse(new Context(program));

            System.out.println("program: " + node);

            Visitor visitor = new DisplayVisitor(program);

            Thread.sleep(1000);

            visitor.visit(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
