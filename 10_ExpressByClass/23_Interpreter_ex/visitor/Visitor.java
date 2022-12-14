package visitor;

import interpreter.*;

public interface Visitor {
    public abstract void visit(CommandListNode node);
    public abstract void visit(CommandNode node);
    public abstract void visit(PrimitiveCommandNode node);
    public abstract void visit(ProgramNode node);
    public abstract void visit(RepeatCommandNode node);
}
