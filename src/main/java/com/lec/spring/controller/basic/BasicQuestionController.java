package com.lec.spring.controller.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.domain.basic.UserCode;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.user.UserRepository;
import com.lec.spring.repository.usercode.UserCodeRepository;
import com.lec.spring.service.basic.BasicQuestionService;
import com.lec.spring.service.basic.CodeExecutionService;

import com.lec.spring.service.basic.CompileService;
import com.lec.spring.service.basic.InputService;
import com.lec.spring.service.user.UserService;
import com.lec.spring.service.userCode.UserCodeService;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@RestController
@RequestMapping("/basic/questions")
@CrossOrigin
public class BasicQuestionController {


    private final CodeExecutionService codeExecutionService;
    private final InputService inputService;
    private final CompileService compileService;
    private final BasicQuestionService basicQuestionService;
    private final UserCodeRepository userCodeRepository;
    private final UserCodeService userCodeService; // UserCodeService 주입
    private final UserService userService;
    public BasicQuestionController(CodeExecutionService codeExecutionService, InputService inputService,  CompileService compileService, UserRepository userRepository, BasicQuestionService basicQuestionService, UserCodeRepository userCodeRepository, UserCodeService userCodeService, UserService userService) {
        this.codeExecutionService = codeExecutionService;
        this.inputService = inputService;
        this.compileService = compileService;
        this.basicQuestionService = basicQuestionService;
        this.userCodeRepository = userCodeRepository;
        this.userCodeService =userCodeService;
        this.userService = userService;
    }

    @PostMapping("/save/{questionId}/{id}")
    public ResponseEntity<?> save(@PathVariable(name = "questionId") long questionId, @PathVariable(name = "id") long id, @RequestBody Map<String, Object> requestBody) throws IOException, InterruptedException {
        // 입력 값 검증

        int randomInt1 = ((Number) requestBody.get("randomNumber1")).intValue();
        int randomInt2 = ((Number) requestBody.get("randomNumber2")).intValue();
        double randomDouble1 = ((Number) requestBody.get("randomNumber1")).doubleValue();
        double randomDouble2 = ((Number) requestBody.get("randomNumber2")).doubleValue();
        char randomChar = (requestBody.get("randomChar") != null) ? ((String) requestBody.get("randomChar")).charAt(0) : 'A';



        // 사용자 코드 수정
        String userCode = requestBody.get("code").toString();
        System.out.println(userCode);
        String ogCode = requestBody.get("code").toString();

        // 코드 실행 및 결과 로깅
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now();

        // getRandomValue 메소드를 호출하여 랜덤 값을 가져옴
        Map<String, Object> randomValues = getRandomValue(questionId);

        // randomValues를 이용하여 inputExample 문자열 구성
        String inputExample = ""; // 초기값 설정
        if (questionId == 1L) {
            // questionId 1에 대한 입력 예시 구성
            inputExample = randomInt1 + "\n" + randomInt2;
        } else if (questionId == 2L) {
            // questionId 2에 대한 입력 예시 구성
            inputExample = randomDouble1 + "\n" + randomDouble2 + "\n" + randomChar;
        }else if (questionId == 3L) {
            inputExample = randomInt1 +"\n" + randomInt2;
        }
        userCode = codeExecutionService.modifyUserCode(userCode, id, randomDouble1, randomDouble2, randomChar, randomInt1, randomInt2);
        System.out.println("rrrrrrrr"+userCode);
        // 코드 실행
        String result = compileService.compileAndExecuteCode(userCode, ogCode, inputExample,  questionId, id);
//        String result = new String(compileService.compileAndExecuteCode(userCode, ogCode, inputExample, questionId, id).getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        System.out.println(result);

        System.out.println(result + "확인확인확인" + result);
        System.out.println(userCode);
        // 예상 출력 생성
        String expectedOutputExample =inputService.getExpectedOutputExample(randomInt1, randomInt2, randomDouble1, randomDouble2, randomChar, questionId);
        if (questionId==4L){

        }
        System.out.println("왜값이 바뀐지 확인하자! : 같은입력을받았음유저코드 : "+result+"\n같은입력을받았음정답코드 : "+expectedOutputExample);
        // 결과 비교

        System.out.println("마지막확인 : "+result);
        boolean isCorrect = compileService.compareResults(result, expectedOutputExample);

        if (isCorrect) {
            // 정답인 경우, 문제를 푸는 데 걸린 시간 등을 포함하여 UserCode 엔티티 저장
            BasicQuestion question = basicQuestionService.findById(questionId); // 문제 정보 조회
            UserCode userCodeEntity = UserCode.builder()
                    .user(userService.findById(id))
                    .question(basicQuestionService.findById(questionId))
                    .code(ogCode)
                    .problemStartTime(startTime)
                    .problemEndTime(endTime)
                    .title(question.getTitle())
                    .createTime(startTime)
                    .build();

            userCodeRepository.save(userCodeEntity);
            return ResponseEntity.ok("정답입니다!\n\n예상 출력:\n" + expectedOutputExample + "\n\n유저의 출력:\n" + result);
        } else {
            return ResponseEntity.ok("오답입니다.\n\n예상 출력:\n" + expectedOutputExample + "\n\n유저의 출력:\n" + result);
        }
    }


    @GetMapping("/getRandomValue")
    private Map<String, Object> getRandomValue(@RequestParam long questionId) {// 퍼블릭
        Random random = new Random();
        Map<String, Object> values = new HashMap<>();

        int randomNumber1 = random.nextInt(500) + 1;
        int randomNumber2 = random.nextInt(500) + 1;

        double randomDouble1 = Math.random() * 100.0;
        double randomDouble2 = Math.random() * 100.0;
        char randomChar = (char) ('A' + random.nextInt(26));

        if (questionId == 1L) {
            // randomNumber1이 randomNumber2보다 클 때까지 randomNumber2를 재생성
            while (randomNumber1 <= randomNumber2) {
                randomNumber2 = random.nextInt(500) + 1;
            }
            // 최종 값을 맵에 저장
            values.put("randomNumber1", randomNumber1);
            values.put("randomNumber2", randomNumber2);
            System.out.println("getRandomValue 메소드 생성 값Generated Random Values: randomNumber1 = " + randomNumber1 + ", randomNumber2 = " + randomNumber2);

            return values;
        } else if (questionId == 2L) {
            values.put("randomNumber1", randomDouble1);
            values.put("randomNumber2", randomDouble2);
            values.put("randomChar", String.valueOf(randomChar));

            return values;
        } else if (questionId == 3L) {
            // 문제 3에 대한 검증 로직 추가
            values.put("randomNumber1", randomNumber1);
            values.put("randomNumber2", randomNumber2);
            return values;
        }else if (questionId == 4L) {
            values.put("randomNumber1", randomNumber1);
            values.put("randomNumber2", randomNumber2);
        }

        return values;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<BasicQuestion>> getAllQuestions(
            @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<BasicQuestion> questionsPage = basicQuestionService.findAll(pageNumber, pageSize);
        return ResponseEntity.ok(questionsPage);
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody BasicQuestion basicQuestion) {
        BasicQuestion updatedQuestion = basicQuestionService.update(basicQuestion);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        String resultMessage = basicQuestionService.delete(id);
        return new ResponseEntity<>(resultMessage, HttpStatus.OK);
    }
}
