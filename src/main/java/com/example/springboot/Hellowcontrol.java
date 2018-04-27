package com.example.springboot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Hellowcontrol {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "这是我的第一个用Intellij IDEA创建的springboot例子";
    }
}
