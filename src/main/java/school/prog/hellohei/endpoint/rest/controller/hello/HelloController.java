package school.prog.hellohei.endpoint.rest.controller.hello;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.mail.internet.InternetAddress;
import school.prog.hellohei.PojaGenerated;
import school.prog.hellohei.mail.Email;
import school.prog.hellohei.mail.Mailer;
import school.prog.hellohei.service.hello.HelloWorldService;

@PojaGenerated
@RestController
@AllArgsConstructor
public class HelloController {

  private final Mailer mailer;
  private final HelloWorldService service;
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
    var email =
        new Email(
            new InternetAddress(to), List.of(), List.of(), "Hello world", "... world!", List.of());

    mailer.accept(email);
    return "... world!";
  }
}
