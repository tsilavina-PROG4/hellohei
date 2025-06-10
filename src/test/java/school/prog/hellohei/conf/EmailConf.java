package school.prog.hellohei.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import school.prog.hellohei.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
