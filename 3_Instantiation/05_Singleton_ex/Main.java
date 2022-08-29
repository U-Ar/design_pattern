public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Triple obj1 = Triple.getInstance("ALPHA");
        Triple obj2 = Triple.getInstance("ALPHA");
        if (obj1 == obj2) {
            System.out.println(obj1);
            System.out.println("obj1とobj2は同じインスタンスです。");
        } else {
            System.out.println("obj1とobj2は違うインスタンスです。");
        }
        Triple obj3 = Triple.getInstance("BETA");
        if (obj1 == obj3) {
            System.out.println("obj1とobj3は同じインスタンスです。");
        } else {
            System.out.println(obj3);
            System.out.println("obj1とobj3は違うインスタンスです。");
        }
        System.out.println("End.");
    }
}
