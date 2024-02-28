package com.lec.spring.domain.basic;

import com.lec.spring.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.Duration;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "user_code")
public class UserCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCodeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private BasicQuestion question; // 문제와의 관계 설정

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "LONGTEXT")
    private String code; // 유저가 제출한 코드

    private String title;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createTime; // 정답 코드 작성 시간

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastcodeCreateTime; // 마지막 코드 작성 시간

    @Column(columnDefinition = "LONGTEXT")
    private String lastCode; // 유저가 마지막으로 작성한 코드

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime problemStartTime; // 문제 시작 시간

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime problemEndTime; // 문제 제출 시간

    // 생성자
    @Builder
    public UserCode(User user, BasicQuestion question, String code, String title, LocalDateTime createTime, LocalDateTime lastcodeCreateTime, String lastCode, LocalDateTime problemStartTime, LocalDateTime problemEndTime) {
        this.user = user;
        this.question = question;
        this.code = code;
        this.title = title;
        this.createTime = createTime;
        this.lastcodeCreateTime = lastcodeCreateTime;
        this.lastCode = lastCode;
        this.problemStartTime = problemStartTime;
        this.problemEndTime = problemEndTime;
    }

    // 문제를 푸는데 걸린 시간 계산
    public long calculateTimeTaken() {
        return Duration.between(problemStartTime, problemEndTime).toMinutes();
    }
}
