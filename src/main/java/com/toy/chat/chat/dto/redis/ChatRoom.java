package com.toy.chat.chat.dto.redis;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash(value = "chatRoom")
public class ChatRoom {

    @Id
    private String id;

    @Indexed
    private Integer chatroomNo;

    @Indexed
    private String email;

    @Builder
    public ChatRoom(Integer chatroomNo, String email) {
        this.chatroomNo = chatroomNo;
        this.email = email;
    }
}