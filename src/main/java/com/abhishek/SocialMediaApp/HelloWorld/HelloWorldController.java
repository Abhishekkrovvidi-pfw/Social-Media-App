package com.abhishek.SocialMediaApp.HelloWorld;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        super();
        this.messageSource=messageSource;
    }
        @RequestMapping(method = RequestMethod.GET,path="/hello")
        public String HelloWorld(){
            return "HelloWorld";
        }
        @GetMapping(path = "/helloWorld")
        public HelloWorldBean HelloWorldBean(){
            return new HelloWorldBean("HelloWorld");
        }
        @GetMapping(path = "/helloWorld/{name}")
        public HelloWorldBean HelloWorldBeanPathVariable(@PathVariable String name){
            return new HelloWorldBean(String.format("Hello World,%s", name));
        }
    @GetMapping(path="/hello-world-int")
    public String HelloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
           return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
    }

