package sample.LogFactory;

public class DataBaseLog implements Log {
    String logType = "DATABASE";

    @Override
    public String writeLog(String logText) {
        System.out.println(this.logType+": "+logText);
        return this.logType+": "+logText;
    }
}
