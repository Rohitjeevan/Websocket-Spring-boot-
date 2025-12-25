package com.rohitprajapati.websocket_service.controller;

import com.rohitprajapati.websocket_service.dto.MessageRequest;
import com.rohitprajapati.websocket_service.dto.MessageResponse;
import com.rohitprajapati.websocket_service.dto.TestRequest;
import com.rohitprajapati.websocket_service.dto.TestResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public TestController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/ping")
    @SendTo("/topic/ping")
    public TestResponse pingCheck(TestRequest testRequest) {
        System.out.println("Message received: " + testRequest.getData());
        return  TestResponse.builder().Data(testRequest.getData()).build();
    }


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public MessageResponse  SendMessage (MessageRequest messageRequest){
        System.out.println("Message is Received"+ messageRequest.getName() + " message: " + messageRequest.getMessage());
        return MessageResponse.builder().name(messageRequest.getName()).message(messageRequest.getMessage()).build();
    }

//    @Scheduled(fixedDelay = 2000)
//    public void sendPeriodicMessage() {
//       this.simpMessagingTemplate.convertAndSend("/topic/scheduled","Periodic Message Sent"+ TestResponse.builder().build());
//    }

}
