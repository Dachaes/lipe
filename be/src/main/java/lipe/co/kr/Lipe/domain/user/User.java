package lipe.co.kr.Lipe.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users") // 테이블 이름 지정
public class User {
    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column(unique = true)
    private String nickname;

    @Column(name = "login_type")
    private String loginType; // ex: Google, Kakao 등

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "push_notification")
    private Boolean pushNotification;

    @Column(name = "email_notification")
    private Boolean emailNotification;

    // 빌더
    @Builder
    public User(String email, String password, String nickname,
                String loginType, LocalDateTime createdAt) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.loginType = loginType;
        this.createdAt = createdAt;
        this.pushNotification = false;
        this.emailNotification = false;
    }
}