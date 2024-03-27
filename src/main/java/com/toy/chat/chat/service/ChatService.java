package com.toy.chat.chat.service;

public interface ChatService {
    void updateCountAllZero(Integer chatRoomNo, String email);

    void updateMessage(String email, Integer chatRoomNo);
}
