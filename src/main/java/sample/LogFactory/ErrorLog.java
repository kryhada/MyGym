package sample.LogFactory;

public class ErrorLog implements Log {
    String logType = "ERROR";

    @Override
    public String writeLog(String logText) {
        System.out.println(this.logType+": "+logText);
        return this.logType+": "+logText;
    }
}

