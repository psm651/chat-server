package com.toy.chat.chat.service;

import com.toy.chat.chat.dto.redis.ChatRoom;
import com.toy.chat.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;


    @Transactional
    public void connectChatRoom(Integer chatRoomNo, String email) {
        ChatRoom chatRoom = ChatRoom.builder()
                        .email(email)
                        .chatroomNo(chatRoomNo)
                        .build();

        chatRoomRepository.save(chatRoom);
    }

    @Transactional
    public void disconnectChatRoom(Integer chatRoomNo, String email) {
        ChatRoom chatRoom = chatRoomRepository.findByChatroomNoAndEmail(chatRoomNo, email)
                        .orElseThrow(IllegalStateException::new);

        chatRoomRepository.delete(chatRoom);
    }

    public boolean isAllConnected(Integer chatRoomNo) {
        List<ChatRoom> connectedList = chatRoomRepository.findByChatroomNo(chatRoomNo);
        return connectedList.size() == 2;
    }

    public boolean isConnected(Integer chatRoomNo) {
        List<ChatRoom> connectedList = chatRoomRepository.findByChatroomNo(chatRoomNo);
        return connectedList.size() == 1;
    }
}