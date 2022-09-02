package visitor;

import interpreter.*;

public class DisplayVisitor extends Visitor {
    public void visit(CommandListNode node) {};
    public void visit(CommandNode node) {};
    public void visit(PrimitiveCommandNode node) {};
    public void visit(ProgramNode node) {};
    public void visit(RepeatCommandNode node) {};
}
