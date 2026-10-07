package Train.Ticket.Recovery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/ticket")
    public String ticket() {
        return "forward:/ticket.html";
    }
}