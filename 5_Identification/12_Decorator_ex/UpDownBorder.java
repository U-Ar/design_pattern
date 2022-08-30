public class UpDownBorder extends Border {
    private char borderChar;

    public UpDownBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return makeLine(display.getColumns());
        } else if (row == display.getRows() + 1) {
            return makeLine(display.getColumns());
        } else {
            return display.getRowText(row-1);
        }
    }

    private String makeLine(int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            line.append(borderChar);
        } 
        return line.toString();
    }
}
