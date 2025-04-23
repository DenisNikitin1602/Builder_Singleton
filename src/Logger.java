import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;
    protected int num = 1;

    private Logger() {}

    public static Logger getInstance() {
        if(logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("[" + now.format(formatter) +" " + num++ + "] " + msg);
    }
}
