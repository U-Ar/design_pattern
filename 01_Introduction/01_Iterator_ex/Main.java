import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // BookShelf bookShelf = new BookShelf(4);
        // 可変長ArrayListを用いているのでインスタンス化に最大長は不要
        BookShelf bookShelf = new BookShelf();

        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        // 明示的にIteratorを使う方法
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 拡張for文を使う方法
        for (Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
