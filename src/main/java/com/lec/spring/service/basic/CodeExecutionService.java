package com.lec.spring.service.basic;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CodeExecutionService {
    public String modifyUserCode(String code, Long id, double randomDouble1, double randomDouble2, char randomChar, int randomInt1, int randomInt2, int... randomInts) {



        String name = "";
        code = code.replaceAll("sc\\.next\\(\\)\\.charAt\\(0\\);", "\"" + randomChar + "\".charAt(0); // replaced with provided char input");
        // 정규 표현식을 사용하여 int[] 변수명 추출
        Pattern pattern = Pattern.compile("int\\[\\]\\s+(\\w+)\\s*=");
        Matcher matcher = pattern.matcher(code);

//        // "Scanner scanner = new Scanner(System.in);" 삭제
//        // "System.out.print("당신의 나이는 몇 살입니까? ");" 삭제
//        // "int age = scanner.nextInt();"를 "int age = randomInt1;"로 대체
//        code = code.replaceAll("Scanner scanner = new Scanner\\(System.in\\);\\s*", ""); // Scanner 선언 부분 삭제
////        code = code.replaceAll("System.out.print\\(\"당신의 나이는 몇 살입니까\\? \"\\);\\s*", ""); // System.out.print 삭제
//        code = code.replace("scanner.nextInt();", ""+ randomInt1 +";"); // scanner.nextInt();를 randomInt1로 대체
////        code = code.replace("System.out.print(\"당신의 나이는 몇 살입니까? \");", "");
//

        if (matcher.find()) {
            name = matcher.group(1).trim(); // 변수명만 추출하여 name에 저장
            code = code.replaceAll("\\b" + name + "\\[.*?\\] =", "");
            code = code.replaceAll("\\w+\\.nextInt\\(\\);", name + "[0] = " + randomInt1 + ";\n\t\t\t " + name + "[1] = " + randomInt2 + ";");
        }

        code = code.replaceAll("scanner\\.close\\(\\);", "");

        StringBuffer sb = new StringBuffer(code.length());

        // int 입력 처리
        Pattern intPattern = Pattern.compile("\\w+\\.nextInt\\(\\);");
        Matcher intMatcher = intPattern.matcher(code);
        int countInt = 0;
        while (intMatcher.find()) {
            if (countInt < randomInts.length) {
                String replacement = String.valueOf(randomInts[countInt]) + "; // replaced with provided int input";
                intMatcher.appendReplacement(sb, replacement);
                countInt++;
            } else {
                break; // randomInts 배열의 크기를 초과하는 경우
            }
        }
        intMatcher.appendTail(sb);
        code = sb.toString();

        // double 입력 처리
        sb = new StringBuffer(code.length()); // StringBuffer 초기화
        Pattern doublePattern = Pattern.compile("\\w+\\.nextDouble\\(\\);");
        Matcher doubleMatcher = doublePattern.matcher(code);
        int countDouble = 0; // randomDouble 값들을 처리하기 위한 카운터
        while (doubleMatcher.find()) {
            if (countDouble == 0) {
                String replacement = randomDouble1 + "; // replaced with provided double input";
                doubleMatcher.appendReplacement(sb, replacement);
                countDouble++;
            } else if (countDouble == 1) {
                String replacement = randomDouble2 + "; // replaced with provided double input";
                doubleMatcher.appendReplacement(sb, replacement);
                countDouble++;
            } else {
                break; // 더 이상 처리할 randomDouble 값이 없는 경우
            }
        }
        doubleMatcher.appendTail(sb);
        code = sb.toString();

        // 클래스 이름 변경 및 주석 제거 로직
        code = code.replaceAll("Main", "MainUserId" + id);
        code = code.replaceAll("//.*", ""); // 한 줄 주석 제거
        code = code.replaceAll("/\\*([\\s\\S]*?)\\*/", ""); // 블록 주석 제거
        return code;
    }
}
