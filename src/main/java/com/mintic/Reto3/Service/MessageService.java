package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Message;
import com.mintic.Reto3.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired    
    private MessageRepository messageRepository;
    
    public List<Message> getMessageAll(){
    return messageRepository.getMessageALL();
    }
    public Optional <Message> getMessageid(Integer id){
        return messageRepository.GetMessageId(id);
        
    }
    public Message saveMessage (Message message){
        if(message.getIdMessage()==null){
            return messageRepository.saveMessage(message);
        }else{
            Optional <Message>  messageAuxiliar = messageRepository.GetMessageId(message.getIdMessage());
            if (messageAuxiliar.isEmpty()){
            return  messageRepository.saveMessage(message);
            }else{
            return message;
            }
        }
    }
}