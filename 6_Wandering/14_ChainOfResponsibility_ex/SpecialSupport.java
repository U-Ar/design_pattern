public class SpecialSupport extends Support {
    private int special;

    public SpecialSupport(String name, int special) {
        super(name);
        this.special = special;
    }

    @Override 
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == special) {
            return true;
        } else {
            return false;
        }
    }
}
