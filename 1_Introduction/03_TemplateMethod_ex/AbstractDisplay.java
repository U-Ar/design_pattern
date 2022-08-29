/* public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; ++i) {
            print();
        }
        close();
    }
}*/

// インタフェースにするにあたり、displayも抽象メソッドにしたうえでdefault実装を提供する
public interface AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public default void display() {
        open();
        for (int i = 0; i < 5; ++i) {
            print();
        }
        close();
    }
}
