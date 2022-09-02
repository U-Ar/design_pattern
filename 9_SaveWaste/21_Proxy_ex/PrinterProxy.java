public class PrinterProxy implements Printable {
    private String name;
    private Printable real;
    private String realclass;

    public PrinterProxy(String realclass) {
        this.name = "No Name";
        this.real = null;
        this.realclass = realclass;
    }

    public PrinterProxy(String name, String realclass) {
        this.name = name;
        this.real = null;
        this.realclass = realclass;
    }

    @Override
    public synchronized void setPrinterName(String name){
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            try {
                real = (Printable)Class.forName(realclass).getDeclaredConstructor(String.class).newInstance(name);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + realclass + " is not found.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
