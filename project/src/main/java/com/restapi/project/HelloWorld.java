package com.restapi.project;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HelloWorld {
    private String message;
    @Override
    public String toString(){
        return "HelloWorld [message=" + message + "]"; //MappingJackson2HttpMessageConverter this jackson mapper will by default convert the bean into json.
    }
}
