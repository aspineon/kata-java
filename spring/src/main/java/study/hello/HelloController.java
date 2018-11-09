package study.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "world") String name) {
        return new Greeting(name, String.format("Hello, %s!", name));
    }
}
