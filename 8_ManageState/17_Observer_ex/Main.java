public class Main {
    public static void main(String[] args) { 
        NumberGenerator generator = new IncrementalNumberGenerator(10,50,5);
        Observer ob1 = new DigitObserver();
        Observer ob2 = new GraphObserver();
        Observer ob3 = new SumObserver();
        generator.addObserver(ob1);
        generator.addObserver(ob2);
        generator.addObserver(ob3);
        generator.execute();
    }
}
