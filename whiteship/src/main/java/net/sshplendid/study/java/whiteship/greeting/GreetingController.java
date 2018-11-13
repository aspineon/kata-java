package net.sshplendid.study.java.whiteship.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingController {

    private static final String GREETING_TEMPLATE = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(GREETING_TEMPLATE, name));
    }
}
