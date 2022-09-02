package interpreter;

import visitor.Visitor;

public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        String token = context.currentToken();
        if (token.equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        } else {
            PrimitiveCommandNodeFactory factory = PrimitiveCommandNodeFactory.getInstance();
            node = factory.getNode(token);
            context.skipToken(token);
        }
    }

    @Override
    public String toString() {
        return node.toString();
    }

    @Override 
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
