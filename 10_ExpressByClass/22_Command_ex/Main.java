import command.*;
import drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton blackButton = new JButton("black");
    private JButton redButton = new JButton("red");
    private JButton undoButton = new JButton("undo");
    private JButton clearButton = new JButton("clear");

    public Main(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });

        blackButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.BLACK);
            history.append(cmd);
            cmd.execute();
        });

        redButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.RED);
            history.append(cmd);
            cmd.execute();
        });

        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });

        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(blackButton);
        buttonBox.add(redButton);
        buttonBox.add(undoButton);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
