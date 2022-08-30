import java.util.ArrayList;

public class MultiStringDisplay extends Display {
    private ArrayList<String> list = new ArrayList<>();
    private int columns = 0;

    @Override 
    public int getColumns() {
        return columns;
    }

    @Override 
    public int getRows() {
        return list.size();
    }

    // この実装だとgetRowText呼び出しのたびに新しく行テキストを構成する必要があるので、
    // 教科書だと都度リスト内容をアップデートするupdatePaddingメソッドをaddの際に呼び出す実装が採用
    @Override 
    public String getRowText(int row) {
        StringBuilder sb = new StringBuilder();
        String text = list.get(row);
        sb.append(text);
        for (int i = 0; i < columns - text.length(); ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public void add(String string) {
        columns = Math.max(columns,string.length());
        list.add(string);
    }
}
