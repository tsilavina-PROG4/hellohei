package school.prog.hellohei.endpoint.rest.controller.hello;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.prog.hellohei.PojaGenerated;
import school.prog.hellohei.endpoint.rest.service.hello.HelloWorldService;

@PojaGenerated
@RestController
@AllArgsConstructor
public class HelloController {

  private final HelloWorldService service;
  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/hello")
  public String helloWorld(@RequestParam String name) {
    return service.uploadHelloWorldMessage(name);
  }
}
