package com.restapi.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldResource {
    @GetMapping("/hello")
    public HelloWorld helloWorld() {
        return new HelloWorld("welcome");
    }
// Path variable or Path param
        @GetMapping("/path-param/{name}/{message}")
                public HelloWorld pathParam(@PathVariable String name, @PathVariable String message){
            return new HelloWorld("welcome," + name+ "! " + message);
        }


}
