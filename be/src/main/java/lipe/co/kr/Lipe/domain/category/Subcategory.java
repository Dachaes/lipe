package lipe.co.kr.Lipe.domain.category;

import jakarta.persistence.*;
import lipe.co.kr.Lipe.domain.service.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "subcategories")
public class Subcategory {
    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    // N:1 관계 (서브카테고리 : 카테고리)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // N:M 관계 (서브카테고리 : 서비스)
    @ManyToMany
    @JoinTable(
            name = "subcategory_service",
            joinColumns = @JoinColumn(name = "subcategory_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services = new HashSet<>();
}