//package com.lec.spring.service.userCode;
//
//import com.lec.spring.service.basic.BasicQuestionService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//@Service
//@CrossOrigin
//@RestController
//public class InputService {
//    private final BasicQuestionService basicQuestionService;
//
//
//
//    public InputService(BasicQuestionService basicQuestionService) {
//        this.basicQuestionService = basicQuestionService;
//    }
//
//    public String getInputExample() {
//        Random random = new Random();
//        int firstNumber = random.nextInt(100) + 1; // 1에서 100 사이의 랜덤한 정수
//        int secondNumber = random.nextInt(100) + 1; // 1에서 100 사이의 랜덤한 정수
//        return firstNumber + " " + secondNumber; // 랜덤한 두 정수를 반환
//    }
//
//    public String getExpectedOutputExample(int randomInt1, int randomInt2, double randomDouble1, double randomDouble2, char randomChar, long questionId) {
//        if (questionId == 1L) {
//            return String.format("%d * %d = %d\n%d / %d = %d",
//                    randomInt1, randomInt2, randomInt1 * randomInt2,
//                    randomInt1, randomInt2, randomInt1 / randomInt2);
//        }
//
//        if (questionId == 2L) {
//            return String.format("%.2f\n%.2f\n%c", randomDouble1, randomDouble2, randomChar);
//        }
//
//        return "유효하지 않은 questionId";
//    }
//
//    @GetMapping("/api/usercode/getRandomValue")
//    public ResponseEntity<Map<String, Object>> getRandomValue(@RequestParam long id) {
//        Random random = new Random();
//        int randomNumber1 = random.nextInt(500) + 1;
//        int randomNumber2 = random.nextInt(500) + 1;
//        while (randomNumber1 == randomNumber2) {
//            randomNumber2 = random.nextInt(500) + 1;
//        }
//
//        // 로깅 추가: 랜덤 값 생성 확인
//        System.out.println("Generated Random Values: randomNumber1 = " + randomNumber1 + ", randomNumber2 = " + randomNumber2);
//
//        double randomDouble1 = Math.random() * 100.0;
//        double randomDouble2 = Math.random() * 100.0;
//        char randomChar = (char) ('A' + random.nextInt(
//
//        26));
//
//        Map<String, Object> response = new HashMap<>();
//        if (id == 1L) {
//            response.put("randomNumber1", randomNumber1);
//            response.put("randomNumber2", randomNumber2);
//        } else if (id == 2L) {
//            response.put("randomNumber1", randomDouble1);
//            response.put("randomNumber2", randomDouble2);
//            response.put("randomChar", String.valueOf(randomChar));
//        }
//
//        return ResponseEntity.ok(response);
//    }
//
//}
