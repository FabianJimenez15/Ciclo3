package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Message;
import com.mintic.Reto3.Repository.Crud.MessageCrudRepositoryInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
        @Autowired
        private MessageCrudRepositoryInterfaz messageCrudRepositoryInterfaz;
        
    public List <Message> getMessageALL(){
        return (List<Message>) messageCrudRepositoryInterfaz.findAll();
    }    
        
     public Optional <Message> GetMessageId(Integer id){
         return messageCrudRepositoryInterfaz.findById(id);
     }   
     
     public Message saveMessage(Message message){
         return messageCrudRepositoryInterfaz.save(message);
     }
     public void deleteMessage(Message message) {
        messageCrudRepositoryInterfaz.delete(message);
    }
}