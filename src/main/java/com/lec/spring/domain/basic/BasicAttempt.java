package com.lec.spring.domain.basic;

import com.lec.spring.domain.Listener.BasicAttemptHistoryListener;
import com.lec.spring.domain.Listener.PostHistoryListener;
import com.lec.spring.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "basic_attempt")
@EntityListeners(BasicAttemptHistoryListener.class)
public class BasicAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userAnswer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "BasicQuestion_id")
    private BasicQuestion basicQuestion;

    private String corret;

}
