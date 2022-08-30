public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, world."));
        RandomDisplay d3 = new RandomDisplay(new StringDisplayImpl("Hello, Universe."));
        CountDisplay d4 = new CountDisplay(new FileDisplayImpl("hoge.txt"));

        d1.display();
        d2.display();
        d3.display();
        d3.randomDisplay(5);
        //d3.randomDisplay(5);
        //d3.randomDisplay(5);
        d4.multiDisplay(3);
    }
}
