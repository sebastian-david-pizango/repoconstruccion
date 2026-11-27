package pe.edu.uni.demospringproductor;

import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.ObjectMapper;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControllerPost2 {
    @Autowired 
    JmsTemplate jmsTemplate;

    @PostMapping("/enviar")
    public Map<String, Object> postMethodName(@RequestBody Map<String, Object> entity) {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(entity);
        jmsTemplate.convertAndSend("cola.sgdp", json);
        System.out.println(">>> Mensaje enviado correctamente a MQ");
        return entity;
    }
    
}