package me.sshplendid.study.springjava.api.greeting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public ResponseEntity<Greeting> greeting(@RequestParam(defaultValue = "World") String name) {
        return ResponseEntity.ok(new Greeting(counter.incrementAndGet(), name));
    }
}
