package me.sshplendid.study.springkt.api.greeting

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicInteger


@RestController
@RequestMapping("/api/greeting")
class GreetingController {

    val counter = AtomicInteger()

    @GetMapping
    fun greeting(@RequestParam(defaultValue = "World") name: String) : ResponseEntity<Greeting> {
        val greeting: Greeting = Greeting(counter.incrementAndGet(), name, String.format("Hello, %s!", name))

        return ResponseEntity.ok(greeting)
    }
}

