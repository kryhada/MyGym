package sample.LogFactory;

public class LogFactory {

    public Log getLog(String logType){
        switch (logType){
            case "ERROR":
                return new ErrorLog();

            case "LOGIN":
                return new LoginLog();

            case "DATABASE":
                return new DataBaseLog();
        }
        return null;
    }

}
