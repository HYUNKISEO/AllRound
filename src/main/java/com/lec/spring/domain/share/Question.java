package com.lec.spring.domain.share;

import com.lec.spring.domain.BaseEntity;
import com.lec.spring.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "a_question")
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;
    private String exampleInput;
    @Column(nullable = false)
    private String exampleOutput;
    private String comment;
    @Column(nullable = false)
    private String answer;
    private String input;
    private String output;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    @Builder.Default
    private List<ShareComment> comments = new ArrayList<>();

}
