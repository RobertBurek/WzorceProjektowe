package pl.robworkjava;

/**
 * Created by Robert Burek
 */
public class Logger {

    private static Logger instance;

    public Logger() {
    }

    public static  Logger getInstance() {
      return SingletonHolder.INSTANCE;
      // Bill Pugh
    }

    public void logToConsole(){
        // kod
    }

    private static class SingletonHolder{
        private static final Logger INSTANCE = new Logger();
    }
}
