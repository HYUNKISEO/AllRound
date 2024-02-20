package com.lec.spring.domain.Listener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.spring.domain.board.Post;
import com.lec.spring.domain.share.Question;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity(name = "a_share_history")
public class ShareQuestionHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Question question;

    private String content;

    private String type = "공유문제";
}
