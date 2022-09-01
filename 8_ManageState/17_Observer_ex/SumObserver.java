public class SumObserver implements Observer {
    private int acc = 0;

    @Override 
    public void update(NumberGenerator generator) {
        acc += generator.getNumber();
        System.out.println("Sumobserver (acc sum):" + acc);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            
        }
    }
}
