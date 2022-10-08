package com.mintic.Reto3.Controller;

import com.mintic.Reto3.Model.Category;
import com.mintic.Reto3.Model.Message;
import com.mintic.Reto3.Service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
//@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    public List<Message> getMessageAll(){
            return messageService.getMessageAll();
    
    }
    @GetMapping("/id")
    public Optional <Message> getMessageId(@PathVariable("id")int identificador){
        return messageService.getMessageid(identificador);
    
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage (@RequestBody Message message){
    return messageService.saveMessage(message);
    }
}
