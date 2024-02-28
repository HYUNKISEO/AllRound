package com.lec.spring.service.basic;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CodeExecutionService {
    public String modifyUserCode(String code, Long id, double randomDouble1, double randomDouble2, char randomChar, int randomInt1, int randomInt2, long questionId) {
        // 클래스 이름 변경 및 주석 제거 로직
        String name = "";
        code = code.replaceAll("Main", "MainUserId" + id); // Main 클래스 이름을 MainUserId{id}로 변경


        return code;
    }
}
