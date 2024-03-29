package goorm.wherebnb.domain.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class UserChat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userChatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Chat chat;

    @Builder
    public UserChat(User user, Chat chat) {
        this.user = user;
        this.chat = chat;
    }

    //==연관관계 편의 메서드 ==//
    public void setUser(User user) {
        this.user = user;
        user.getUserChats().add(this);
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        chat.getUserChats().add(this);
    }
}
