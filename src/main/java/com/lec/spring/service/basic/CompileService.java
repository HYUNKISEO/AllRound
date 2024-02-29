package com.lec.spring.service.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.basic.BasicQuestionRepository;
import com.lec.spring.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class CompileService {

    private final UserRepository userRepository;
    private final BasicQuestionRepository basicQuestionRepository;

    @Autowired
    public CompileService(UserRepository userRepository, BasicQuestionRepository basicQuestionRepository) {
        this.userRepository = userRepository;
        this.basicQuestionRepository = basicQuestionRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public BasicQuestion getQuestionById(Long questionId) {
        return basicQuestionRepository.findById(questionId).orElse(null);
    }

    public String compileAndExecuteCode(String code, String ogCode, String inputExample, long questionId, long id) throws IOException, InterruptedException {
        User user = getUserById(id);
        String compileOutputDir = "D:\\KDT907\\Dropbox\\AllRound\\questionNo" + questionId;
        createDirectoryIfNeeded(compileOutputDir);
        String compileFilePath = compileOutputDir + "\\MainUserId" + id + ".java";
        String originalFilePath = compileOutputDir + "\\OriginalMainUserId" + id + ".java";
        saveOriginalCodeToFile(ogCode, originalFilePath);
        String compileResult = compileJavaCode(code, compileFilePath, compileOutputDir);
        System.out.println(compileResult + "뚱원뚱원");
        if (!compileResult.equals("컴파일 성공")) {
            return new String(compileResult.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        }

        return executeJavaClass(compileOutputDir, user.getId(), inputExample);
    }

    private void saveOriginalCodeToFile(String originalCode, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(originalCode);
            System.out.println("원본 코드 저장 완료: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("원본 코드 저장 실패: " + e.getMessage());
        }
    }

    public void createDirectoryIfNeeded(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() && !directory.mkdirs()) {
            System.out.println("디렉토리 생성 실패: " + directoryPath);
        }
    }

    private String compileJavaCode(String code, String filePath, String compileOutputDir) {
        try {
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
                writer.write(code);
            }
            ProcessBuilder compileProcessBuilder = new ProcessBuilder("javac", "-encoding", "UTF-8", "-d", compileOutputDir, filePath);
            compileProcessBuilder.redirectErrorStream(true);
            Process compileProcess = compileProcessBuilder.start();

            StringBuilder compileErrorOutput = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(compileProcess.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    compileErrorOutput.append(line).append("\n");
                }
            }

            int compileExitValue = compileProcess.waitFor();
            if (compileExitValue != 0) {
                return compileErrorOutput.toString();
            }
        } catch (IOException | InterruptedException e) {
            return "컴파일 오류: " + e.getMessage();
        }

        return "컴파일 성공";
    }

    private String executeJavaClass(String compileOutputDir, long id, String inputExample) {
        String className = "MainUserId" + id;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", compileOutputDir, className);
            Map<String, String> env = processBuilder.environment();
            env.put("LANG", "ko_KR.UTF-8"); // 환경 변수에 UTF-8 인코딩을 명시하여 한국어 처리 보장
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            if (inputExample != null && !inputExample.isEmpty()) {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8))) {
                    writer.write(inputExample);
                    writer.flush();
                }
            }

            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            int exitValue = process.waitFor();
            if (exitValue == 0) { // 정상 종료 코드
                return output.toString();
            } else {
                return "실행 오류, 종료 코드: " + exitValue + "\n" + output.toString();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "실행 오류: " + e.getMessage();
        }
    }

    public boolean compareResults(String userOutput, String expectedOutput) {
        return userOutput.trim().equals(expectedOutput.trim());
    }
}
