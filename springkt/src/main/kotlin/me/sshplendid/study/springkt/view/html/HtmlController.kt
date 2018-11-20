package me.sshplendid.study.springkt.view.html

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun root(model: Model) : String {
        model["title"] = "Hello, world!"
        return "blog"
    }
}
