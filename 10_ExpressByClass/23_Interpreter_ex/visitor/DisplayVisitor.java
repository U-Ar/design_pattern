package visitor;

import interpreter.*;
import util.Direction;

import java.awt.*;
import javax.swing.*;

public class DisplayVisitor extends JFrame implements Visitor {
    private TextField programField = new TextField();
    private Canvas canvas = new Canvas();

    // グリッドの格子幅
    private int distance = 30;
    // 頂点円の半径
    private int radius = 4;

    // 現在地のx座標
    private int x = 200;
    // 現在地のy座標
    private int y = 200;
    // 現在向いている方向
    private Direction direction = Direction.NORTH;

    public DisplayVisitor(String program) {
        super("Interpreter Pattern Sample");

        programField.setText(program);
        programField.setEditable(false);

        canvas.setSize(400,400);
        canvas.setBackground(Color.white);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(programField);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public void visit(CommandListNode node) {
        for (Node n: node) {
            n.accept(this);
        }
    };

    public void visit(CommandNode node) {
        node.getNode().accept(this);
    };

    public void visit(PrimitiveCommandNode node) {
        String name = node.getName();
        if (name == "go") {
            System.out.println("Draw a line " + direction + ".");
            Graphics g = canvas.getGraphics();
            g.drawLine(
                Math.min(x,x + distance * direction.getDx()), 
                Math.min(y,y + distance * direction.getDy()), 
                Math.max(x,x + distance * direction.getDx()), 
                Math.max(y,y + distance * direction.getDy())
            );
            x += distance * direction.getDx();
            y += distance * direction.getDy();
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        } else if (name == "right") {
            System.out.println("Turn right. x:" + x + " y:" + y);
            direction = Direction.turnRight(direction);
        } else if (name == "left") {
            System.out.println("Turn left. x:" + x + " y:" + y);
            direction = Direction.turnLeft(direction);
        }
    };

    public void visit(ProgramNode node) {
        Graphics g = canvas.getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        node.getNode().accept(this);
    };

    public void visit(RepeatCommandNode node) {
        System.out.println("Repeat " + node.getNumber() + " times.");
        for (int i = 0; i < node.getNumber(); ++i) {
            node.getNode().accept(this);
        }
    };
}
