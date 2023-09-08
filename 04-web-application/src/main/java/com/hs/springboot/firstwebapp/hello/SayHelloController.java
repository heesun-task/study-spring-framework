package com.hs.springboot.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller: return the name of the view
@Controller
public class SayHelloController {

    // http://localhost:8080/hello
//     @ResponseBody: return the string as it is
    @RequestMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html><body><h1>");
        sb.append("Hello World");
        sb.append("</h1></body></html>");
        return sb.toString();
    }

    // src/main/resources/META-INF/resources/WEB-INF/jsp/hello.jsp
    // src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    @RequestMapping("hello-jsp")
    public String sayHelloJsp() {
        return "hello";
    }

}
