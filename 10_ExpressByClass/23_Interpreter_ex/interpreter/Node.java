package interpreter;

import visitor.Visitor;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;

    public abstract void accept(Visitor visitor);
}