package lab2;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {

        LocalTime now = LocalTime.now();
        String greeting;

        if (now.isBefore(LocalTime.NOON)) {
            greeting = "Good morning, Rubiya, Welcome to COMP367";
        } else {
            greeting = "Good afternoon, Rubiya, Welcome to COMP367";
        }

        return greeting;
    }
}