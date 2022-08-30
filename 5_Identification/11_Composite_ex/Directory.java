import java.util.List;
import java.util.ArrayList;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override 
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) {
        entry.setParent(this);
        directory.add(entry);
        return this;
    }

    @Override
    public String fullPath() {
        if (parent == null) return "/"+this.getName();
        return parent.fullPath() + "/" + this.getName();
    }
}
