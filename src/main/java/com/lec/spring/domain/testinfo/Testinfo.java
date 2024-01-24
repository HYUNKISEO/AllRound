package com.lec.spring.domain.testinfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity (name = "a_testinfo")
public class Testinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String docregstartdt;
    private String docregenddt;
    private String docexamstartdt;
    private String docexamenddt;
    private String docpassdt;
    private String pracregstartdt;
    private String pracregenddt;
    private String pracexamstartdt;
    private String pracexamenddt;
    private String pracpassstartdt;
    private String pracpassenddt;
    private String implplannm;
    private String jmfldnm;
    private String contents;
}
