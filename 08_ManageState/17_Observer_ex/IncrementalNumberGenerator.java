public class IncrementalNumberGenerator extends NumberGenerator {
    private int start, end, width, current;

    public IncrementalNumberGenerator(int start, int end, int width) {
        this.start = start;
        this.end = end;
        this.width = width;
        this.current = start;
    }

    @Override 
    public int getNumber() {
        return current;
    }

    @Override 
    public void execute() {
        for (int i = start; i < end; i += width) {
            current = i;
            notifyObservers();
        }
    }
}
