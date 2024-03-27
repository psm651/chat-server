package com.toy.chat.chat.repository;

import com.toy.chat.chat.dto.redis.ChatRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {

    List<ChatRoom> findByChatroomNo(Integer chatRoomNo);

    Optional<ChatRoom> findByChatroomNoAndEmail(Integer chatRoomNo, String email);
}