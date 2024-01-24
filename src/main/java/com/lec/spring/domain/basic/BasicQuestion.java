package com.lec.spring.domain.basic;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "basic_question")
public class BasicQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String exampleInput;
    private String exampleOutput;
    private String comment;
    private String input;
    private String output;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "basic_question_id")
    @ToString.Exclude
    @Builder.Default
    private List<BasicAttempt> basicAttempts = new ArrayList<>();

}
