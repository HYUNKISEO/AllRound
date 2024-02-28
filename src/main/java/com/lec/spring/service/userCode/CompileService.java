//package com.lec.spring.service.userCode;
//
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//
//@Service
//public class CompileService {
//
//    public String DATA_FILE_PATH;
//
//    public String compileAndExecuteCode(String code, String inputExample, String example, long id) throws IOException {
//        String compileOutputDir = "D:\\KDT907\\Dropbox\\K16\\CodingTest\\temp" + id;
//
//        String compileResult = compileJavaCode(code, DATA_FILE_PATH, compileOutputDir);
//        if (!compileResult.equals("컴파일 성공")) {
//            return compileResult;
//        }
//
//        String executeResult = executeJavaClass(compileOutputDir, id, inputExample);
//        return executeResult;
//    }
//
//    public String compileJavaCode(String code, String tempFilePath, String compileOutputDir) {
//        try {
//            try (FileWriter fileWriter = new FileWriter(tempFilePath)) {
//                fileWriter.write(code);
//            }
//
//            ProcessBuilder compileProcessBuilder = new ProcessBuilder("javac", "-d", compileOutputDir, tempFilePath);
//            compileProcessBuilder.redirectErrorStream(true);
//            Process compileProcess = compileProcessBuilder.start();
//
//            StringBuilder compileErrorOutput = new StringBuilder();
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(compileProcess.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    compileErrorOutput.append(line).append("\n");
//                }
//            }
//
//            int compileExitValue = compileProcess.waitFor();
//            if (compileExitValue != 0) {
//                String compileErrors = compileErrorOutput.toString();
//                return parseCompileErrors(compileErrors);
//            }
//        } catch (IOException | InterruptedException e) {
//            return "컴파일 오류: " + e.getMessage();
//        }
//
//        return "컴파일 성공";
//    }
//
//    public String parseCompileErrors(String compileErrors) {
//        if (compileErrors.contains("cannot find symbol")) {
//            return "컴파일 오류: 사용되지 않은 변수나 메소드가 있습니다.";
//        } else if (compileErrors.contains("incompatible types")) {
//            return "컴파일 오류: 타입이 일치하지 않습니다.";
//        }
//
//        return "컴파일 오류: 알 수 없는 오류가 발생했습니다.";
//    }
//
//    public String executeJavaClass(String compileOutputDir, Long id, String inputExample) {
//        String className = "Main" + id;
//        String command = String.format("java -cp %s %s", compileOutputDir, className);
//
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", compileOutputDir, className);
//            processBuilder.redirectErrorStream(true);
//            Process process = processBuilder.start();
//
//            // 입력 예시 전달
//            try (OutputStream outputStream = process.getOutputStream()) {
//                outputStream.write(inputExample.getBytes());
//                outputStream.flush();
//            }
//
//            // 실행 결과 로깅
//            StringBuilder output = new StringBuilder();
//            try (InputStream inputStream = process.getInputStream();
//                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    output.append(line).append("\n");
//                }
//            }
//
//            int exitValue = process.waitFor();
//            if (exitValue == 0) {
//                System.out.println("Execution output: \n" + output.toString());
//                return output.toString();
//            } else {
//                String errorMessage = "Execution error with exit code: " + exitValue;
//                System.err.println(errorMessage);
//                return errorMessage;
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            return "실행 오류: " + e.getMessage();
//        }
//    }
//
//    public void logExecutionResult(String result) {
//        System.out.println("Execution Result: \n" + result);
//    }
//
//    public void logError(Exception e) {
//        System.err.println("Error occurred: " + e.getMessage());
//    }
//
//    public boolean compareResults(String userOutput, String expectedOutput) {
//        // 유저 코드의 실행 결과와 예상 출력값을 비교
//        return userOutput.trim().equals(expectedOutput.trim());
//    }
//}
