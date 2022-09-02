public class Main {
    public static void main(String[] args) {
        /*if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);
        bs.print();*/

        String sample = "101-02331-09867717-665252551-111";
        BigString bs = new BigString(sample, true);
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Used (shared version): " + used);

        bs = new BigString(sample, false);
        Runtime.getRuntime().gc();
        used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Used (unshared version): " + used);

    }
}
