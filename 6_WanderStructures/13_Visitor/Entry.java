public abstract class Entry implements Element {
    public abstract String getName();

    public abstract int getSize();

    @Override
    public String toString() {
        return getName() + " ("+getSize()+")";
    }
}