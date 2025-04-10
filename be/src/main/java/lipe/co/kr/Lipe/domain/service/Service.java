package lipe.co.kr.Lipe.domain.service;

import jakarta.persistence.*;
import lipe.co.kr.Lipe.domain.category.Subcategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter @NoArgsConstructor
@Table(name = "services")
public class Service {
    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    private String description;

    @Column(name = "homepage_url", nullable = false)
    private String homepageUrl;

    @Column(name = "avg_rating")
    private Float avgRating;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // N:M 관계 (서비스 : 서브카테고리)
    @ManyToMany(mappedBy = "service")
    private Set<Subcategory> subcategories = new HashSet<>();

    // 1:N 관계 (서비스 : 플랜)
    @OneToMany(mappedBy = "plans", cascade = CascadeType.ALL)
    private List<Plan> plans = new ArrayList<>();
}