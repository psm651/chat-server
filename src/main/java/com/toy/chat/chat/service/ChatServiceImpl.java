package com.toy.chat.chat.service;

import com.toy.chat.Chatting;
import com.toy.chat.chat.dto.chat.Message;
import com.toy.chat.security.util.JwtUtil;
import com.toy.chat.user.domain.Member;
import com.toy.chat.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final MessageSender sender;
    private final MongoTemplate mongoTemplate;
    private final ChatRoomService chatRoomService;
    @Value("${value.kafka.topic")
    private String topic;


    @Override
    public void updateCountAllZero(Integer chatNo, String email) {
        Member findMember = memberRepository.findByEmail(email)
                .orElseThrow(IllegalStateException::new);

        Update update = new Update().set("readCount", 0);
        Query query = new Query(Criteria.where("chatRoomNo").is(chatNo)
                .and("senderNo").ne(findMember.getMemberNo()));

        mongoTemplate.updateMulti(query, update, Chatting.class);
    }

    @Override
    public void updateMessage(String email, Integer chatRoomNo) {
        Message message = Message.builder()
                .contentType("notice")
                .chatNo(chatRoomNo)
                .content(email + " 님이 돌아오셨습니다.")
                .build();

        sender.send(topic, message);
    }
}
