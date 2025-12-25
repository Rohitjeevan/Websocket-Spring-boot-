package com.rohitprajapati.websocket_service.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MessageRequest {
    String name ;
    String message;
}
