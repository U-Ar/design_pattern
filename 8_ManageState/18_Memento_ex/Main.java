import game.Gamer;
import game.Memento;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = Memento.loadFromFile("game.dat");
        if (memento == null) {
            memento = gamer.createMemento();
        } else {
            gamer.restoreMemento(memento);
        }

        for (int i = 0; i < 100; ++i) {
            System.out.println("==== " + i);
            System.out.println("現状:" + gamer);

            gamer.bet();

            System.out.println("所持金は"+gamer.getMoney()+"円になりました。");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("※だいぶ増えたので、現状を保存しておこう");
                memento = gamer.createMemento();
                if (Memento.saveToFile("game.dat", memento)) {
                    System.out.println("現在の状態をファイルに保存しました。");
                }
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("※だいぶ減ったので、以前の状態を復元しよう");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println();
        }
    }
}
