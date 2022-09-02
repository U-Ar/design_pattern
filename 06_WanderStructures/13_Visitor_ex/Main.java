import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) throws IOException {
        System.out.println("dir: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        System.out.println("file: " + file);
        return FileVisitResult.CONTINUE;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        bindir.add(new File("vi",10000));
        bindir.add(new File("latex",20000));

        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usrdir.add(yuki);
        usrdir.add(hanako);
        usrdir.add(tomura);
        yuki.add(new File("diary.html",100));
        yuki.add(new File("Composite.java",200));
        hanako.add(new File("memo.tex", 300));
        hanako.add(new File("index.html", 350));
        tomura.add(new File("game.doc", 400));
        tomura.add(new File("junk.mail",500));

        ListVisitor lv = new ListVisitor();
        rootdir.accept(lv);
        
        FileFindVisitor ffv = new FileFindVisitor(".html");
        rootdir.accept(ffv);

        System.out.println("HTML files are:");
        for (File file: ffv.getFoundFiles()) {
            System.out.println(file);
        }


        if (args.length != 1) {
            System.out.println("Usage: java Main dirname");
            System.exit(0);
        }
        String dirname = args[0];
        try {
            MyFileVisitor visitor = new MyFileVisitor();
            Path root = Path.of(dirname);
            Files.walkFileTree(root, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
