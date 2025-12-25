package com.rohitprajapati.websocket_service.dto;

import lombok.*;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MessageResponse {
      String name ;
      String message;
}
