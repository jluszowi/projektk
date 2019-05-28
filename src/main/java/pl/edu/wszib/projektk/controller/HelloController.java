package pl.edu.wszib.projektk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hellopage(){
        return "hello!!!";
    }

    @GetMapping("/test")
    public String testpage(){
        return "To jest test!!!" + HelloController.class.getCanonicalName();
    }

}
