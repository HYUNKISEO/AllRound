package com.lec.spring.domain.board;

import com.lec.spring.domain.BaseEntity;
import com.lec.spring.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "a_post")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String contents;

    @Column(nullable = false)
    private String category;

    @ColumnDefault(value = "0")
    private Long viewCnt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    @Builder.Default
    private List<PostComment> comments = new ArrayList<>();
}
