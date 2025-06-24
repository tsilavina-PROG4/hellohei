package school.prog.hellohei.endpoint.rest.controller.art;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.prog.hellohei.PojaGenerated;
import school.prog.hellohei.service.art.ArtService;

@PojaGenerated
@RestController
@AllArgsConstructor
public class ArtController {

  private final ArtService service;
  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/add")
  public Long helloWorld(@RequestParam Long a, @RequestParam Long b) {
    return service.add(a, b);
  }
}
