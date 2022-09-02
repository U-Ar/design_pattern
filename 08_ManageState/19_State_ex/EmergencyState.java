public class EmergencyState implements State {
    private static EmergencyState singleton = new EmergencyState();

    private EmergencyState() {}

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        
    }

    @Override 
    public void doUse(Context context) {
        context.callSecurityCenter("金庫使用！（非常時）");  
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル！（非常時）");
    }

    @Override 
    public void doPhone(Context context) {
        context.callSecurityCenter("通話！（非常時）");
    }

    @Override 
    public String toString() {
        return "[非常時]";
    }
}
