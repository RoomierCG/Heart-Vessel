package Springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class helloWorld {

    @RequestMapping("/")
    public String index() {
        return "Hola Mundo";
    }



}
