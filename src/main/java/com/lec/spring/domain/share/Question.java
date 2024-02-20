package com.lec.spring.domain.share;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.spring.domain.Listener.BaseEntity;
import com.lec.spring.domain.Listener.PostHistoryListener;
import com.lec.spring.domain.Listener.ShareQuestionHistoryListener;
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
@Entity(name = "a_question")
@EntityListeners(ShareQuestionHistoryListener.class)
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
    @ColumnDefault(value = "0")
    private Long viewCnt = 0L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShareComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Answer> answers = new ArrayList<>();

}
