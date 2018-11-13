package net.sshplendid.study.java.whiteship.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(defaultValue = "World") String name) {
        final String template = "Hello, %s!";
        return String.format(template, name);
    }
}
