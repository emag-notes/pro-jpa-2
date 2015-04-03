package projpa2.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author tanabe
 */
@Stateless
public class LoggerBean {

  private Logger logger;

  @PostConstruct
  void init() {
    logger = Logger.getLogger("notification");
    logger.info("set up notification logger");
  }

  @PreDestroy
  void cleanup() {
    logger.info("clean up!");
  }

  public void logMessage(String message) {
    logger.info(message);
  }

}
