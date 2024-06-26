package com.toy.chat.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Getter
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "out_yn")
    private String outYn;

    @Column(name = "denined_yn")
    private String deninedYn;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "platform")
    private String platform;

    @Column(name = "profile")
    private String profile;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "nickmod_date")
    private LocalDateTime nickModDate;

    @Column(name = "passmod_date")
    private LocalDateTime passModDate;

//    @OneToMany(mappedBy = "member")
//    private List<AdoptBookmark> adoptBookmarkList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Comment> commentList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "receiver")
//    private List<Notification> receiverList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "sender")
//    private List<Notification> senderList = new ArrayList<>();

    public void addProfileImage(String imgUrl) {
        this.profile = imgUrl;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }
}
