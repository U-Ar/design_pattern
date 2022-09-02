package interpreter;

import java.util.Map; 
import java.util.HashMap;

public class PrimitiveCommandNodeFactory {
    private static PrimitiveCommandNodeFactory singleton = new PrimitiveCommandNodeFactory();

    private Map<String,PrimitiveCommandNode> pool = new HashMap<>();

    private PrimitiveCommandNodeFactory() {
        pool.put("go", new PrimitiveCommandNode("go"));
        pool.put("right", new PrimitiveCommandNode("right"));
        pool.put("left", new PrimitiveCommandNode("left"));
    }

    public static PrimitiveCommandNodeFactory getInstance() { return singleton; }

    public synchronized PrimitiveCommandNode getNode(String name) throws ParseException {
        return getNode(name, true);
    }

    public synchronized PrimitiveCommandNode getNode(String name, boolean shared) throws ParseException {
        if (name == null) {
            throw new ParseException("Error: Missing <primitive command>");
        }

        if (shared) {
            PrimitiveCommandNode node = pool.get(name);
            if (node == null) {
                throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
            }
            return node;
        } else {
            if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
                throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
            }
            PrimitiveCommandNode node = new PrimitiveCommandNode(name);
            return node;
        }
    }
}
