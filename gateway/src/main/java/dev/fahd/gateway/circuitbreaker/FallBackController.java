package dev.fahd.gateway.circuitbreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/user-service")
    public String userServiceFallBack() {
        return "User Service is not available right now. Try again later!";
    }
}
