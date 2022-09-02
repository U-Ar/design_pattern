package interpreter;

import visitor.Visitor;

public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    public int getNumber() {
        return number;
    }

    public Node getNode() {
        return commandListNode;
    }

    @Override 
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }

    @Override 
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
