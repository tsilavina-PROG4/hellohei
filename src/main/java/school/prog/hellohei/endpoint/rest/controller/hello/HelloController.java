package school.prog.hellohei.endpoint.rest.controller.hello;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.prog.hellohei.PojaGenerated;
import school.prog.hellohei.endpoint.event.EventProducer;
import school.prog.hellohei.endpoint.event.model.SendEmailRequested;
import school.prog.hellohei.service.hello.HelloWorldService;

@PojaGenerated
@RestController
@AllArgsConstructor
public class HelloController {

  private final HelloWorldService service;
  private final EventProducer<SendEmailRequested> eventProducer;
  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/hello")
  public String helloWorld(@RequestParam String name) {
    return service.uploadHelloWorldMessage(name);
  }

  @GetMapping("/hellomail")
  @SneakyThrows
  public String helloWorldToMail(@RequestParam String to) {
    var event = SendEmailRequested.builder().to(to).build();
    eventProducer.accept(List.of(event));
    return "... world!";
  }
}
