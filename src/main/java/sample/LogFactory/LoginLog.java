package sample.LogFactory;

public class LoginLog implements Log {
    String logType = "LOGIN";

    @Override
    public String writeLog(String logText) {
        System.out.println(this.logType+": "+logText);
        return this.logType+": "+logText;
    }
}
