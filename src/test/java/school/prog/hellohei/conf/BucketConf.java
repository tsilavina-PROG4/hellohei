package school.prog.hellohei.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import school.prog.hellohei.PojaGenerated;

@PojaGenerated
public class BucketConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.s3.bucket", () -> "dummy-bucket");
  }
}
