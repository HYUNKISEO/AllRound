package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @JsonProperty("create_time")
    private LocalDateTime createTime;
}
