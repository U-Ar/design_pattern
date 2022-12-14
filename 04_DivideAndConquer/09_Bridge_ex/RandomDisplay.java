public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        int rand = (int)Math.floor(Math.random()*times);
        open();
        for (int i = 0; i < rand; ++i) {
            print();
        }
        close();
    }
}
