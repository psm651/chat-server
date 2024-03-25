package com.toy.chat;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@ToString
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
// MongoDB Chatting 모델
public class Chatting {

    @Id
    private String id;
    private Integer chatRoomNo;
    private Integer senderNo;
    private String senderName;
    private String contentType;
    private String content;
    private LocalDateTime sendDate;
    private long readCount;

}