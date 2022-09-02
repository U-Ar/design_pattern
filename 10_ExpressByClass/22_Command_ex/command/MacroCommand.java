package command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    private Deque<Command> commands = new ArrayDeque<>();

    @Override 
    public void execute() {
        for (Command cmd: commands) {
            cmd.execute();
        }
    }

    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.addLast(cmd);
    }

    public void undo() {
        if (!commands.isEmpty()) {
            commands.removeLast();
        }
    }

    public void clear() {
        commands.clear();
    }
}
