package com.lec.spring.domain.share;

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
    @ColumnDefault(value = "0")
    private Long viewCnt = 0L;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
