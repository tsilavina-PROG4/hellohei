package school.prog.hellohei.endpoint.event;

import jakarta.mail.internet.InternetAddress;
import java.util.function.Consumer;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import school.prog.hellohei.endpoint.event.model.SendEmailRequested;
import school.prog.hellohei.mail.Email;
import school.prog.hellohei.mail.Mailer;

@Service
@AllArgsConstructor
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {

  private final Mailer mailer;

  @SneakyThrows
  @Override
  public void accept(SendEmailRequested sendEmailRequested) {
    InternetAddress recipientAddress = new InternetAddress(sendEmailRequested.getTo());
    mailer.accept(
        new Email(recipientAddress, List.of(), List.of(), "", "... world!", List.of()));
  }
}
