package interpreter;

import visitor.Visitor;

public class PrimitiveCommandNode extends Node {
    private String name;

    PrimitiveCommandNode(String name) {
        this.name = name;
    }

    @Override 
    public void parse(Context context) throws ParseException {
    }

    @Override 
    public String toString() {
        return name;
    }

    @Override 
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
