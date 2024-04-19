package kr.pah.pcs.yestv.global.directoryInitializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DirectoryInitializer implements ApplicationRunner {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void run(ApplicationArguments args) {
        // 프로젝트 root 디렉토리에 upload 디렉토리를 만듭니다.
        Path directoryPath = Paths.get(uploadDir);

        // 이미 폴더가 존재하면 return
        if (Files.exists(directoryPath)) {
            System.out.println("Upload directory already exists: " + directoryPath);
            return;
        }

        try {
            Files.createDirectory(directoryPath);
            System.out.println("Upload directory created: " + directoryPath);
        } catch (Exception e) {
            System.err.println("Failed to create upload directory: " + e.getMessage());
        }
    }
}