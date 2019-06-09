import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstTest {
    private static final Logger logger = LogManager.getLogger(FirstTest.class);

    public static void main(String[] args) {

        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARN");
    }

}