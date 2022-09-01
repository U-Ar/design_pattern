public abstract class Entry {
    protected Entry parent = null;

    public abstract String getName();

    public abstract int getSize();

    public void setParent(Entry e) {
        this.parent = e;
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " ("+getSize()+")";
    }

    public abstract String fullPath();

}