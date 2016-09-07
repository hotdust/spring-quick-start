package hello;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    final private MessageService service;

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
    
    @PostConstruct
    public void setup(){
    	System.out.println("called after construct");
    }
    
    @PreDestroy
    public void cleanup(){
    	System.out.println("called before destroy");
    }
}