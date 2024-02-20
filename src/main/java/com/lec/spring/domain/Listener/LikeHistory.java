package com.lec.spring.domain.Listener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lec.spring.domain.share.Like;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity(name = "a_Like_history")
public class LikeHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Like_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Like like;

    private String content;

    private String type = "추천누적";
}
