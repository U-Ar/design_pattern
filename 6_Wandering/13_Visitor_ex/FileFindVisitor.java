import java.util.List;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor {
    private List<File> foundfiles = new ArrayList<File>();
    String extension = "";

    public FileFindVisitor(String extension) {
        this.extension = extension;
    }

    @Override 
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            foundfiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (Entry entry: directory) {
            entry.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return foundfiles;
    }
}
