package net.sshplendid.study.java.whiteship.events;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final AtomicInteger counter = new AtomicInteger();

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event body) {
        body.setId(counter.incrementAndGet());
        return ResponseEntity.ok(body);
    }
}
