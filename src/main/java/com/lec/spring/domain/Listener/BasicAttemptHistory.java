package com.lec.spring.domain.Listener;

import com.lec.spring.domain.basic.BasicAttempt;
import com.lec.spring.domain.board.Post;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity(name = "basic_history")
public class BasicAttemptHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "basic_attempt_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private BasicAttempt basicAttempt;

    private String content;

    private String type = "기본문제";
}
