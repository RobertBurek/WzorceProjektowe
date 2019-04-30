package pl.robworkjava;

/**
 * Created by Robert Burek
 */
public class LoggerOld {

    private static LoggerOld instance;

    public LoggerOld() {
    }

//    synchronizacja całej metody spowolni działanie
//    public static synchronized Logger getInstance() {

    public static synchronized LoggerOld getInstance() {
        if (LoggerOld.instance == null) {
            instance = new LoggerOld();
            return instance;
        } else {
            return instance;
        }
    }

    public void logToConsole(){
        // kod
    }
}
