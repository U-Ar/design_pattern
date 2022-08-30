import java.io.*;

public class MarkdownBuilder implements Builder {
    private String filename = "untitled.md";
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = title + ".md";
        sb.append("# ");
        sb.append(title);
        sb.append("\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String s: items) {
            sb.append("- ");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        try {
            Writer writer = new FileWriter(filename);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMarkdownResult() {
        return filename;
    }
}
