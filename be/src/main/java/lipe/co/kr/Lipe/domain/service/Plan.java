package lipe.co.kr.Lipe.domain.service;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter @NoArgsConstructor
@Table(name = "plans")
public class Plan {
    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String currency;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "subscribe_url")
    private String subscribeUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    // N:1 관계 (플랜 : 서비스)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
}
