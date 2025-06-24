package school.prog.hellohei.service.art;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArtService {

  @SneakyThrows
  public Long add(Long a, Long b) {
    var sum = a + b;
    return sum;
  }
}
