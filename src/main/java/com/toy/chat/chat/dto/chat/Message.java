package com.toy.chat.chat.dto.chat;


import com.toy.chat.Chatting;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private String id;

    @NotNull
    private Integer chatNo;

    @NotNull
    private String contentType;

    @NotNull
    private String content;

    private String senderName;

    private Integer senderNo;

    @NotNull
    private Integer saleNo;

    private long sendTime;
    private Integer readCount;
    private String senderEmail;

    public void setSendTimeAndSender(LocalDateTime sendTime, Integer senderNo, String senderName, Integer readCount) {
        this.senderName = senderName;
        this.sendTime = sendTime.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli();
        this.senderNo = senderNo;
        this.readCount = readCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Chatting convertEntity() {
        return Chatting.builder()
                .senderName(senderName)
                .senderNo(senderNo)
                .chatRoomNo(chatNo)
                .contentType(contentType)
                .content(content)
                .sendDate(Instant.ofEpochMilli(sendTime).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime())
                .readCount(readCount)
                .build();
    }
}
