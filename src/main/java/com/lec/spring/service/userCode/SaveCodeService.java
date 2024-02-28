//package com.lec.spring.service.userCode;
//import com.lec.spring.repository.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Service
//@CrossOrigin(origins = "http://localhost:3000")
//
//public class SaveCodeService {
//
//
//    private String DATA_FILE_PATH;
//    private Long id;
//
//    @Autowired
//    public SaveCodeService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//        this.id = 1L; // 기본 ID 설정
//        initializeDataFilePath();
//    }
//
//    public SaveCodeService(Long id, UserRepository userRepository) {
//        this.userRepository = userRepository;
//        this.id = id;
//        initializeDataFilePath();
//    }
//
//    private void initializeDataFilePath() {
//        this.DATA_FILE_PATH = "D:\\KDT907\\Dropbox\\K16\\CodingTest\\temp" + id + "\\Main" + id + ".java";
//        createDirectoryIfNeeded("D:\\KDT907\\Dropbox\\K16\\CodingTest\\temp" + id);
//    }
//
//
//    private void createDirectoryIfNeeded(String directoryPath) {
//        File directory = new File(directoryPath);
//        if (!directory.exists()) {
//            if (directory.mkdirs()) {
//                System.out.println("// 디렉토리가 성공적으로 생성되었습니다.");
//            } else {
//                System.out.println("// 디렉토리 생성 실패");
//            }
//        }
//    }
//    private final UserRepository userRepository;
//
//
//    public Long getUserId(Long id) {
//        if (userRepository != null && id != null) { // userRepository가 null인지 확인
//            // userRepository를 사용하여 ID의 존재 여부를 확인
//            boolean exists = userRepository.existsById(id);
//            if (exists) {
//                return id;
//            }
//        }
//        return 1L; // ID가 null이거나 존재하지 않으면 기본값으로 1L 반환
//    }
//
//    public String modifyUserCode(String code, double randomDouble1, double randomDouble2, char randomChar, int randomInt1, int randomInt2, long id) {
//        // 원본 코드를 파일로 저장
//        saveOriginalCodeToFile(code, id);
//
//        // Scanner 객체를 제거
//        code = code.replaceAll("(Scanner\\s+\\w+\\s*=\\s*new\\s+Scanner\\(System\\.in\\);[^\\(]*\\(System\\.in\\);(.*?\\n)?)", "");
//
//        code = code.replaceAll("Scanner [a-zA-Z_][a-zA-Z_0-9]* = new Scanner\\(System.in\\)", "");
//
//
//
//        code = code.replaceAll("Main", "Main" + id);
//        String name = "";
//
//        // 정규 표현식을 사용하여 int[] 변수명 추출
//        Pattern pattern = Pattern.compile("int\\[\\]\\s+(\\w+)\\s*=");
//        Matcher matcher = pattern.matcher(code);
//        code = removeComments(code);
//        if (matcher.find()) {
//            name = matcher.group(1).trim(); // 변수명만 추출하여 name에 저장
//
//            code = code.replaceAll("\\b" + name + "\\[.*?\\] =", "");
//
//            code = code.replaceAll("\\w+\\.nextInt\\(\\);", name + "[0] = " + randomInt1 + ";\n\t\t\t " + name + "[1] = " + randomInt2 + ";");
//        } else if (id == 1L) {
//            code = code.replaceFirst("\\w+\\.nextInt\\(\\);", String.valueOf(randomInt1) + ";");
//            code = code.replaceFirst("\\w+\\.nextInt\\(\\);", String.valueOf(randomInt2) + ";");
//        }
//        code = code.replaceAll("scanner\\.close\\(\\);", "");
//
//        // 로깅: 수정된 코드 확인
//        System.out.println("Modified user code: \n" + code);
//
//        return code;
//    }
//
//
//
//    private String removeComments(String code) {
//        // 여러 줄 주석 제거
//        code = code.replaceAll("/\\*(.|\\n)*?\\*/", "");
//
//        // 한 줄 주석 제거
//        code = code.replaceAll("//.*", "");
//
//        return code;
//    }
//
//    public void createOriginalMainFile(String originalCode, Long id) {
//        String originalFilePath = "D:\\KDT907\\Dropbox\\K16\\CodingTest\\temp\\" + id + "\\OriginalMain" + id + ".java";
//        File directory = new File(originalFilePath).getParentFile();
//        if (!directory.exists()) directory.mkdirs(); // Ensure the directory path exists
//        try (FileWriter fileWriter = new FileWriter(originalFilePath)) {
//            fileWriter.write(originalCode);
//            System.out.println("OriginalMain" + id + ".java 생성 완료: " + originalFilePath);
//        } catch (IOException e) {
//            System.err.println("OriginalMain" + id + ".java 생성 실패: " + e.getMessage());
//        }
//    }
//
//    public void saveOriginalCodeToFile(String originalCode, Long id) {
//
//        String originalFilePath = "D:\\KDT907\\Dropbox\\K16\\CodingTest\\temp\\" + id + "\\OriginalMain" + id + ".java";
//        File directory = new File(originalFilePath).getParentFile();
//        if (!directory.exists()) directory.mkdirs(); // Ensure the directory path exists
//        try (FileWriter fileWriter = new FileWriter(originalFilePath)) {
//            fileWriter.write(originalCode);
//            System.out.println("OriginalMain" + id + ".java 생성 완료: " + originalFilePath);
//        } catch (IOException e) {
//            System.err.println("OriginalMain" + id + ".java 생성 실패: " + e.getMessage());
//        }
//    }
//
//    public void saveUserCodeToFile(String modifiedCode, Long id) {
//        Long userId = getUserId(id);
//        String modifiedFilePath = "D:\\KDT907\\Dropbox\\K16\\CodingTest\\temp\\" + userId + "\\Main" + userId + ".java";
//        File directory = new File(modifiedFilePath).getParentFile();
//        if (!directory.exists()) directory.mkdirs(); // Ensure the directory path exists
//        try (FileWriter fileWriter = new FileWriter(modifiedFilePath)) {
//            fileWriter.write(modifiedCode);
//            System.out.println("Modified user code saved to file: " + modifiedFilePath);
//        } catch (IOException e) {
//            System.err.println("Failed to save modified user code to file: " + e.getMessage());
//        }
//    }
//}
//
