package com.cooory.ponderpal.common;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
//    public static final String FILE_UPLOAD_PATH = "/Users/cory/Desktop/Backend_Bootcamp2/7_SpringProject/upload/
    public static final String FILE_UPLOAD_PATH = "/Users/cory/Desktop/Backend_Bootcamp2/6_Spring/workspace/PonderPal/src/main/resources/static/upload";

    public static String saveFile(int userId, MultipartFile file) {
        if (file == null) {
            return null;
        }

        // 같은 파일이름 처리
        // 디렉토리(폴더)만들어서 파일 저장
        // 로그인 사용자의 userId 를 디렉토리 이름에 포함
        // 현재 시간 정보를 디렉토리 이름에 포함
        // UNIX TIME : 1970년 1월 1일 기준으로 흐른 시간을 milli second(1/1000) 단위로 표현한 방식
        // ex) /2_328973298

        String directoryName = "/" + userId + "_" + System.currentTimeMillis();

        // 디렉토리 생성 (폴더 생성)

        String directoryPath = FILE_UPLOAD_PATH + directoryName;

        File directory = new File(directoryPath);

        if (!directory.mkdir()) {
            // 디렉토리 생성 실패
            return null;
        }

        // 파일 저장
        String filePath = directoryPath + "/" + file.getOriginalFilename();

        try {
            byte[] bytes = file.getBytes();

            Path path = Paths.get(filePath);
            Files.write(path, bytes);

        } catch (IOException e) {

            e.printStackTrace();

            // 파일 저장실패
            return null;
        }


        // 클리이언트에서 접근가능한 url 규칙을 만들고 해당 문자열을 리턴
        // 파일 경로 : D:\\dulumaryT\\web\\230915\\springProject\\upload\\memo/2_9140918290/test.png
        // 경로 규칙 : /images/2_9140918290/test.png

        return "/upload" + directoryName + "/" + file.getOriginalFilename();

    }
}
