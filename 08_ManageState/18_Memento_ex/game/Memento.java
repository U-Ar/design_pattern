package game;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;
    private List<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money){
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    // インスタンスが持つ情報をファイルに保存する。成功でtrue失敗でfalse
    public static boolean saveToFile(String filename, Memento memento) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d", memento.money));
        sb.append("\n");

        for (String f: memento.getFruits()) {
            sb.append(f);
            sb.append("\n");
        }

        try {
            Files.writeString(Path.of(filename), sb,
             StandardOpenOption.CREATE,
             StandardOpenOption.TRUNCATE_EXISTING,
             StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    // ファイル情報からインスタンスを生成する。失敗でnullを返す
    public static Memento loadFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            if (lines.size() == 0) {
                System.out.println("Empty file");
                return null;
            }

            int money = 0;
            try {
                money = Integer.parseInt(lines.get(0));
            } catch (NumberFormatException e) {
                System.out.println("Format error: " + e);
                return null;
            }

            Memento memento = new Memento(money);

            for (int i = 1; i < lines.size(); ++i) {
                memento.addFruit(lines.get(i));
            }

            return memento;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}