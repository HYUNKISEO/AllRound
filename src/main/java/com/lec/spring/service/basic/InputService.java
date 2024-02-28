package com.lec.spring.service.basic;

import org.springframework.stereotype.Service;

@Service
public class InputService {
    public String getExpectedOutputExample(int randomInt1, int randomInt2, double randomDouble1, double randomDouble2, char randomChar, long questionId) {
        if (questionId == 1L) {
            // 문제 1에 대한 예상 출력 예시 생성
            return String.format("%d * %d = %d\n%d / %d = %d",
                    randomInt1, randomInt2, randomInt1 * randomInt2,
                    randomInt1, randomInt2, randomInt1 / randomInt2);
        } else if (questionId == 2L) {
            // 문제 2에 대한 예상 출력 예시 생성
            return String.format("%.2f\n%.2f\n%c", randomDouble1, randomDouble2, randomChar);
        }else if (questionId == 3L) {
            // 질문 생성 및 반환
            return String.format("%d + %d = %d\n%d - %d = %d\n%d * %d = %d\n%d / %d = %d\n%d %% %d = %d",
                    randomInt1, randomInt2, randomInt1 + randomInt2,
                    randomInt1, randomInt2, randomInt1 - randomInt2,
                    randomInt1, randomInt2, randomInt1 * randomInt2,
                    randomInt1, randomInt2, randomInt1 / randomInt2,
                    randomInt1, randomInt2, randomInt1 % randomInt2);
        }else if (questionId == 4L) {
            return String.format("%d - %d = %d",randomInt1, randomInt2, Math.abs(randomInt1 - randomInt2));

        }else if (questionId == 5L) {
                // 문제 5에 대한 예상 출력 예시 생성

                if (randomInt1 == 0) {
                    return randomInt1+"\nzero";
                } else if (randomInt1 > 0) {
                    return randomInt1+"\nplus";
                } else {
                    return randomInt1+"\nminus";
                }

        }
        else {
            // 유효하지 않은 questionId에 대한 처리
            return "유효하지 않은 questionId";
        }
    }
}
