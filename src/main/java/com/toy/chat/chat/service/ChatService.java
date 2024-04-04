package com.toy.chat.chat.service;

public interface ChatService {
    // 읽지 않은 메시지 채팅장 입장시 읽음 처리
    void updateCountAllZero(Integer chatRoomNo, String email);

    void updateMessage(String email, Integer chatRoomNo);
}
