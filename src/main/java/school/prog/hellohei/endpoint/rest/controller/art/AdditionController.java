package school.prog.hellohei.endpoint.rest.controller.art;

import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdditionController {
  @GetMapping("/add")
  public long addition(@RequestParam long a, @RequestParam long b) {
    Sentry.logger().info("A simple log message");
    Sentry.logger().error("A %s log message", "formatted");
    try {
      throw new Exception("This is a test.");
    } catch (Exception e) {
      Sentry.captureException(e);
    }
    if (a < 0 || b < 0) {
      log.warn("Negative inputs are not allowed");
    } else if (a + b < 0) {
      log.error("Inputs are too large");
    }
    return a + b;
  }
}
