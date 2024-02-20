package com.lec.spring.domain.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.spring.domain.Listener.BaseEntity;
import com.lec.spring.domain.Listener.UserHistory;
import com.lec.spring.domain.Listener.UserHistoryListener;
import com.lec.spring.domain.basic.BasicAttempt;
import com.lec.spring.domain.board.Post;
import com.lec.spring.domain.board.PostComment;
import com.lec.spring.domain.share.Answer;
import com.lec.spring.domain.share.Like;
import com.lec.spring.domain.share.Question;
import com.lec.spring.domain.share.ShareComment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "a_user")
@EntityListeners(UserHistoryListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Transient   // DB 에 반영 안함. (영속화 하지 않음)
    @ToString.Exclude  // toString() 결과에서 뺌.
    @JsonIgnore
    private String re_password;  // 비밀번호 확인 입력

    @Column(nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private List<Authority> authorities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PostComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<BasicAttempt> basicAttempts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShareComment> shareComments = new ArrayList<>();



}
